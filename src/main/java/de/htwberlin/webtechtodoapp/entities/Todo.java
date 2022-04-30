package de.htwberlin.webtechtodoapp.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long todoId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    /*@Column(name = "created_time")
    private LocalDateTime createdTime;*/

    @Column(name = "category")
    private Category category;

    @Column(name = "done")
    private Boolean isDone;

    public Todo() {
    }

    public Todo(String title, String description, Category category, Boolean isDone) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.isDone = isDone;
    }

    /* public Todo(String title, String description, LocalDateTime createdTime, Category category, Boolean isDone) {
        this.title = title;
        this.description = description;
        this.createdTime = createdTime;
        this.category = category;
        this.isDone = isDone;
    }*/

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

   /*
   public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
    */

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
