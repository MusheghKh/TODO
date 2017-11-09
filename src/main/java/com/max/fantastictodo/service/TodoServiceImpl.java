package com.max.fantastictodo.service;

import com.max.fantastictodo.model.Todo;
import com.max.fantastictodo.model.User;
import com.max.fantastictodo.repository.TodoRepository;
import com.max.fantastictodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    private final UserRepository userRepository;
    private final TodoRepository todoRepository;
    private final SecurityService securityService;

    @Autowired
    public TodoServiceImpl(UserRepository userRepository, TodoRepository todoRepository, SecurityService securityService) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
        this.securityService = securityService;
    }

    @Override
    public List<Todo> getUserTodos(Sort sort) {
        User currentUser = userRepository.findByUsername(securityService.findLoggedInUsername());

        List<Todo> data = todoRepository.findAllByUser(currentUser, sort);
        return data;
    }

    @Override
    public Todo getUserTodo(String id) {
        User currentUser = userRepository.findByUsername(securityService.findLoggedInUsername());

        return todoRepository.findByIdAndUser(id, currentUser);
    }

    @Override
    public Todo newTodo(Todo todo) {
        User currentUser = userRepository.findByUsername(securityService.findLoggedInUsername());

        todo.setCompleted(false);
        todo.setUser(currentUser);

        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(String id, Todo todo) {
        User currentUser = userRepository.findByUsername(securityService.findLoggedInUsername());

        Todo todoData = todoRepository.findByIdAndUser(id, currentUser);
        if (todoData == null){
            return null;
        }
        todoData.setTitle(todo.getTitle());
        todoData.setCompleted(todo.getCompleted());
        return todoRepository.save(todoData);
    }

    @Override
    public void deleteTodo(String id) {
        User currentUser = userRepository.findByUsername(securityService.findLoggedInUsername());

        Todo todo = todoRepository.findByIdAndUser(id, currentUser);
        if (todo != null){
            todoRepository.delete(id);
        }
    }
}
