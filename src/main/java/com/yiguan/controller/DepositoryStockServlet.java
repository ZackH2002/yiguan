package com.yiguan.controller;

import com.yiguan.common.BaseResponse;
import com.yiguan.model.vo.DepositoryStockVO;
import com.yiguan.service.DepositoryService;
import com.yiguan.service.impl.DepositoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/depository/stock")
public class DepositoryStockServlet extends HttpServlet {

    private DepositoryService service = new DepositoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BaseResponse<List<DepositoryStockVO>> response = service.listDepositoryStock();
        List<DepositoryStockVO> data = response.getData();
        req.setAttribute("data", data);
        req.getRequestDispatcher("/jsp/Inventory.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
