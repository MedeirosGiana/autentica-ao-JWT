package com.spring.security.jwt.repository;

import com.spring.security.jwt.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositry extends CrudRepository<User,Long> {
    User findByLogin(String login);
}
