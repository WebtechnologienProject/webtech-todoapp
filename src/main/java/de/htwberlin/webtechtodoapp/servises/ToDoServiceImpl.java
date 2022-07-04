package de.htwberlin.webtechtodoapp.servises;

import de.htwberlin.webtechtodoapp.entities.Category;
import de.htwberlin.webtechtodoapp.entities.Todo;
import de.htwberlin.webtechtodoapp.repos.CategoryRepository;
import de.htwberlin.webtechtodoapp.repos.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService{

    private final ToDoRepository toDoRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ToDoServiceImpl(ToDoRepository toDoRepository, CategoryRepository categoryRepository) {
        this.toDoRepository = toDoRepository;
        this.categoryRepository = categoryRepository;
    }


    public List<Todo> getAllTodo() {
        return toDoRepository.findAll();
    }
    @Override
    public Todo getTodoById(Long todoId){
        return toDoRepository.findById(todoId).get();
    }

    @Override
    public Todo create(String title, String description, Category category, Boolean isMyDay){
        Todo todo = transformedTodo(title, description, category, isMyDay);
        return toDoRepository.save(todo);
    }

    private Todo transformedTodo(String title, String description, Category category, Boolean isMyDay){
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setCategory(category);
        todo.setMyDay(isMyDay);
        return todo;
    }

    public Todo update(Long todoId, String title, String description, Category category, Boolean isMyDay, Boolean done) {
        Todo todo = transformedTodo(title, description, category, isMyDay);
        todo.setTodoId(todoId);
        todo.setCategory(category);
        todo.setDone(done);
        todo.setMyDay(isMyDay);
        return toDoRepository.save(todo);
    }

    public boolean deleteById (Long todoId) {
        if(!toDoRepository.existsById(todoId)) {
            return false;
        }
        toDoRepository.deleteById(todoId);
        return true;
    }

}
