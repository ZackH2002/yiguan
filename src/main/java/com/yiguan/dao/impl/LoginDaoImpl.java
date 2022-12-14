package com.yiguan.dao.impl;

import com.yiguan.dao.LoginDao;
import com.yiguan.entity.User;
import com.yiguan.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {
    @Override
    public User queryUser(String username, String password) {
        User user = null;

        return user;
    }

    @Override
    public int insertUser(String username, String password, String authority, String depository_id) {
        return 0;
    }
}
