package com.bookstore.service;

import com.bookstore.model.Customer;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface CustomerService {

    @NotNull Iterable<Customer> getAllCustomers();

    Customer save(Customer customer);


    Customer getCustomer(@Min(value = 1L, message = "Invalid product ID.") long id);

}
