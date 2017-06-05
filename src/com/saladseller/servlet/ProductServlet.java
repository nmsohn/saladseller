package com.saladseller.servlet;

import com.saladseller.dao.ProductDaoImpl;
import com.saladseller.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by nmsohn on 2017-06-05.
 */
public class ProductServlet extends HttpServlet {
    ProductDaoImpl productDao;

    public ProductServlet() {

        productDao = productDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doProc(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProc(req, resp);
    }

    protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //set category path

        String category= req.getParameter("category");
        String contextPath = req.getContextPath();
        String reqURI = req.getRequestURI() +category;

        if (contextPath.equals("/"+category)) {
            if (category != null) {
                List<Product> list = productDao.findByCategory(category);
                req.setAttribute("findByCategory", list);
            }
        }
        getServletContext().setAttribute("category", category);
        req.getRequestDispatcher(reqURI).forward(req, resp);
    }
}
