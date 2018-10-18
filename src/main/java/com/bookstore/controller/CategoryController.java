package com.bookstore.controller;

import com.bookstore.model.Category;
import com.bookstore.service.CategoryService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/api/categories", method=RequestMethod.GET)
    public @NotNull Iterable<Category> getCategories() {
        return categoryService.getAllCategories();
    }


    @RequestMapping(value = "/api/categoriesByPage/{page}", method=RequestMethod.GET)
    public List<Category> getCategoriesByPage(@PathVariable("page") String page){
        return categoryService.listAllByPage(Integer.parseInt(page));
    }

    @RequestMapping(value = "/api/getCategoryCount", method=RequestMethod.GET)
    public Long getCount(){
        return categoryService.getCount();
    }

}
