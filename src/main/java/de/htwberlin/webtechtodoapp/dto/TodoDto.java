package de.htwberlin.webtechtodoapp.dto;

import de.htwberlin.webtechtodoapp.entities.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TodoDto {

    private Long todoId;
    @Size(min = 3, message = "The title must contain 3 or more characters")
    @NotBlank(message = "The title must be not empty")
    private String title;
    private String description;

    private Boolean isMyDay;
    private Boolean isDone = false;
    @NotNull(message = "Category must be not empty")
    private Category category;

    public TodoDto(Long todoId, String title, String description, Category category, Boolean isMyDay) {
        this.todoId = todoId;
        this.title = title;
        this.description = description;
        this.isMyDay = isMyDay;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getMyDay() {
        return isMyDay;
    }

    public void setMyDay(Boolean myDay) {
        isMyDay = myDay;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }
}
