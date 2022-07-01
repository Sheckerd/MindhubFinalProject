package com.PatitosdeHule.eCommerce.DTOs;

import com.PatitosdeHule.eCommerce.models.ClothesSize;
import com.PatitosdeHule.eCommerce.models.ClothesType;
import com.PatitosdeHule.eCommerce.models.ProductType;

import java.util.List;

public class CreateClothesDTO {

    private String name;
    private List<String> colors;
    private String description;
    private String imageURL_front;
    private String imageURL_back;
    private String animeTheme;
    private ClothesType clothesType;
    private boolean limitedEdition;
    private ProductType productType;
    private List<String> size;
//     private ClothesSize clothesSize;
    private int stock;
    private double price;

    public CreateClothesDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
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

    public String getImageURL_back() {
        return imageURL_back;
    }

    public void setImageURL_back(String imageURL_back) {
        this.imageURL_back = imageURL_back;
    }

    public String getAnimeTheme() {
        return animeTheme;
    }

    public void setAnimeTheme(String animeTheme) {
        this.animeTheme = animeTheme;
    }

    public ClothesType getClothesType() {
        return clothesType;
    }

    public void setClothesType(ClothesType clothesType) {
        this.clothesType = clothesType;
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
