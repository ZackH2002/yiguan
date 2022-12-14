package com.study;


import com.yiguan.dao.UserDao;
import com.yiguan.dao.impl.UserDAOImpl;
import com.yiguan.model.entity.User;
import org.junit.Test;

public class test {

    private UserDao userDao = new UserDAOImpl();

    @Test
    public void testQueryUser() {
//        User user = userDao.queryUserById(1L);
//        System.out.println(user);
        User user1 = userDao.queryUserByNameAndPwd("1", "2");
        System.out.println(user1);
    }



}
