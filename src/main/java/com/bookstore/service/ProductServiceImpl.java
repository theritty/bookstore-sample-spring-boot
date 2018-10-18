package com.bookstore.service;

import com.bookstore.dto.CustomerResponseDTO;
import com.bookstore.dto.ProductResponseDTO;
import com.bookstore.dto.ReviewResponseDTO;
import com.bookstore.exception.ResourceNotFoundException;
import com.bookstore.model.Product;
import com.bookstore.model.Review;
import com.bookstore.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return productRepository
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public List<Product> getProductsByCategory(Long categoryId, int page) {
        Pageable pageRequest = new PageRequest(--page, 20);
        return productRepository
                .findByCategoryId(categoryId, pageRequest);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> listAllByPage(int page) {
        List<Product> categories = new ArrayList<>();
        if (page <= 0) page = 1;

        Pageable pageRequest = new PageRequest(--page, 20);
        Page<Product> pageStudents = productRepository.findAll(pageRequest);

        for (Product student : pageStudents) {
            categories.add(student);
        }
        return categories;
    }

    @Override
    public Long getCount() {
        return productRepository.count();
    }

    @Override
    public Long getCountByCategory(long categoryId) {
        return productRepository.countByCategoryId(categoryId);
    }



    @Override
    public Product create(@NotNull(message = "The order cannot be null.") @Valid Product product) {
        return productRepository.save(product);
    }

    @Override
    public void update(@NotNull(message = "The order cannot be null.") @Valid Product product) {
        productRepository.save(product);
    }




}
