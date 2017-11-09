package com.max.fantastictodo.service;

import com.max.fantastictodo.model.Todo;
import com.max.fantastictodo.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
