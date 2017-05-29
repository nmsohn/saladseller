package com.saladseller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by nmsohn on 2017-05-29.
 */
public class ConnectionProvider {
    private static Connection conn = null;
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/saladseller";
    private static String USERNAME = "root";
    private static String PASSWORD = "";

    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER);
        conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        return conn;
    }
}
