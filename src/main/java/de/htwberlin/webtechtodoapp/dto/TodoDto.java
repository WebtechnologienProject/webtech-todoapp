package de.htwberlin.webtechtodoapp.dto;

import de.htwberlin.webtechtodoapp.entities.Category;

public class TodoDto {

    private Long todoId;
    private String title;
    private String description;
    private Category category;
    private Boolean isDone;

    public TodoDto(Long todoId, String title, String description, Category category, Boolean isDone) {
        this.todoId = todoId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.isDone = isDone;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }
}
