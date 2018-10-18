package com.bookstore.repository;

import com.bookstore.model.ReviewProduct;
import com.bookstore.model.ReviewProductPK;
import org.springframework.data.repository.CrudRepository;

public interface ReviewProductRepository extends CrudRepository<ReviewProduct, ReviewProductPK> {
}
