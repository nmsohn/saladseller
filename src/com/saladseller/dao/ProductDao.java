package com.saladseller.dao;

import com.saladseller.model.Product;
import java.util.List;

/**
 * Created by nmsohn on 2017-06-02.
 */
public interface ProductDao {
    public int countForUser(String m_id);
    public boolean insertProduct(Product p);
    public boolean updateProduct(Product p);
    public boolean deleteProduct(int p_id);
    public Product findOne(int p_id);
    public List<Product> findAll(int firstRow, int endRow);
    public List<Product> findByCategory(String category);
    public void productCount(int b_num);
    public void decreaseCount(int b_num);

}
