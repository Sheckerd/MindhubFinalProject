package com.PatitosdeHule.eCommerce.DTOs;

import com.PatitosdeHule.eCommerce.models.ProductList;

public class ProductListAppDTO {

    private long id;
    private int quantity;


    public ProductListAppDTO(){}

    public ProductListAppDTO(ProductList productList) {
        this.id = getId();
        this.quantity = getQuantity();

    }

    public long getId() {
        return id;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

