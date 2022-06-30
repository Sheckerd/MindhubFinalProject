package
 com.PatitosdeHule.eCommerce.services.implement;

import com.PatitosdeHule.eCommerce.models.*;
import com.PatitosdeHule.eCommerce.services.ClientService;
import com.PatitosdeHule.eCommerce.services.PDFGeneratorService;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.awt.*;
import java.util.Comparator;
import com.lowagie.text.pdf.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.List;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

@Service
public class PDFGeneratorServiceImplement implements PDFGeneratorService {

    @Autowired
    ClientService clientService;

    @Override
        public void PDFGenerator(HttpServletResponse response, Authentication authentication) throws IOException, DocumentException {

           Client client = clientService.getClientByEmail(authentication.getName());
           String name = client.getName();
           String lastName = client.getLastName();
           Invoice invoice = client.getInvoices().stream().max(Comparator.comparing(Invoice::getId)).get();
           String invoice_n = invoice.getInvoice_number();
           LocalDateTime invoice_d = invoice.getDate();
           PaymentMethods pay_method = invoice.getPaymentMethods();
           ShippingType ship = invoice.getShippingType();

           Set<ProductList> articles = invoice.getArticles();

           Document document = new Document (PageSize.A4);

           PdfWriter.getInstance(document, response.getOutputStream());

           document.open();

            Image image = Image.getInstance("https://cdn.discordapp.com/attachments/948544638413844533/991777821510881350/origita.png");
            image.scaleAbsoluteHeight(100f);
            image.scaleAbsoluteWidth(110f);
            image.setAbsolutePosition(35,720);

            Color colorTitle = new Color(241, 152, 152, 255);

            Font font = new Font(Font.STRIKETHRU);
            font.setSize(18);
            font.setColor(colorTitle);

            Font fontSub = new Font(Font.BOLD);
            fontSub.setSize(14);

            Color color = new Color(229, 181, 211, 48);

            Paragraph title = new Paragraph("ORIGAMI SHOP", font);
            title.setAlignment(Paragraph.ALIGN_RIGHT);
            title.setSpacingAfter(14);

            Paragraph invoice_number = new Paragraph("N° " + invoice_n, fontSub);
            invoice_number.setAlignment(Paragraph.ALIGN_RIGHT);
            invoice_number.setSpacingAfter(14);

            Paragraph invoice_date = new Paragraph("Fecha: " + invoice_d.format(ISO_LOCAL_DATE), fontSub);
            invoice_date.setAlignment(Paragraph.ALIGN_RIGHT);
            invoice_date.setSpacingAfter(5);

            Paragraph clientName = new Paragraph("Nombres: " + name, fontSub);
            clientName.setAlignment(Paragraph.ALIGN_LEFT);
            clientName.setSpacingAfter(5);

            Paragraph clientLastName = new Paragraph("Apellidos: " + lastName, fontSub);
            clientLastName.setAlignment(Paragraph.ALIGN_LEFT);
            clientLastName.setSpacingAfter(5);

            Paragraph pay_meth = new Paragraph("Método de pago: " + pay_method, fontSub);
            clientLastName.setAlignment(Paragraph.ALIGN_LEFT);
            pay_meth.setSpacingAfter(5);

            Paragraph ship_type = new Paragraph("Tipo de envío: " + ship, fontSub);
            clientLastName.setAlignment(Paragraph.ALIGN_LEFT);
            ship_type.setSpacingAfter(12);

            float[] columnWidths = {2, 3, 2, 1, 2};
            PdfPTable table = new PdfPTable(columnWidths);
            table.setWidthPercentage(100);

            List<String> headers = new ArrayList<>(List.of(
                "Nombre",
                "Temática",
                "Talles",
                "uds.",
                "Precio"
            ));

            headers.forEach(h -> {

                PdfPCell c1 = new PdfPCell(new Phrase(h));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                c1.setBackgroundColor(color);
                c1.setPaddingBottom(6f);
                c1.setPaddingTop(6f);
                table.addCell(c1);

            });

             Comparator<ProductList> priceComparator = Comparator.comparing(ProductList::getAmount_perProduct);
             articles.stream().sorted(priceComparator.reversed()).forEach( p -> {

                 PdfPCell c3 = new PdfPCell(new Phrase(p.getProduct().getName()));
                 c3.setHorizontalAlignment(Element.ALIGN_CENTER);
                 c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
                 c3.setPaddingBottom(5f);
                 c3.setPaddingTop(5f);
                 table.addCell(c3);

                 if(p.getProduct().getProductType().equals(ProductType.CLOTHES)) {
                     PdfPCell c1 = new PdfPCell(new Phrase(p.getProduct().getClothesType() + ""));
                     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                     c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                     c1.setPaddingBottom(5f);
                     c1.setPaddingTop(5f);
                     table.addCell(c1);
                 } else {
                     PdfPCell c2 = new PdfPCell(new Phrase(p.getProduct().getAnimeTheme() + ""));
                     c2.setHorizontalAlignment(Element.ALIGN_CENTER);
                     c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                     c2.setPaddingBottom(5f);
                     c2.setPaddingTop(5f);
                     table.addCell(c2);
                 }

                 PdfPCell c4 = new PdfPCell(new Phrase(p.getProduct().getSize().toString().replace("[", "").replace("]", "") + ""));
                 c4.setHorizontalAlignment(Element.ALIGN_CENTER);
                 c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
                 c4.setPaddingBottom(5f);
                 c4.setPaddingTop(5f);
                 PdfPCell c5 = new PdfPCell(new Phrase(p.getProduct_quantity() + ""));
                 c5.setHorizontalAlignment(Element.ALIGN_CENTER);
                 c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
                 c5.setPaddingBottom(5f);
                 c5.setPaddingTop(5f);
                 PdfPCell c6 = new PdfPCell(new Phrase("$" + p.getProduct().getPrice() + ""));
                 c6.setHorizontalAlignment(Element.ALIGN_CENTER);
                 c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
                 c6.setPaddingBottom(5f);
                 c6.setPaddingTop(5f);

                 table.addCell(c4);
                 table.addCell(c5);
                 table.addCell(c6);
             });


            document.add(image);
            document.add(title);
            document.add(invoice_number);
            document.add(invoice_date);
            document.add(clientName);
            document.add(clientLastName);
            document.add(pay_meth);
            document.add(ship_type);
            document.add(table);
            document.close();

        }
}
