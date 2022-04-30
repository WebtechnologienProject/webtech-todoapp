package de.htwberlin.webtechtodoapp.controllers;

import de.htwberlin.webtechtodoapp.entities.Todo;
import de.htwberlin.webtechtodoapp.servises.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<Todo> getAll() {
        return toDoService.getAll();
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return toDoService.create(todo);
    }

    @PutMapping
    public Todo update(@RequestBody Todo todo) {
        return toDoService.update(todo);
    }

    @DeleteMapping(value = "/{todoId}")
    public void deleteById(@PathVariable("todoId") Long todoId) {
        toDoService.delete(todoId);
    }

}
