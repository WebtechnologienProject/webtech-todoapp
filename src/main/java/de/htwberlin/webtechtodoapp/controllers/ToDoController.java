package de.htwberlin.webtechtodoapp.controllers;

import de.htwberlin.webtechtodoapp.dto.TodoDto;
import de.htwberlin.webtechtodoapp.entities.Todo;
import de.htwberlin.webtechtodoapp.servises.CategoryService;
import de.htwberlin.webtechtodoapp.servises.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
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
        return todo != null? ResponseEntity.ok(todo) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Todo> create(@Valid @RequestBody TodoDto todoDto) {
        var valid = validate(todoDto);
        if (valid) {
            Todo todo = toDoService.create(todoDto.getTitle(), todoDto.getDescription(), todoDto.getCategory(), todoDto.getMyDay());
            return ResponseEntity.status(HttpStatus.CREATED).body(todo);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping(value = "/{todoId}")
    public ResponseEntity<Todo> update(@Valid @RequestBody Todo todoDto) {
        Todo todo = toDoService.update(todoDto.getTodoId(), todoDto.getTitle(), todoDto.getDescription(), todoDto.getCategory(), todoDto.getMyDay(), todoDto.getDone());
        return todo != null? ResponseEntity.ok(todo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{todoId}")
    public ResponseEntity<Void> deleteById(@PathVariable("todoId") Long todoId) {
        boolean isOk = toDoService.deleteById(todoId);
        return isOk? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


    private boolean validate(TodoDto todoDto) {
        return todoDto.getTitle() != null
                && !todoDto.getTitle().isBlank()
                && todoDto.getCategory() != null;
    }

}
