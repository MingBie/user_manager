package com.user.manager.dao;

import com.user.manager.entity.User;

import java.util.List;

public interface UserDao {
    User findByNameAndPassword(String name, String password);

    List<User> selectUserAll();

    void insertUser(User user);

    void deleteUserById(int id);

    User selectUserById(int id);

    void updateUserById(User user);
}
