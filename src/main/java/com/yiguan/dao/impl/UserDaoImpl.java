package com.yiguan.dao.impl;

import com.yiguan.dao.UserDao;
import com.yiguan.model.entity.User;
import com.yiguan.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User queryByUsername(User user) {
        User user1 = null;
        int result = 0;
        Connection conn = JDBCUtils.getConnection();
        String sql = "select userName,userPassword from db_user where username='"+user.getUserName()+"'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.prepareStatement(sql);
            // 给SQL语句占位符赋值
            statement.setString(1, account);
            statement.setString(2, userPwd);
            // 执行查询语句
            resultSet = statement.executeQuery();
            // 循环读取数据
            while (resultSet.next()) {
                user = new UserLogin();
                user.setUserId(resultSet.getInt(1));
                user.setAccount(resultSet.getString(2));
                user.setUserPwd(resultSet.getString(3));
                user.setNickName(resultSet.getString(4));
                user.setBalance(resultSet.getDouble(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JDBCUtils.close(statement, conn);
            JDBCUtils.close(resultSet);
        }
        return user;
    }
    }
}
