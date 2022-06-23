package de.htwberlin.webtechtodoapp.servises;

import de.htwberlin.webtechtodoapp.entities.Category;
import de.htwberlin.webtechtodoapp.entities.Todo;
import de.htwberlin.webtechtodoapp.repos.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService{

    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<Todo> getAllTodo() {
        return toDoRepository.findAll();
    }
    @Override
    public Todo getTodoById(Long todoId){
        return toDoRepository.findById(todoId).get();
    }

    @Override
    public Todo create(String title, String description, Category category){
        Todo todo = transformedTodo(title, description, category);
        return toDoRepository.save(todo);
    }

    private Todo transformedTodo(String title, String description, Category category){
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setCategory(category);
        todo.setCreatedTime(LocalDateTime.now());
        return todo;
    }

    public Todo update(Long todoId, String title, String description, Category category, Boolean done) {
        Todo todo = transformedTodo(title, description, category);
        todo.setTodoId(todoId);
        todo.setDone(true);
        return toDoRepository.save(todo);
    }

    public void delete (Long todoId) {
        toDoRepository.deleteById(todoId);
    }
}
