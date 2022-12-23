package com.yiguan.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.yiguan.common.BaseResponse;
import com.yiguan.common.ErrorCode;
import com.yiguan.common.Result;
import com.yiguan.dao.UserDao;
import com.yiguan.dao.impl.UserDAOImpl;
import com.yiguan.model.dto.UserDTO;
import com.yiguan.model.entity.User;
import com.yiguan.service.UserService;
import com.yiguan.utils.UserHolder;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDAOImpl();

    @Override
    public BaseResponse<User> userLogin(String userName, String userPwd) {
        if (userPwd == null || userPwd == null) {
            return Result.error(ErrorCode.PARAMS_ERROR);
        }
        User user = userDao.queryUserByNameAndPwd(userName, userPwd);
        System.out.println("user = " + user);
        if (!BeanUtil.isEmpty(user)) {
            return Result.success(user);
        }
        return Result.error(ErrorCode.PARAMS_ERROR, "用户名或者密码错误!");
    }

    @Override
    public BaseResponse<Boolean> addUser(User user) {

        try {
            userDao.addUser(user);
            return Result.success(Boolean.TRUE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
