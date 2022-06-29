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
       Invoice invoice = client.getInvoices().stream().max(Comparator.comparing(Invoice::getId)).orElse(null);
       assert invoice != null;
       String invoice_n = invoice.getInvoice_number();
       LocalDateTime invoice_d = invoice.getDate();
       PaymentMethods pay_method = invoice.getPaymentMethods();
       ShippingType ship = invoice.getShippingType();

       Set<ProductList> articles = invoice.getArticles();

       Document document = new Document (PageSize.A4);

       PdfWriter.getInstance(document, response.getOutputStream());

       document.open();

        Image image = Image.getInstance("https://cdn.discordapp.com/attachments/948544638413844533/991777821510881350/origita.png");
        image.setAbsolutePosition(20, 20);
        image.setWidthPercentage(10f);

        Font font = new Font(Font.BOLD);
        font.setSize(18);

        Font fontSub = new Font(Font.BOLD);
        fontSub.setSize(10);

        Color color = new Color(242, 39, 144, 0.32f);

        Paragraph title = new Paragraph("Invoice's info", font);
        title.setAlignment(Paragraph.ALIGN_LEFT);
        title.setSpacingAfter(12);

        Paragraph invoice_number = new Paragraph("Invoice Number: " + invoice_n, font);
        title.setAlignment(Paragraph.ALIGN_RIGHT);
        title.setSpacingAfter(12);

        Paragraph invoice_date = new Paragraph("Invoice Number: " + invoice_d.format(ISO_LOCAL_DATE), font);
        title.setAlignment(Paragraph.ALIGN_RIGHT);
        title.setSpacingAfter(12);

        Paragraph clientName = new Paragraph("First name: " + name, fontSub);
        clientName.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph clientLastName = new Paragraph("Last Names: " + lastName, fontSub);
        clientLastName.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph pay_meth = new Paragraph("Payment Method: " + pay_method, fontSub);
        clientLastName.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph ship_type = new Paragraph("Shipping Type: " + ship, fontSub);
        clientLastName.setAlignment(Paragraph.ALIGN_LEFT);


        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);

        List<String> headers = new ArrayList<>(List.of(
            "Theme",
            "Name",
            "Size",
            "Quantity",
            "Price"
        ));

        headers.forEach(h -> {

            PdfPCell c1 = new PdfPCell(new Phrase(h));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setVerticalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(color);
            table.addCell(c1);

        });

         Comparator<ProductList> priceComparator = Comparator.comparing(ProductList::getAmount_perProduct);
         articles.stream().sorted(priceComparator.reversed()).forEach( p -> {
             if(p.getProduct().getProductType().equals(ProductType.CLOTHES)) {
                 table.addCell(p.getProduct().getClothesType() + "");
             } else {
                 table.addCell(p.getProduct().getAnimeTheme());
             }

             PdfPCell c2 = new PdfPCell(new Phrase(p.getProduct().getName()));
             c2.setHorizontalAlignment(Element.ALIGN_CENTER);
             c2.setVerticalAlignment(Element.ALIGN_CENTER);
             p.getProduct().getSize().forEach(a -> {
                a.join("[]", "");
             });
             PdfPCell c3 = new PdfPCell(new Phrase(p.getProduct().getSize().stream().map(a -> a.join("[]", "")) + ""));
             c3.setHorizontalAlignment(Element.ALIGN_CENTER);
             c3.setVerticalAlignment(Element.ALIGN_CENTER);
             PdfPCell c4 = new PdfPCell(new Phrase(p.getProduct_quantity() + ""));
             c4.setHorizontalAlignment(Element.ALIGN_CENTER);
             c4.setVerticalAlignment(Element.ALIGN_CENTER);
             PdfPCell c5 = new PdfPCell(new Phrase("$" + p.getProduct().getPrice() + ""));
             c5.setHorizontalAlignment(Element.ALIGN_CENTER);
             c5.setVerticalAlignment(Element.ALIGN_CENTER);

             table.addCell(c2);
             table.addCell(c3);
             table.addCell(c4);
             table.addCell(c5);
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
