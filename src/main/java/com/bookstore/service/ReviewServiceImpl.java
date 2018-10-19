package com.bookstore.service;

import com.bookstore.exception.ResourceNotFoundException;
import com.bookstore.model.Review;
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
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

}
