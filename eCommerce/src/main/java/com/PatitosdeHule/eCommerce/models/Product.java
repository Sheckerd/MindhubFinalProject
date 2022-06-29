package com.PatitosdeHule.eCommerce.models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String name;
    @ElementCollection
    @Column(name = "colors")
    private List<String> colors;
    @ElementCollection
    @Column(name = "Size")
    private List<String> size;
    private String description;
    private String imageURL_front;
    private String imageURL_back;
    private String animeTheme;
    private ClothesType clothesType;
    private boolean limitedEdition;
    private ProductType productType;
    //     private ClothesSize clothesSize;
    private int stock;
    private double price;
    private boolean isEnabled;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Set<ProductList> productLists = new HashSet<>();

    public Product(){}

    public Product(String name, List<String> colors, String description, String imageURL_front, String imageURL_back, String animeTheme, ClothesType clothesType, boolean limitedEdition, ProductType productType, List<String> size, int stock, double price) {

        this.name = name;
        this.colors = colors;
        this.description = description;
        this.imageURL_front = imageURL_front;
        this.imageURL_back = imageURL_back;
        this.animeTheme = animeTheme;
        this.clothesType = clothesType;
        this.limitedEdition = limitedEdition;
        this.productType = productType;
        this.size = size;
        this.stock = stock;
        this.price = price;
        this.isEnabled = true;

    }

    public Product(String name, String description, String imageURL_front, String animeTheme, boolean limitedEdition, ProductType productType, List<String>size, int stock, double price) {

        this.name = name;
        this.description = description;
        this.imageURL_front = imageURL_front;
        this.animeTheme = animeTheme;
        this.limitedEdition = limitedEdition;
        this.productType = productType;
        this.size = size;
        this.stock = stock;
        this.price = price;
        this.isEnabled = true;

    }

    public long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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

    public List<String> getColor() {
        return colors;
    }

    public void setColor(List<String> colors) {
        this.colors = colors;
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

    public Set<ProductList> getArticles() {
        return productLists;
    }

    public void addArticles(ProductList productList) {
        productList.setProduct(this);
        productLists.add(productList);
    }

    public boolean isEnabled() {
            return isEnabled;
        }

        public void setEnabled(boolean enabled) {
            isEnabled = enabled;
        }
}
