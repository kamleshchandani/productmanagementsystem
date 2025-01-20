package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.servicei.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Page<Category> getAlldataCategories(Pageable pageable) {
        return categoryService.getAllCategories(pageable);
    }

    @GetMapping("/{id}")
    public Category getCategorybyId(@PathVariable("id") Long id) {
        return categoryService.getCategoryById(id);
    }	

    @PostMapping
    public Category createNewdataCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateExistingdataCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteExistingdataCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
    }
}
