package com.study;

import com.yiguan.common.BaseResponse;
import com.yiguan.dao.UserDao;
import com.yiguan.dao.impl.UserDAOImpl;
import com.yiguan.model.entity.User;
import com.yiguan.service.UserService;
import com.yiguan.service.impl.UserServiceImpl;
import org.junit.Test;

public class QueryTest {

    private UserDao userDao = new UserDAOImpl();

    private UserService userService = new UserServiceImpl();

    @Test
    public void  queryUserTest() {
        BaseResponse<Boolean> response = userService.userLogin("1", "2");
        System.out.println("response = " + response);
        User user = userDao.queryUserByNameAndPwd("1", "2");
        System.out.println(user);
    }


}
