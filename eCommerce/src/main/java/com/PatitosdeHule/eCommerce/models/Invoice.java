package com.PatitosdeHule.eCommerce.models;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    private PaymentMethods paymentMethods;
    private ShippingType shippingType;
    private String invoice_number;
    private double total_value;
    private LocalDateTime date;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER)
    private Set<ProductList> productLists = new HashSet<>();


    public Invoice() {
    }

    ;

    public Invoice(Client client, PaymentMethods paymentMethods, ShippingType shippingType, String invoice_number, double total_value, LocalDateTime date) {

        this.client = client;
        this.paymentMethods = paymentMethods;
        this.shippingType = shippingType;
        this.invoice_number = invoice_number;
        this.total_value = total_value;
        this.date = date;

    }

    @JsonIgnore
    public long getId() {
        return id;
    }
    @JsonIgnore
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public Set<ProductList> getArticles() {
        return productLists;
    }

    public void addArticles(ProductList productList) {
        productList.setInvoice(this);
        productLists.add(productList);
    }

}