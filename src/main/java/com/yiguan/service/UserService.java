package com.yiguan.service;

import com.yiguan.common.BaseResponse;
import com.yiguan.model.dto.UserDTO;
import com.yiguan.model.entity.User;

public interface UserService {

    BaseResponse<Boolean> userLogin(String userName, String userPwd);



}
