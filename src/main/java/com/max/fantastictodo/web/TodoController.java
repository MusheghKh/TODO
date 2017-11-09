package com.max.fantastictodo.web;

import com.max.fantastictodo.model.Todo;
import com.max.fantastictodo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        Sort sortByCreatedAtAsc = new Sort(Sort.Direction.ASC, "createdAt");

        return todoService.getUserTodos(sortByCreatedAtAsc);
    }

    @PostMapping(value = "/todos", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Todo createTodo(@Valid Todo todo) {
        Todo newTodo = todoService.newTodo(todo);
        return newTodo;
    }

    @GetMapping(value = "/todos/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") String id) {
        Todo todo = todoService.getUserTodo(id);
        if (todo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(todo, HttpStatus.OK);
        }
    }


    @PutMapping(value = "/todos/{id}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") String id,
                                           @Valid Todo todo) {
        Todo updatedTodo = todoService.updateTodo(id, todo);
        if (updatedTodo == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    @DeleteMapping(value = "/todos/{id}")
    public void deleteTodo(@PathVariable("id") String id) {
        todoService.deleteTodo(id);
    }
}
