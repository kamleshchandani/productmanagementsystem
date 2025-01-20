package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.servicei.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<Product> getAlldataProducts(Pageable pageable) {
        return productService.getAllProducts(pageable);
    }

    @GetMapping("/{id}")
    public Product getProductUsingbyId(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createNewdataProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateExistingdataProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteExistingdataProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }
}
