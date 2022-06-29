package de.htwberlin.webtechtodoapp.controllers;

import de.htwberlin.webtechtodoapp.dto.CategoryDto;
import de.htwberlin.webtechtodoapp.entities.Category;
import de.htwberlin.webtechtodoapp.servises.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping(value = "/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("categoryId") Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto) {
        Category category = categoryService.createCategory(categoryDto.getCategoryTitle());
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }


    @PutMapping(value = "/{categoryId}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category categoryDto) {
        Category category = categoryService.updateCategory(categoryDto.getCategoryId(), categoryDto.getCategoryTitle());
        return ResponseEntity.ok(category);
    }

    @DeleteMapping(value = "/{categoryId}")
    public void deleteCategoryById(@PathVariable("categoryId") Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
