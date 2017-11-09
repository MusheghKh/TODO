package com.max.fantastictodo.repository;

import com.max.fantastictodo.model.Todo;
import com.max.fantastictodo.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {

    List<Todo> findAllByUser(User user, Sort sort);

    Todo findByIdAndUser(String id, User user);
}