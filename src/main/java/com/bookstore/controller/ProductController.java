package com.bookstore.controller;

import com.bookstore.dto.ProductResponseDTO;
import com.bookstore.model.Product;
import com.bookstore.service.ProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/api/products", method=RequestMethod.GET)
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/api/productsByCategory/{categoryId}/{page}", method=RequestMethod.GET)
    public List<Product> getProductsByCategory(@PathVariable("categoryId") Long categoryId, @PathVariable("page") int page) {
        return productService.getProductsByCategory(categoryId, page);
    }

    @RequestMapping(value = "/api/product/{id}", method=RequestMethod.GET)
    public ProductResponseDTO getProduct(@PathVariable("id") String id){
         return new ProductResponseDTO(productService.getProduct(Long.parseLong(id)));
    }

    @RequestMapping(value = "/api/productsByPage/{page}", method=RequestMethod.GET)
    public List<Product> getProductsByPage(@PathVariable("page") String page){
        return productService.listAllByPage(Integer.parseInt(page));
    }

    @RequestMapping(value = "/api/getProductCount", method=RequestMethod.GET)
    public Long getProductCount(){
        return productService.getCount();
    }

    @RequestMapping(value = "/api/getProductCountByCategoryId/{categoryId}", method=RequestMethod.GET)
    public Long getProductCountByCategoryId(@PathVariable("categoryId") Long categoryId){
        return productService.getCountByCategory(categoryId);
    }
}
