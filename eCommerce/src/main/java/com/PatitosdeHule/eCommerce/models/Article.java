package com.PatitosdeHule.eCommerce.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private Product product;
    private Invoice invoice;
    private int product_quantity;
    private double amount_perProduct;

    public Article() {}

    public Article (Product product, Invoice invoice, int product_quantity, double amount_perProduct) {

        this.product = product;
        this.invoice = invoice;
        this.product_quantity = product_quantity;
        this.amount_perProduct = amount_perProduct;

    }

    public long getId() {return id;}

    public Product getProduct() {return product;}
    public void setProduct(Product product) {this.product = product;}

    public Invoice getInvoice() {return invoice;}
    public void setInvoice(Invoice invoice) {this.invoice = invoice;}

    public int getProduct_quantity() {return product_quantity;}
    public void setProduct_quantity(int product_quantity) {this.product_quantity = product_quantity;}

    public double getAmount_perProduct() {return amount_perProduct;}
    public void setAmount_perProduct(double amount_perProduct) {this.amount_perProduct = amount_perProduct;}
}
