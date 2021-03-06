package com.PatitosdeHule.eCommerce.models;

import com.PatitosdeHule.eCommerce.DTOs.InvoiceDTO;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ProductList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private int product_quantity;
    private double amount_perProduct;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;


    public ProductList() {
    }


    public ProductList(Product product, int product_quantity, double amount_perProduct, Invoice invoice) {

        this.product = product;
        this.product_quantity = product_quantity;
        this.amount_perProduct = product.getPrice();
        this.invoice = invoice;

    }

    public long getId() {
        return id;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public double getAmount_perProduct() {
        return amount_perProduct;
    }

    public void setAmount_perProduct(double amount_perProduct) {
        this.amount_perProduct = amount_perProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

}
