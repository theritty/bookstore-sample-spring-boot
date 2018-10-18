package com.bookstore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @NotNull(message = "Category name is required.")
    @Basic(optional = false)
    private String name;

    private String pictureUrl;

    public Category(Long categoryId, @NotNull(message = "Category name is required.") String name, String pictureUrl) {
        this.categoryId = categoryId;
        this.name = name;
        this.pictureUrl = pictureUrl;
    }

    public Category() {
    }

    public Long getId() {
        return categoryId;
    }

    public void setId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
