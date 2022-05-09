package de.htwberlin.webtechtodoapp.servises;

import de.htwberlin.webtechtodoapp.entities.Category;
import de.htwberlin.webtechtodoapp.entities.Todo;

import java.util.List;

public interface ToDoService {
    Todo create(String title, String description, Category category, Boolean isDone);

    Todo update(Long todoId, String title, String description, Category category, Boolean isDone);

    Todo getTodoById(Long todoId);

    void delete(Long todoId);

    List<Todo> getAllTodo();
}
