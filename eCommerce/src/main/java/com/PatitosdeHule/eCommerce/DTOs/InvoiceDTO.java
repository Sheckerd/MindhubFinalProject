package com.PatitosdeHule.eCommerce.DTOs;

import com.PatitosdeHule.eCommerce.models.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class InvoiceDTO {

    private long id;
    private Client client;
    private PaymentMethods paymentMethods;
    private ShippingType shippingType;
    private String invoice_number;
    private double total_value;
    private LocalDateTime date;
    private Set<ArticleDTO> articlesDTO = new HashSet<>();

    public InvoiceDTO() {
    }

    public InvoiceDTO(Invoice invoice) {

        this.id = invoice.getId();
        this.paymentMethods = invoice.getPaymentMethods();
        this.invoice_number = invoice.getInvoice_number();
        this.total_value = invoice.getTotal_value();
        this.date = invoice.getDate();
        this.articlesDTO = invoice.getArticles().stream().map(ArticleDTO::new).collect(Collectors.toSet());

    }

    
}
