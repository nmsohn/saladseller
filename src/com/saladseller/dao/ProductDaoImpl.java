package com.saladseller.dao;

import com.saladseller.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by nmsohn on 05/06/2017.
 */

public class ProductDaoImpl implements ProductDao {

    //Singleton Pattern
    private static ProductDaoImpl instance = new ProductDaoImpl();

    private ProductDaoImpl() {
    }

    public static ProductDaoImpl getInstance() {
        if (instance != null) {
            instance = new ProductDaoImpl();
        }
        return instance;
    }

    @Override
    public int countForUser(String m_id) {
        return 0;
    }

    @Override
    public boolean insertProduct(Product p) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into product (name, category, description, price, quantity, imgPath) " +
                "values(?,?,?,?,?,?)";
        boolean ok = false;
        try {
            conn = ConnectionProvider.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getP_name());
            ps.setString(2, p.getCategory());
            ps.setString(3, p.getDescription());
            ps.setDouble(4, p.getPrice());
            ps.setInt(5, p.getQuantity());
            ps.setString(6, p.getImgPath());

            int i = ps.executeUpdate();
            if (i > 0) {
                ok = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectionCloser.close(conn, ps);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return ok;
    }

    @Override
    public boolean updateProduct(Product p) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "update product set name=?, category=?, description =?,price=?,quantity=?,imgPath=? where p_id=?";
        boolean ok = false;
        try {
            conn = ConnectionProvider.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getP_name());
            ps.setString(2, p.getCategory());
            ps.setString(3, p.getDescription());
            ps.setDouble(4, p.getPrice());
            ps.setInt(5, p.getQuantity());
            ps.setString(6, p.getImgPath());
            ps.setInt(7, p.getP_id());

            int i = ps.executeUpdate();
            if (i > 0) {
                ok = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectionCloser.close(conn, ps);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }   
        return ok;
    }
    @Override
    public boolean deleteProduct(int p_id){
        boolean ok = false;
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "delete * from product where p_id=?";
        try {
            conn = ConnectionProvider.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, p_id);
            int i = ps.executeUpdate();
            if (i > 0) {
                ok = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectionCloser.close(conn, ps);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ok;

    }


    @Override
    public Product findOne(int p_id) {
        return null;
    }

    @Override
    public List<Product> findAll(int firstRow, int endRow) {
        return null;
    }

    @Override
    public List<Product> findByCategory(String category) {
        return null;
    }

    @Override
    public void productCount(int b_num) {

    }

    @Override
    public void decreaseCount(int b_num) {

    }
}
