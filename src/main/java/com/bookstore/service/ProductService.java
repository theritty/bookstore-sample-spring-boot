package com.bookstore.service;

import com.bookstore.model.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface ProductService {

    @NotNull Iterable<Product> getAllProducts();

    List<Product> getProductsByCategory(Long categoryId, int page);

    Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    Product save(Product product);

    List<Product> listAllByPage(int page);

    Long getCount();

    Long getCountByCategory(long categoryId);



    Product create(@NotNull(message = "The order cannot be null.") @Valid Product product);

    void update(@NotNull(message = "The order cannot be null.") @Valid Product product);
}
