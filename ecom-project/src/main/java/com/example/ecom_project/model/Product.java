package com.example.ecom_project.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

@Component
@Entity
public class Product
{
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", productAvailable=" + productAvailable +
                ", releaseDate=" + releaseDate +
                ", stockQuantity=" + stockQuantity +
                ", imageName='" + imageName + '\'' +
                ", imageType='" + imageType + '\'' +
                ", imageData=" + Arrays.toString(imageData) +
                '}';
    }

    public Product(int id, String name, String desc, String category, BigDecimal price, String brand, boolean available, Date releaseDate, int quantity) {
        this.id = id;
        this.name = name;
        this.description = desc;
        this.category = category;
        this.price = price;
        this.brand = brand;
        this.productAvailable = available;
        this.releaseDate = releaseDate;
        this.stockQuantity = quantity;
    }
    public Product()
    {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private String brand;
    private boolean productAvailable;

    //@JsonFormat(shape =JsonFormat.Shape.STRING,pattern = "dd-MM-yyy") //Jackson library here can be used to convert json to object and other formats as well
    private Date releaseDate;
    private int stockQuantity;


    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    /*Image*/
    private String imageName;
    private String imageType;
    @Lob //This is used to represent a large object
    private byte[] imageData; //we will we be storing image data in database

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isProductAvailable() {
        return productAvailable;
    }

    public void setProductAvailable(boolean productAvailable) {
        this.productAvailable = productAvailable;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
