package com.PatitosdeHule.eCommerce.DTOs;

import com.PatitosdeHule.eCommerce.models.ClothesSize;
import com.PatitosdeHule.eCommerce.models.ClothesType;
import com.PatitosdeHule.eCommerce.models.Product;
import com.PatitosdeHule.eCommerce.models.ProductType;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class ProductDTO {

    private long id;
    private String name;
    private List<String> colors;
    private String description;
    private String imageURL_front;
    private String imageURL_back;
    private String animeTheme;
    private ClothesType clothesType;
    private boolean limitedEdition;
    private ProductType productType;
    private ClothesSize clothesSize;
    private int stock;
    private double price;

    private Set<ArticleDTO> articleDTOSet = new HashSet<>();

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.colors = product.getColor();
        this.description = product.getDescription();
        this.imageURL_front = product.getImageURL_front();
        this.imageURL_back = product.getImageURL_back();
        this.animeTheme = product.getAnimeTheme();
        this.clothesType = product.getClothesType();
        this.limitedEdition = product.isLimitedEdition();
        this.productType = product.getProductType();
        this.clothesSize = product.getClothesSize();
        this.stock = product.getStock();
        this.price = product.getPrice();

        this.articleDTOSet = product.getArticles().stream().map(article -> new ArticleDTO(article)).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getColor() {
        return colors;
    }

    public void setColor(List<String> color) {
        this.colors = color;
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

    public ClothesSize getClothesSize() {
        return clothesSize;
    }

    public void setClothesSize(ClothesSize clothesSize) {
        this.clothesSize = clothesSize;
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




    public Set<ArticleDTO> getArticleDTOSet() {
        return articleDTOSet;
    }
}