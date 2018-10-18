package com.bookstore.dto;

public class ReviewResponseDTO {
    Long id;
    CustomerResponseDTO customer;
    String text;


    public ReviewResponseDTO(Long id, CustomerResponseDTO customer, String text) {
        this.id = id;
        this.customer = customer;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerResponseDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerResponseDTO customer) {
        this.customer = customer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
