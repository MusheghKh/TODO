package com.max.fantastictodo.repository;

import com.max.fantastictodo.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {

    Role findByName(String role);
}
