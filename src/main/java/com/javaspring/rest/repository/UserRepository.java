package com.javaspring.rest.repository;

import org.springframework.data.repository.CrudRepository;
import com.javaspring.rest.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
