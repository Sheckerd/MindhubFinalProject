package com.PatitosdeHule.eCommerce.DTOs;

import com.PatitosdeHule.eCommerce.models.ProductList;

public class ProductListDTO {

    private long id;
    private int product_quantity;
    private double amount_perProduct;

    public ProductListDTO() {
    }

    public ProductListDTO(ProductList productList) {

        this.id = productList.getId();
        this.product_quantity = productList.getProduct_quantity();
        this.amount_perProduct = productList.getAmount_perProduct();

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

}
