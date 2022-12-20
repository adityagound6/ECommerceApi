package com.example.ECommerceApi.service;

import com.example.ECommerceApi.entity.User;

import java.util.List;

public interface UserService {
    boolean createUser(User user);
    List<User> getAllUsers();
    boolean deleteUser(Long userId);
    User getUserById(Long id);
    User UpdateUser(User user);
    User getUserByUsername(String username);
}
