package com.saladseller.dao;

import com.saladseller.model.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 5CLASS-184 on 2017-05-31.
 */
public interface CategoryDao {
    public boolean addCategory(Category c) throws SQLException, ClassNotFoundException;
    public boolean delCategory(int c_id) throws SQLException, ClassNotFoundException;
    public List<Category> getList() throws SQLException, ClassNotFoundException;
    public Category getCategory(int c_id) throws SQLException, ClassNotFoundException;
    public boolean updateCategory(Category c) throws SQLException, ClassNotFoundException;
}
