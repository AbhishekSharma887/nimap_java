package com.javaenginner.service;


import com.javaenginner.entity.Category;
import com.javaenginner.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll(); // Fetch all categories
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null); // Fetch category by ID
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category); // Save new category
    }

    public Category updateCategory(Long id, Category categoryDetails) {
        Category category = getCategoryById(id);
        if (category != null) {
            category.setName(categoryDetails.getName());
            return categoryRepository.save(category); // Update category
        }
        return null;
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id); // Delete category by ID
    }
}

