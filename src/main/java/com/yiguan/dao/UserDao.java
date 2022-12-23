package com.yiguan.dao;

import com.yiguan.model.entity.User;

public interface UserDao {

    /**
     * 通过用户id查询用户
     * @param id 用户id
     * @return User对象
     */
    User queryUserById(Long id);

    /**
     * 通过用户名和密码查询用户
     * @param userName 用户名
     * @param userPwd 密码
     * @return User对象
     */
    User queryUserByNameAndPwd(String userName, String userPwd);

    /**
     * 添加用户
     * @param user 用户实体
     */
    void addUser(User user);

}
