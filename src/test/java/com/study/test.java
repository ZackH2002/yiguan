package com.study;


import com.yiguan.dao.DepositoryDAO;
import com.yiguan.dao.UserDao;
import com.yiguan.dao.impl.DepositoryDAOImpl;
import com.yiguan.dao.impl.UserDAOImpl;
import com.yiguan.model.dto.MaterialDTO;
import com.yiguan.model.entity.User;
import org.junit.Test;

public class test {

    private UserDao userDao = new UserDAOImpl();

    private DepositoryDAO dao = new DepositoryDAOImpl();

    @Test
    public void testQueryUser() {
        MaterialDTO materialDTO = new MaterialDTO(1L, "AJ3童鞋", 20, 3.3);
        dao.saveMaterial(materialDTO);
    }



}
