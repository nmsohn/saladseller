package com.saladseller.dao;

import com.saladseller.model.Order;

/**
 * Created by 5CLASS-184 on 2017-06-02.
 */
public interface OrderDao {
    public int placeOrder(Order order) throws Exception;
}
