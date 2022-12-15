package com.yiguan.controller;

import com.yiguan.model.dto.MaterialDTO;
import com.yiguan.model.entity.Material;
import com.yiguan.service.DepositoryService;
import com.yiguan.service.impl.DepositoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet(value = "/DepositoryServlet")
public class DepositoryServlet extends HttpServlet {
    DepositoryService depositoryService = new DepositoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        String caozuo = req.getParameter("caozuo");
        if(caozuo.equals("add")){
            this.addMaterial(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        this.doGet(req,resp);
    }

    private void addMaterial(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        System.out.println(name);
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        long depositoryId;
        //long depositoryId = Long.parseLong(request.getParameter("depositoryId"));
        double price = Double.parseDouble(request.getParameter("price"));
        MaterialDTO material = new MaterialDTO();
        //根据时间戳生成id
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
//        long id = Long.parseLong(sdf.format(System.currentTimeMillis()));
//        material.setId(id);
        material.setName(name);
        material.setQuantity(quantity);
        depositoryId = 1L;
        material.setDepositoryId(depositoryId);
        material.setPrice(price);
        depositoryService.materialStorage(material);
    }
}

