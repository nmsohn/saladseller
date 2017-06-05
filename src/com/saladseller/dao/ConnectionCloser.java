package com.saladseller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 5CLASS-184 on 2017-05-31.
 */
public class ConnectionCloser {

    public static void close(Connection conn, PreparedStatement ps) throws SQLException{
        if(conn != null){
                conn.close();
        }
        if(ps != null){
            ps.close();
        }
    }
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException{
        if(conn != null){
            conn.close();
        }
        if(ps != null){
            ps.close();
        }
        if(rs != null){
            rs.close();
        }
    }
    public static void close(Connection conn) throws SQLException {
        if(conn != null){
            conn.close();
        }
    }
}
