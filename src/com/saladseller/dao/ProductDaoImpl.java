package com.saladseller.dao;

import com.saladseller.model.Product;

import java.util.List;

/**
 * Created by Kay on 05/06/2017.
 */
public class ProductDaoImpl implements ProductDao{
    @Override
    public int countForUser(String m_id) throws Exception {
        return 0;
    }

    @Override
    public boolean insertProduct(Product p) throws Exception {
        return false;
    }

    @Override
    public boolean updateProduct(Product p) throws Exception {
        return false;
    }

    @Override
    public boolean deleteProduct(int p_id) throws Exception {
        return false;
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
