package com.bookstore.service;

import com.bookstore.model.ReviewProduct;
import com.bookstore.repository.ReviewProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReviewProductServiceImpl implements ReviewProductService {

    private ReviewProductRepository reviewProductRepository;

    public ReviewProductServiceImpl(ReviewProductRepository reviewProductRepository) {
        this.reviewProductRepository = reviewProductRepository;
    }

    @Override
    public ReviewProduct create(ReviewProduct reviewProduct) {
        return this.reviewProductRepository.save(reviewProduct);
    }
}
