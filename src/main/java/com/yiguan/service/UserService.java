package com.yiguan.service;

import com.yiguan.common.BaseResponse;
import com.yiguan.model.dto.UserDTO;
import com.yiguan.model.entity.User;

public interface UserService {

    BaseResponse<User> userLogin(String userName, String userPwd);

    BaseResponse<Boolean> addUser(User user);

}
