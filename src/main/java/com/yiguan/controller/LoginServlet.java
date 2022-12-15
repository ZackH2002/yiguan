package com.yiguan.controller;

import com.yiguan.common.BaseResponse;
import com.yiguan.dao.UserDao;
import com.yiguan.dao.impl.UserDAOImpl;
import com.yiguan.model.dto.UserDTO;
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
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        BaseResponse<User> response = userService.userLogin(username,password);
        User user = response.getData();
        if(user == null){
            resp.sendRedirect("/html/login.html");
        }else{
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/html/index.html");
        }
    }
}
