package com.platzi.market.web.controller;

import java.util.List;
import java.util.Optional;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getAll() {
        System.out.println("Inicia");
        return productService.getAll();
        
    }

    public Optional<Product> getProdcut(int productId) {
        return productService.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productService.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return productService.save(product);
    }

    public boolean delete(int productId) {
        return productService.delete(productId);
    }
}
