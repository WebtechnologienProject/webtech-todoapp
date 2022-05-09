package de.htwberlin.webtechtodoapp.controllers;

import de.htwberlin.webtechtodoapp.dto.TodoDto;
import de.htwberlin.webtechtodoapp.entities.Todo;
import de.htwberlin.webtechtodoapp.servises.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return toDoService.getAllTodo();
    }

    @GetMapping(value = "/{todoId}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("todoId") Long todoId) {
        Todo todo = toDoService.getTodoById(todoId);
        return ResponseEntity.ok(todo);
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody TodoDto todoDto) {
        Todo todo = toDoService.create(todoDto.getTitle(), todoDto.getDescription(), todoDto.getCategory(), todoDto.getDone());
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }


    @PutMapping(value = "/{todoId}")
    public ResponseEntity<Todo> update(@RequestBody Todo todoDto) {
        Todo todo = toDoService.update(todoDto.getTodoId(), todoDto.getTitle(), todoDto.getDescription(), todoDto.getCategory(), todoDto.getDone());
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping(value = "/{todoId}")
    public void deleteById(@PathVariable("todoId") Long todoId) {
        toDoService.delete(todoId);
    }


}
