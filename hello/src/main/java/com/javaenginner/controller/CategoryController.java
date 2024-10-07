package com.javaenginner.controller;
import com.javaenginner.entity.Category;
import com.javaenginner.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories") // Base URL for all endpoints in this controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService; // Injecting CategoryService

    // GET - Fetch all categories with optional pagination
    @GetMapping
    public List<Category> getAllCategories(@RequestParam(defaultValue = "0") int page) {
        return categoryService.getAllCategories(page); // Fetches all categories with pagination support
    }

    // GET - Fetch a single category by ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        return category != null ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }

    // POST - Create a new category
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category); // Saves the new category to the database
    }

    // PUT - Update an existing category by ID
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(id, category); // Updates the existing category
        return updatedCategory != null ? ResponseEntity.ok(updatedCategory) : ResponseEntity.notFound().build();
    }

    // DELETE - Delete a category by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id); // Deletes the category
        return ResponseEntity.noContent().build();
    }
}
