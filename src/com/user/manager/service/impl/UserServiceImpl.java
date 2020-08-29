package com.user.manager.service.impl;

import com.user.manager.dao.UserDao;
import com.user.manager.dao.impl.UserDaoImpl;
import com.user.manager.entity.User;
import com.user.manager.service.UserService;
import com.user.manager.utils.LoginException;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(User user) throws LoginException {
        // 调用 dao中根据姓名和密码查询的方法 返回一个 loginUser
        User loginUser = userDao.findByNameAndPassword(user.getName(),user.getPassword());
        // 判断返回的 loginUser 是否为null
        if (loginUser != null) {
            return loginUser;
        } else {
            throw new LoginException("用户名/密码输入错误!");
        }
    }

    @Override
    // 调用dao中 查询用户所有信息的方法 并返回
    public List<User> findAll() {
        List<User> list = userDao.selectUserAll();
        return list;
    }

    @Override
    // 调用dao中 添加用户信息的方法
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    // 调用dao中 通过id删除用户信息的方法
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    @Override
    // 调用dao中 通过id查找用户信息的方法
    public User findUserById(int id) {
        User findUser = userDao.selectUserById(id);
        return findUser;
    }

    @Override
    // 调用dao中 通过id更新用户信息的方法
    public void updateUserById(User user) {
        userDao.updateUserById(user);
    }
}
