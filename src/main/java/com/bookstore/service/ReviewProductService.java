package com.bookstore.service;

import com.bookstore.model.ReviewProduct;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface ReviewProductService {

    ReviewProduct create(@NotNull(message = "The products for order cannot be null.") @Valid ReviewProduct reviewProduct);
}
