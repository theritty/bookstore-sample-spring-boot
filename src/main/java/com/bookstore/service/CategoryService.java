package com.bookstore.service;

import com.bookstore.model.Category;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface CategoryService {

    @NotNull Iterable<Category> getAllCategories();

    Category save(Category category);

    List<Category> listAllByPage(int page);

    Long getCount();
}
