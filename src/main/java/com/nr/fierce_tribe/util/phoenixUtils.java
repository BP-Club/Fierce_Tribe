package com.nr.fierce_tribe.util;

import java.sql.*;

public class phoenixUtils {

    /**
     * 获得phoenix SQL查询
     * @return
     * @auth dailinwei
     * @throws SQLException
     */
    public ResultSet action(String url,String user,String password,String sql) {
        Connection connection = null;
        Statement statement = null;
        ResultSet set = null;
        try {
            Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
            connection = DriverManager.getConnection(url,user,password);
            statement = connection.createStatement();
            set = statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    /**
     * 获得phoenix SQL连接
     * @return
     * @auth dailinwei
     * @throws SQLException
     */
    public static Connection getConnection(String url) throws SQLException {
        return DriverManager.getConnection(url);
    }
}