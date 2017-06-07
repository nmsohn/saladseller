package com.saladseller.dao;

import com.saladseller.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 5CLASS-184 on 2017-05-31.
 */
public class CategoryDaoImpl implements CategoryDao{
	 private static CategoryDaoImpl instance = new CategoryDaoImpl();

	    private CategoryDaoImpl() {
	    }

	    public static CategoryDaoImpl getInstance() {
	        if (instance != null) {
	            instance = new CategoryDaoImpl();
	        }
	        return instance;
	    }
    @Override
    public boolean addCategory(Category c) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        PreparedStatement ps =null;
        String sql = "insert into category value(?,?)";
        boolean ok = false;
        try {
            conn = ConnectionProvider.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, c.getC_id());
            ps.setString(2, c.getC_name());
            int i = ps.executeUpdate();
            if(i>0){
                ok=true;
            }

        }finally {
            ConnectionCloser.close(conn,ps);
        }
        return ok;
    }

    @Override
    public boolean updateCategory(Category c) throws SQLException, ClassNotFoundException {
        boolean ok = false;
        Connection conn = null;
        PreparedStatement ps =null;
        String sql = "update category set c_name =?where c_id=? ";
        try {

            conn = ConnectionProvider.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, c.getC_name());
            ps.setInt(2, c.getC_id());
            int i = ps.executeUpdate();
            if(i>0){
                ok=true;
            }
        }finally {
            ConnectionCloser.close(conn,ps);
        }
        return ok;
    }
    @Override
    public boolean delCategory(int c_id) throws SQLException, ClassNotFoundException {
        boolean ok = false;
        Connection conn = null;
        PreparedStatement ps =null;
        String sql = "delete * from category where c_id=?";
        try {
            conn = ConnectionProvider.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, c_id);
            int i = ps.executeUpdate();
            if(i>0){
                ok=true;
            }
        }finally {
            ConnectionCloser.close(conn,ps);
        }
        return ok;
    }

    @Override
    public List<Category> getList() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from category";
        List<Category> list = new ArrayList<Category>();
        try{
            conn = ConnectionProvider.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("c_id");
                String name = rs.getString("c_name");
                list.add(new Category(id,name));
            }
        }finally {
            ConnectionCloser.close(conn,ps,rs);
        }
        return list;
    }

    @Override
    public Category getCategory(int c_id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from category where c_id=?";
        Category cat = new Category();

        try{
            conn = ConnectionProvider.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,c_id);
            rs = ps.executeQuery();
            if(rs.next()){
                int id = rs.getInt("c_id");
                String name = rs.getString("c_name");
                cat = new Category(id,name);
            }
        }finally {
            ConnectionCloser.close(conn,ps,rs);
        }

        return cat;
    }

}
