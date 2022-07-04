package de.htwberlin.webtechtodoapp.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long todoId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;


    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @Column(name = "done")
    private Boolean isDone = false;

    @Column(name="myDay")
    private Boolean isMyDay;

    public Todo() {
    }

    public Todo(String title, String description, Category category, Boolean isMyDay) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.isMyDay = isMyDay;
        this.isDone = false;
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

    public void setCategory(Category priority) {
        this.category = priority;
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
