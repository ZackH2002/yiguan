package com.study;


import com.yiguan.dao.DepositoryDAO;
import com.yiguan.dao.UserDao;
import com.yiguan.dao.impl.DepositoryDAOImpl;
import com.yiguan.dao.impl.UserDAOImpl;
import com.yiguan.model.entity.Material;
import org.junit.Test;

public class DepositoryDAOTest {


    private DepositoryDAO dao = new DepositoryDAOImpl();

    @Test
    public void testQuery() {
        Material material = dao.queryMaterialById(1L, "AJ3童鞋");
        System.out.println(material);
    }

    @Test
    public void testUpdate() {
//        dao.updateMaterialExist(100, 5.5, 1L);
        dao.updateMaterial(20, 6.6, 1L);
    }




}
