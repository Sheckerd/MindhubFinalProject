package com.PatitosdeHule.eCommerce.DTOs;

import com.PatitosdeHule.eCommerce.models.ClothesSize;
import com.PatitosdeHule.eCommerce.models.Product;
import com.PatitosdeHule.eCommerce.models.ProductType;

public class CosplayDTO {

    private long id;
    private String name;
    private String description;
    private String imageURL_front;
    private String animeTheme;
    private boolean limitedEdition;
    private ProductType productType;
    private ClothesSize clothesSize;
    private int stock;
    private double price;

    public CosplayDTO(){};

    public CosplayDTO(Product product) {

        this.name = product.getName();
        this.description = product.getDescription();
        this.imageURL_front = product.getImageURL_front();
        this.animeTheme = product.getAnimeTheme();
        this.limitedEdition = product.isLimitedEdition();
        this.productType = product.getProductType();
        this.clothesSize = product.getClothesSize();
        this.stock = product.getStock();
        this.price = product.getPrice();

    }

    public long getId() {return id;}

    public String getName() {return name;}

    public String getDescription() {return description;}

    public String getImageURL_front() {return imageURL_front;}

    public String getAnimeTheme() {return animeTheme;}

    public boolean isLimitedEdition() {return limitedEdition;}

    public ProductType getProductType() {return productType;}

    public ClothesSize getClothesSize() {return clothesSize;}

    public int getStock() {return stock;}

    public double getPrice() {return price;}

}
