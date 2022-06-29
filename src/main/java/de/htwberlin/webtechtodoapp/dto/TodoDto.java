package de.htwberlin.webtechtodoapp.dto;

import de.htwberlin.webtechtodoapp.entities.Category;

public class TodoDto {

    private Long todoId;
    private String title;
    private String description;
    private Long categoryId;
    private Boolean isDone = false;
    private Category category;

    public TodoDto(Long todoId, String title, String description, Long categoryId, Category category) {
        this.todoId = todoId;
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
        this.isDone = false;
        this.category = category;
    }

    public TodoDto() {
    }

    public Long getTodoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Category getPriority() {
//        return priority;
//    }
//
//    public void setPriority(Category priority) {
//        this.priority = priority;
//    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }
}
