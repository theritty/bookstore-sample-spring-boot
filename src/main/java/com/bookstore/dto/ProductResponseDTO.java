package com.bookstore.dto;

import com.bookstore.model.Product;

import java.util.List;

public class ProductResponseDTO {
    private Long id;

    private String name;

    private String author;

    private String description;

    private Long categoryId;

    private Double price;

    private Double discount;

    private boolean bestSellerPrd;

    private boolean newPrd;

    private String pictureUrl;

    private Long remainingQuantity;

    private Object[] reviewList;

    public ProductResponseDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.author = product.getAuthor();
        this.description = product.getDescription();
        this.categoryId = product.getCategoryId();
        this.price = product.getPrice();
        this.discount = product.getDiscount();
        this.bestSellerPrd = product.isBestSellerPrd();
        this.newPrd = product.isNewPrd();
        this.pictureUrl = product.getPictureUrl();
        this.remainingQuantity = product.getRemainingQuantity();
        this.reviewList = product.getReviewProducts().stream().map(a ->
            new ReviewResponseDTO(
                a.getPk().getReview().getReviewId(),
                new CustomerResponseDTO(a.getCustomer()),
                a.getPk().getReview().getText()
            )
        ).toArray();
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

    public Long getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(Long remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    public Object[] getReviewList() {
        return reviewList;
    }

    public void setReviewList(Object[] reviewList) {
        this.reviewList = reviewList;
    }
}
