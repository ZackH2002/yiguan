package com.yiguan.controller;

import com.yiguan.common.BaseResponse;
import com.yiguan.model.vo.DepositoryStockVO;
import com.yiguan.service.DepositoryService;
import com.yiguan.service.impl.DepositoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PicDataServlet extends HttpServlet {
    DepositoryService depositoryService = new DepositoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String type = req.getParameter("type");
    }
    private void getIn(HttpServletRequest request,HttpServletResponse response){
        BaseResponse<List<DepositoryStockVO>> listBaseResponse = depositoryService.listStorageStock();
        ArrayList<DepositoryStockVO> list = (ArrayList<DepositoryStockVO>) listBaseResponse.getData();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req,resp);
    }
}
