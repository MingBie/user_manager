package com.user.manager.service;

import com.user.manager.entity.User;
import com.user.manager.utils.LoginException;

import java.util.List;

public interface UserService {
    User login(User user) throws LoginException;

    List<User> findAll();

    void insertUser(User user);

    void deleteUserById(int id);

    User findUserById(int id);

    void updateUserById(User user);
}
