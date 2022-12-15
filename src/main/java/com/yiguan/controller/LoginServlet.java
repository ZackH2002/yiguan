package com.yiguan.controller;

import com.yiguan.common.BaseResponse;
import com.yiguan.dao.UserDao;
import com.yiguan.dao.impl.UserDAOImpl;
import com.yiguan.model.dto.UserDTO;
import com.yiguan.model.entity.DepositoryRecord;
import com.yiguan.model.entity.User;
import com.yiguan.model.vo.DepositoryRecordVO;
import com.yiguan.model.vo.DepositoryStockVO;
import com.yiguan.service.DepositoryService;
import com.yiguan.service.UserService;
import com.yiguan.service.impl.DepositoryServiceImpl;
import com.yiguan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(value = "/user/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    private DepositoryService depositoryService = new DepositoryServiceImpl();

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
            BaseResponse<List<DepositoryRecordVO>> listBaseResponse = depositoryService.listInRecords();
            ArrayList<DepositoryRecordVO> list = (ArrayList<DepositoryRecordVO>) listBaseResponse.getData();
            req.getSession().setAttribute("listIn",list);
            //出库信息
            BaseResponse<List<DepositoryRecordVO>> listExit = depositoryService.listExitRecords();
            ArrayList<DepositoryRecordVO> list1 = (ArrayList<DepositoryRecordVO>) listExit.getData();
            req.getSession().setAttribute("listExit",list1);

            BaseResponse<List<DepositoryStockVO>> listBaseResponse1 = depositoryService.listStorageStock();
            ArrayList<DepositoryStockVO> list2 = (ArrayList<DepositoryStockVO>) listBaseResponse1.getData();
            req.getSession().setAttribute("listPicIn",list2);

            BaseResponse<List<DepositoryStockVO>> listBaseResponse2 = depositoryService.listExitStock();
            ArrayList<DepositoryStockVO> list3 = (ArrayList<DepositoryStockVO>) listBaseResponse2.getData();
            req.getSession().setAttribute("listPicExit",list3);
            resp.sendRedirect("/html/index.html");
        }
    }
}
