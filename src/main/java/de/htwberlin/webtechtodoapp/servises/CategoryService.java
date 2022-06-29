package de.htwberlin.webtechtodoapp.servises;

import de.htwberlin.webtechtodoapp.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long categoryId);
    Category createCategory(String title);
    Category updateCategory(Long categoryId, String title);
    void deleteCategory (Long categoryId);
}
