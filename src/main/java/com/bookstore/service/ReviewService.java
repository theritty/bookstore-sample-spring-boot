package com.bookstore.service;

import com.bookstore.model.Review;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ReviewService {

    Review save(Review review);

    Review getReview(@Min(value = 1L, message = "Invalid product ID.") long id);

}
