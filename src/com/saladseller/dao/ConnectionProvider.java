package com.saladseller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionProvider {
    private static Connection conn = null;
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/saladseller";
    private static String USERNAME = "root";
    private static String PASSWORD = "lovely9251";

    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER);
        conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        return conn;
    }
}