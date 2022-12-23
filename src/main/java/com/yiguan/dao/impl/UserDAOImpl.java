package com.yiguan.dao.impl;

import com.yiguan.dao.UserDao;
import com.yiguan.model.entity.User;
import com.yiguan.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDao {

    @Override
    public User queryUserById(Long id) {
        User user = null;
        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "SELECT * FROM db_user WHERE user_id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.prepareStatement(sql);
            // 给SQL语句占位符赋值
            statement.setLong(1, id);
            // 执行查询语句
            resultSet = statement.executeQuery();
            // 循环读取数据
            while (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getLong(1));
                user.setUserName(resultSet.getString(2));
                user.setUserPassword(resultSet.getString(3));
                user.setUserAuth(resultSet.getInt(4));
                user.setEntryDate(resultSet.getDate(5));
                user.setPhone(resultSet.getString(6));
                user.setGender(resultSet.getInt(7));
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


    @Override
    public User queryUserByNameAndPwd(String userName, String userPwd) {
        User user = null;
        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "SELECT * FROM db_user WHERE userName = ? AND userPassword = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.prepareStatement(sql);
            // 给SQL语句占位符赋值
            statement.setString(1, userName);
            statement.setString(2, userPwd);
            // 执行查询语句
            resultSet = statement.executeQuery();
            // 循环读取数据
            while (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getLong(1));
                user.setUserName(resultSet.getString(2));
                user.setUserPassword(resultSet.getString(3));
                user.setUserAuth(resultSet.getInt(4));
                user.setEntryDate(resultSet.getDate(5));
                user.setPhone(resultSet.getString(6));
                user.setGender(resultSet.getInt(7));
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

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO db_user(userName, userPassword, phone, gender) VALUES(?,?,?,?)";
        String password = user.getUserPassword();
        String userName = user.getUserName();
        int gender = user.getGender();
        String phone = user.getPhone();
        PreparedStatement statement = null;
        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        try {
            statement = conn.prepareStatement(sql);
            // 给SQL语句占位符赋值
            statement.setString(1, userName);
            statement.setString(2, password);
            statement.setString(3, phone);
            statement.setInt(4, gender);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(statement, conn);
        }

    }
}
