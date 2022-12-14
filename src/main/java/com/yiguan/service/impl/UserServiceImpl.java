package com.yiguan.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.mysql.cj.util.StringUtils;
import com.yiguan.common.BaseResponse;
import com.yiguan.common.ErrorCode;
import com.yiguan.common.Result;
import com.yiguan.dao.UserDao;
import com.yiguan.dao.impl.UserDAOImpl;
import com.yiguan.model.entity.User;
import com.yiguan.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDAOImpl();

    @Override
    public BaseResponse<Boolean> userLogin(String userName, String userPwd) {
        if (userPwd == null || userPwd == null) {
            return Result.error(ErrorCode.PARAMS_ERROR);
        }
        User user = userDao.queryUserByNameAndPwd(userName, userPwd);
        if (BeanUtil.isEmpty(user)) {
            return Result.error(ErrorCode.PARAMS_ERROR, "用户名或者密码错误!");
        }
        return Result.success(true);
    }
}
