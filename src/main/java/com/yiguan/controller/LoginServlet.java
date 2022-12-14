package com.yiguan.controller;

import com.yiguan.common.BaseResponse;
import com.yiguan.common.ErrorCode;
import com.yiguan.model.entity.User;
import com.yiguan.service.UserService;
import com.yiguan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setUserName(username);
        user.setUserPassword(password);

        UserService userService = new UserServiceImpl();

        BaseResponse<Boolean> response = userService.userLogin(username,password);
        if(response.getData()){

            resp.sendRedirect("index.html");
        }else{
            req.getSession().setAttribute("loginUser",user);
            //获取信息
            //。。。。。
            resp.sendRedirect("login.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        doGet(req,resp);
    }
}
