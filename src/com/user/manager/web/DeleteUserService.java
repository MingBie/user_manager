package com.user.manager.web;

import com.user.manager.entity.User;
import com.user.manager.service.UserService;
import com.user.manager.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/DeleteUserService")
public class DeleteUserService extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收请求 获得id
        int id = Integer.valueOf(request.getParameter("id"));
        // 调用service 通过id删除用户的方法
        UserService userService = new UserServiceImpl();
        userService.deleteUserById(id);
        // 跳转 所有用户页面list 并显示
        List<User> list = userService.findAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
