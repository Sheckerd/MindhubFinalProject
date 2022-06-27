package com.PatitosdeHule.eCommerce.DTOs;

import com.PatitosdeHule.eCommerce.models.ClothesSize;
import com.PatitosdeHule.eCommerce.models.ProductType;

import java.util.List;

public class CreateCosplayDTO {


    private String name;
    private String description;
    private String imageURL_front;
    private String animeTheme;
    private boolean limitedEdition;
    private ProductType productType;
    private List<String> size;
  
    private int stock;
    private double price;

    public CreateCosplayDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL_front() {
        return imageURL_front;
    }

    public void setImageURL_front(String imageURL_front) {
        this.imageURL_front = imageURL_front;
    }

    public String getAnimeTheme() {
        return animeTheme;
    }

    public void setAnimeTheme(String animeTheme) {
        this.animeTheme = animeTheme;
    }

    public boolean isLimitedEdition() {
        return limitedEdition;
    }

    public void setLimitedEdition(boolean limitedEdition) {
        this.limitedEdition = limitedEdition;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public List<String> getSize() {
        return size;
    }

    public void setSize(List<String> size) {
        this.size = size;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
