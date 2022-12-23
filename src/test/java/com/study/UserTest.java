package com.study;

import com.yiguan.dao.UserDao;
import com.yiguan.dao.impl.UserDAOImpl;
import com.yiguan.model.entity.User;
import org.junit.Test;

public class UserTest {

    private UserDao userDao = new UserDAOImpl();

    @Test
    public void insertUser() {
        User u = new User();
        u.setUserName("张三");
        u.setUserPassword("123456");
        u.setPhone("123456789");
        u.setGender(0);
        userDao.addUser(u);

    }

}
