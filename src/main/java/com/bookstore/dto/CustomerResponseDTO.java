package com.bookstore.dto;

import com.bookstore.model.Customer;

public class CustomerResponseDTO {
    Long id;
    String name;

    public CustomerResponseDTO(Customer customer) {
        this.id = customer.getCustomerId();
        this.name = customer.getName();
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
}
