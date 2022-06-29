package com.PatitosdeHule.eCommerce.DTOs;
import com.PatitosdeHule.eCommerce.models.Invoice;
import com.PatitosdeHule.eCommerce.models.PaymentMethods;
import com.PatitosdeHule.eCommerce.models.ShippingType;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class InvoiceDTO {

    private long id;
    private PaymentMethods paymentMethods;
    private ShippingType shippingType;
    private String invoice_number;
    private double total_value;
    private LocalDateTime date;
    private Set<ProductListDTO> articlesDTO = new HashSet<>();

    public InvoiceDTO() {
    }

    public InvoiceDTO(Invoice invoice) {

        this.id = invoice.getId();
        this.paymentMethods = invoice.getPaymentMethods();
        this.invoice_number = invoice.getInvoice_number();
        this.total_value = invoice.getTotal_value();
        this.date = invoice.getDate();
        this.articlesDTO = invoice.getArticles().stream().map(ProductListDTO::new).collect(Collectors.toSet());
        this.shippingType = invoice.getShippingType();

    }

    public long getId() {
        return id;
    }

    public PaymentMethods getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(PaymentMethods paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public ShippingType getShippingType() {
        return shippingType;
    }

    public void setShippingType(ShippingType shippingType) {
        this.shippingType = shippingType;
    }

    public String getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(String invoice_number) {
        this.invoice_number = invoice_number;
    }

    public double getTotal_value() {
        return total_value;
    }

    public void setTotal_value(double total_value) {
        this.total_value = total_value;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Set<ProductListDTO> getArticlesDTO() {
        return articlesDTO;
    }

    public void setArticlesDTO(Set<ProductListDTO> articlesDTO) {
        this.articlesDTO = articlesDTO;
    }
}