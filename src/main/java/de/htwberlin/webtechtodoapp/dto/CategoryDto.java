package de.htwberlin.webtechtodoapp.dto;

import de.htwberlin.webtechtodoapp.entities.Todo;

import java.util.ArrayList;
import java.util.List;

public class CategoryDto {

    private Long categoryId;
    private String categoryTitle;

    private List<Todo> todoList;


    public CategoryDto(Long categoryId, String categoryTitle, List<Todo> todoList) {
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.todoList = todoList;
    }

    public CategoryDto() {
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

}
