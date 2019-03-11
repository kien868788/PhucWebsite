package com.kien.service.user;

import com.kien.model.user.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    User findByUserName(String username);
}
