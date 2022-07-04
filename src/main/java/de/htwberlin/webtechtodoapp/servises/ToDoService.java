package de.htwberlin.webtechtodoapp.servises;

import de.htwberlin.webtechtodoapp.entities.Category;
import de.htwberlin.webtechtodoapp.entities.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ToDoService {
    Todo create(String title, String description, Category category, Boolean isMyDay);

    Todo update(Long todoId, String title, String description, Category category, Boolean isMyDay, Boolean isDone);

    Todo getTodoById(Long todoId);

    boolean deleteById(Long todoId);

    List<Todo> getAllTodo();
}
