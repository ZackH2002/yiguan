package com.yiguan.controller;

import com.yiguan.common.BaseResponse;
import com.yiguan.model.entity.User;
import com.yiguan.service.UserService;
import com.yiguan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/user/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("password = " + password);
        System.out.println("username = " + username);
        User user = new User();
        user.setUserName(username);
        user.setUserPassword(password);

        BaseResponse<Boolean> response = userService.userLogin(username,password);
        Boolean flag = response.getData();
        System.out.println(flag);
        System.out.println("===============");
        if(flag){
            resp.sendRedirect("login.html");
        }else{
            resp.sendRedirect("index.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
