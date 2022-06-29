package de.htwberlin.webtechtodoapp.servises;

import de.htwberlin.webtechtodoapp.entities.Category;
import de.htwberlin.webtechtodoapp.entities.Todo;
import de.htwberlin.webtechtodoapp.repos.CategoryRepository;
import de.htwberlin.webtechtodoapp.repos.ToDoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    @Override
    public Category getCategoryById(Long categoryId){
        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public Category createCategory(String title){
        Category category = transformedCategory(title);
        return categoryRepository.save(category);
    }

    private Category transformedCategory(String title){
       Category category = new Category();
        category.setCategoryTitle(title);
        return category;
    }

    public Category updateCategory(Long categoryId, String title) {
        Category category = transformedCategory(title);
        category.setCategoryId(categoryId);
        category.setCategoryTitle(title);
        return categoryRepository.save(category);
    }

    public void deleteCategory (Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

}
