package com.bookstore.service;

import com.bookstore.model.Category;
import com.bookstore.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> listAllByPage(int page) {
        List<Category> categories = new ArrayList<>();
        if (page <= 0) page = 1;

        Pageable pageRequest = new PageRequest(--page, 20);
        Page<Category> pageStudents = categoryRepository.findAll(pageRequest);

        for (Category student : pageStudents) {
            categories.add(student);
        }
        return categories;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Long getCount() {
        return categoryRepository.count();
    }

}
