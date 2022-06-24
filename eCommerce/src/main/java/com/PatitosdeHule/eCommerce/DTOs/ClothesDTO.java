package com.PatitosdeHule.eCommerce.DTOs;

import com.PatitosdeHule.eCommerce.models.ClothesSize;
import com.PatitosdeHule.eCommerce.models.ClothesType;
import com.PatitosdeHule.eCommerce.models.Product;
import com.PatitosdeHule.eCommerce.models.ProductType;

import java.util.List;

public class ClothesDTO {

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

    public ClothesDTO() {};

    public ClothesDTO(Product product) {

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

    }

    public long getId() {
        return id;
    }

    public String getName() {return name;}

    public List<String> getColors() {return colors;}

    public String getDescription() {return description;}

    public String getImageURL_front() {return imageURL_front;}

    public String getImageURL_back() {return imageURL_back;}

    public String getAnimeTheme() {return animeTheme;}

    public ClothesType getClothesType() {return clothesType;}

    public boolean isLimitedEdition() {return limitedEdition;}

    public ProductType getProductType() {return productType;}

    public ClothesSize getClothesSize() {return clothesSize;}

    public int getStock() {return stock;}

    public double getPrice() {return price;}
}
