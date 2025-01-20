package com.example.demo.service.impl;



import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.servicei.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository cr;

    @Override
    public Page<Category> getAllCategories(Pageable pageable) {
        return cr.findAll(pageable);
    }

    @Override
    public Category getCategoryById(Long id) {
        return cr.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public Category createCategory(Category category) {
        return cr.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category existingCategory = getCategoryById(id);
        existingCategory.setName(category.getName());
        return cr.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        cr.deleteById(id);
        
    }
}
