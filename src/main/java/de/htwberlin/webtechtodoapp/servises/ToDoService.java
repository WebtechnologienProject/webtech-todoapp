package de.htwberlin.webtechtodoapp.servises;

import de.htwberlin.webtechtodoapp.entities.Todo;
import de.htwberlin.webtechtodoapp.repos.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<Todo> getAll() {
        return toDoRepository.findAll();
    }

    public Todo create(Todo todo) {
        return toDoRepository.save(todo);
    }

    public Todo update(Todo todo) {
        return toDoRepository.save(todo);
    }

    public void delete (Long todoId) {
        toDoRepository.deleteById(todoId);
    }

}
