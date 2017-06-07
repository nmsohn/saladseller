package com.saladseller.servlet;

import com.saladseller.dao.CategoryDaoImpl;
import com.saladseller.dao.ProductDaoImpl;
import com.saladseller.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by nmsohn on 2017-06-05.
 */@WebServlet(name = "productServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductDaoImpl productDao;
    CategoryDaoImpl categoryDao;

    public ProductServlet() {

        productDao = productDao.getInstance();
        categoryDao = categoryDao.getInstance();
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
//        String contextPath = req.getContextPath();
//        String reqURI = req.getRequestURI() +category;

        String contextPath = req.getContextPath();
        String reqURI = req.getRequestURI();

        if (reqURI.equals(contextPath + "/"+category)) {
            if (category != null) {
                List<Product> list = productDao.findByCategory(category);
                req.setAttribute("findByCategory", list);
            }
        }else if (reqURI.equals(contextPath + "/addForm.do")) {
        
            String name = req.getParameter("name");
            String cat = req.getParameter("category");
            Double price = Double.parseDouble(req.getParameter("price"));
            String description = req.getParameter("description");
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            String imgPath = req.getParameter("imagePath");
            Product p = new Product(name,cat,description,price,quantity,imgPath);
            boolean result = productDao.insertProduct(p);

            req.setAttribute("result", result);

        }

        getServletContext().setAttribute("category", category);
        req.getRequestDispatcher(reqURI).forward(req, resp);
    }
}
