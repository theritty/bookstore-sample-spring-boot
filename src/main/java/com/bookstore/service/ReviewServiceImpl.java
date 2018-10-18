package com.bookstore.service;

import com.bookstore.exception.ResourceNotFoundException;
import com.bookstore.model.Customer;
import com.bookstore.model.Review;
import com.bookstore.repository.CustomerRepository;
import com.bookstore.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review getReview(long id) {
        return reviewRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found"));
    }

    @Override
    public @NotNull Iterable<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

}
