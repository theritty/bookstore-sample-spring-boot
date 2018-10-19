package com.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="reviewProducts")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
    private String name;

    private String author;

    private String description;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    private Double price;

    private Double discount;

    private boolean bestSellerPrd;

    private boolean newPrd;

    private String pictureUrl;

    private Long remainingQuantity;


    @OneToMany(mappedBy = "pk.product", fetch=FetchType.EAGER)
    @Valid
    private List<ReviewProduct> reviewProducts = new ArrayList<>();

    public List<ReviewProduct> getReviewProducts() {
        return reviewProducts;
    }

    public void setReviewProducts(List<ReviewProduct> reviewProducts) {
        this.reviewProducts = reviewProducts;
    }

    public Product(Long id, @NotNull(message = "Product name is required.") String name, String author, String description, Long categoryId, Double price, Double discount, boolean bestSellerPrd, boolean newPrd, String pictureUrl, long remainingQuantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.categoryId = categoryId;
        this.price = price;
        this.discount = discount;
        this.bestSellerPrd = bestSellerPrd;
        this.newPrd = newPrd;
        this.pictureUrl = pictureUrl;
        this.remainingQuantity = remainingQuantity;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public boolean isBestSellerPrd() {
        return bestSellerPrd;
    }

    public void setBestSellerPrd(boolean bestSellerPrd) {
        this.bestSellerPrd = bestSellerPrd;
    }

    public boolean isNewPrd() {
        return newPrd;
    }

    public void setNewPrd(boolean newPrd) {
        this.newPrd = newPrd;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(Long remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }
}
