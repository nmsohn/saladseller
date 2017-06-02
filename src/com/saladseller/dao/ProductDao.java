package com.saladseller.dao;

import com.saladseller.model.Product;
import java.util.List;

/**
 * Created by 5CLASS-184 on 2017-06-02.
 */
public interface ProductDao {
    public int countForUser(String m_id )  throws Exception;
    public boolean insertProduct(Product p)  throws Exception;
    public boolean updateProduct(Product p)  throws Exception;
    public boolean deleteProduct(int p_id)  throws Exception;
    public Product findOne(int p_id)  throws Exception;
    public List<Product> findAll(int firstRow, int endRow)  throws Exception;
    public List<Product> findByCategory(int c_id)  throws Exception;
    public void productCount (int b_num) throws Exception;
    public void decreaseCount(int b_num) throws Exception;

}
