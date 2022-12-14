package com.yiguan.dao;

import com.yiguan.model.entity.User;

public interface UserDao {
    public User queryByUsername(User user);
}
