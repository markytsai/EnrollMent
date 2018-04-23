package com.tjzhic.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {
    private ConnectionFactory() {
    }

    /**
     * 单利模式 创建工厂
     *
     * @return
     */

    public static Connection getConnection() {
        try {
            final String url = "jdbc:mysql://localhost:3306/bkxt";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection(url, "root", "caizhenya1997");
            //创建一个Statement对象
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();

        if (connection != null) {
            System.out.println("Connected successfully");
        } else {
            System.out.println("Connected failed");
        }
    }
}