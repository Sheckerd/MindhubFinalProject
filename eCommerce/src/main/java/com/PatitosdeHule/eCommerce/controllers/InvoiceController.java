package com.PatitosdeHule.eCommerce.controllers;

import com.PatitosdeHule.eCommerce.DTOs.InvoiceAppDTO;
import com.PatitosdeHule.eCommerce.DTOs.InvoiceDTO;
import com.PatitosdeHule.eCommerce.models.Client;
import com.PatitosdeHule.eCommerce.models.Invoice;
import com.PatitosdeHule.eCommerce.services.ClientService;
import com.PatitosdeHule.eCommerce.services.InvoiceService;
import com.PatitosdeHule.eCommerce.services.PDFGeneratorService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import com.PatitosdeHule.eCommerce.models.ShippingType;
import com.PatitosdeHule.eCommerce.models.PaymentMethods;

import javax.servlet.http.HttpServletResponse;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class InvoiceController {

    @Autowired
    ClientService clientService;

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/invoicesdto")
    public Set<InvoiceDTO> getInvoiceDTOSet() {
        return invoiceService.getSetInvoiceDTO();
    }

    @GetMapping("/invoices")
    public Set<Invoice> getInvoices() {
        return invoiceService.getInvoices();
    }

    @GetMapping("/invoices/last")
    public Invoice getLastInvoiceDTO() {

        return invoiceService.getLastInvoice();
    }

    @GetMapping("/invoices/{id}")
    public InvoiceDTO getInvoice(@PathVariable long id) {
        return invoiceService.getInvoiceDTO(id);
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @PostMapping("/invoices/create")
    public ResponseEntity<Object> createInvoice(Authentication authentication, @RequestBody InvoiceAppDTO invoiceAppDTO) {

        Client client = clientService.getClientCurrent(authentication);


        Invoice invoice = new Invoice(client, invoiceAppDTO.getPaymentMethods(), invoiceAppDTO.getShippingType(), "12345" , 0, LocalDateTime.now());
        invoiceService.saveInvoices(invoice);
        return new ResponseEntity<>("Invoice created", HttpStatus.CREATED);

    }

    @Autowired
    PDFGeneratorService pdfGeneratorService;

    @GetMapping("/invoices/createPDF")
    public void createPDF(HttpServletResponse response, Authentication authentication) throws IOException, DocumentException {

        response.setContentType("application/pdf");
        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd:hh::mm");
        String currentDate = formatDate.format(new Date());

        String headerKey = "Content-disposition";
        String headerValue = "attachment; filename=Origami_Invoice" + currentDate + ".pdf";
        response.setHeader(headerKey, headerValue);

        pdfGeneratorService.PDFGenerator(response, authentication);

    }

}

