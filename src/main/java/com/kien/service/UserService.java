package com.kien.service;

import com.kien.model.user.User;

public interface UserService {
    User findByUserName(String username);
    User findById(Long id);
}
