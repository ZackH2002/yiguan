package com.yiguan.dao.impl;

import com.yiguan.dao.DepositoryDAO;
import com.yiguan.model.dto.MaterialDTO;
import com.yiguan.model.entity.Material;
import com.yiguan.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepositoryDAOImpl implements DepositoryDAO {

    @Override
    public void saveMaterial(MaterialDTO material) {
        Long depositoryId = material.getDepositoryId();
        String name = material.getName();
        Integer quantity = material.getQuantity();
        Double price = material.getPrice();
        String sql = "INSERT INTO db_material(depository_id, material_name, quantity, price) VALUES(?,?,?,?)";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, depositoryId);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, quantity);
            preparedStatement.setDouble(4, price);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(preparedStatement, connection);
        }


    }

    @Override
    public Material queryMaterialById(Long id, String name) {
        Material material = null;
        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "SELECT * FROM db_material WHERE depository_id = ? AND material_name = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.prepareStatement(sql);
            // 给SQL语句占位符赋值
            statement.setLong(1, id);
            statement.setString(2, name);
            // 执行查询语句
            resultSet = statement.executeQuery();
            // 循环读取数据
            while (resultSet.next()) {
                material = new Material();
                material.setId(resultSet.getLong(1));
                material.setDepositoryId(resultSet.getLong(2));
                material.setMaterialName(resultSet.getString(3));
                material.setQuantity(resultSet.getInt(4));
                material.setPrice(resultSet.getDouble(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JDBCUtils.close(statement, conn);
            JDBCUtils.close(resultSet);
        }
        return material;

    }

    @Override
    public void updateMaterialExist(int count, double price, Long id) {
        String sql = "UPDATE db_material SET quantity = quantity + ? , price = price + ? WHERE id = ?";
        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
            // 给SQL语句占位符赋值
            statement.setInt(1, count);
            statement.setDouble(2, price);
            statement.setLong(3, id);
            System.out.println(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JDBCUtils.close(statement, conn);
        }

    }


    @Override
    public void updateMaterial(int count, double price, Long id) {
        String sql = "UPDATE db_material SET quantity = quantity - ? , price = price - ? WHERE id = ?";
        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
            // 给SQL语句占位符赋值
            statement.setInt(1, count);
            statement.setDouble(2, price);
            statement.setLong(3, id);
            System.out.println(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JDBCUtils.close(statement, conn);
        }
    }
}
