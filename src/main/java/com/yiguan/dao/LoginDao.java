package com.yiguan.dao;

import com.yiguan.entity.User;

public interface LoginDao {
    /**
     * 查询用户是否存在
     * @param username 用户账户
     * @param password 用户秘密
     * @return 用户实体
     */
    User queryUser(String username, String password);

    /**
     * 插入用户
     * @param username 用户账户
     * @param password 用户密码
     * @param authority 用户昵称
     * @return 插入是否成功 大于0 - 成功
     */
    int insertUser(String username, String password, String authority, String depository_id);

    /**
     * 通过账号查找用户
     * @param account 用户账户
     * @return 是否存在用户
     */
}
