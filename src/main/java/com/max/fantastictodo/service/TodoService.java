package com.max.fantastictodo.service;

import com.max.fantastictodo.model.Todo;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface TodoService {

    List<Todo> getUserTodos(Sort sort);

    Todo getUserTodo(String id);

    Todo newTodo(Todo todo);

    Todo updateTodo(String id, Todo todo);

    void deleteTodo(String id);
}
