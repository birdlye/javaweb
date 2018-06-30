package com.tjyd.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

    public static void main(String[] args) {
        JdbcUtils jdbcUtils=new JdbcUtils();
        jdbcUtils.getConnection();
    }
    public Connection getConnection(){
        try {
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
        System.out.println(conn);
        return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
