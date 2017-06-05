package com.saladseller.dao;

import com.saladseller.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by nmsohn on 05/06/2017.
 */

public class ProductDaoImpl implements ProductDao{

    //Singleton Pattern
    private static ProductDaoImpl instance = new ProductDaoImpl();

    private ProductDaoImpl(){}
    public static ProductDaoImpl getInstance(){
        if(instance != null){
            instance = new ProductDaoImpl();
        }
        return instance;
    }

    @Override
    public int countForUser(String m_id) throws Exception {
        return 0;
    }

    @Override
    public boolean insertProduct(Product p) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into product (name, category, description, price, quantity, imgPath) "+
                "values(?,?,?,?,?,?)";
        boolean ok = false;
        try{
            conn = ConnectionProvider.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,p.getP_name());
            ps.setString(2,p.getCategory());
            ps.setString(3,p.getDescripttion());
            ps.setDouble(4,p.getPrice());
            ps.setInt(5,p.getQuantity());
            ps.setString(6,p.getImgPath());

            int i = ps.executeUpdate();
            if(i>0){
                ok = true;
            }
        }finally {
            ConnectionCloser.close(conn,ps);
        }
        return ok;
    }

    @Override
    public boolean updateProduct(Product p) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "update product set name=?, category=?, description =?,price=?,quantity=?,imgPath=? where p_id=?";
        boolean ok = false;
        try{
            conn = ConnectionProvider.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,p.getP_name());
            ps.setString(2,p.getCategory());
            ps.setString(3,p.getDescripttion());
            ps.setDouble(4,p.getPrice());
            ps.setInt(5,p.getQuantity());
            ps.setString(6,p.getImgPath());
            ps.setInt(7,p.getP_id());

            int i = ps.executeUpdate();
            if(i>0){
                ok = true;
            }
        }finally {
            ConnectionCloser.close(conn,ps);
        }
        return ok;
    }

    @Override
    public boolean deleteProduct(int p_id) throws Exception {
        boolean ok = false;
        Connection conn = null;
        PreparedStatement ps =null;
        String sql = "delete * from product where p_id=?";
        try {
            conn = ConnectionProvider.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, p_id);
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
    public Product findOne(int p_id) throws Exception {
        return null;
    }

    @Override
    public List<Product> findAll(int firstRow, int endRow) throws Exception {
        return null;
    }

    @Override
    public List<Product> findByCategory(int c_id) throws Exception {
        return null;
    }

    @Override
    public void productCount(int b_num) throws Exception {

    }

    @Override
    public void decreaseCount(int b_num) throws Exception {

    }
}