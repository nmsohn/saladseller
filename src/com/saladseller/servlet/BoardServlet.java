package com.saladseller.servlet;

import com.saladseller.dao.BoardDaoImpl;
import com.saladseller.model.Board;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by nmsohn on 04/06/2017.
 */
public class BoardServlet extends HttpServlet {
    BoardDaoImpl dao;

    public BoardServlet() {

        dao = dao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doProc(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doProc(req, resp);
    }

    public void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String contextPath = req.getContextPath();
        String reqURI = req.getRequestURI();

        if (reqURI.equals(contextPath + "/board.do")) {

            String name = req.getParameter("name");
            String category = req.getParameter("category");
            String description = req.getParameter("description");
            String price = req.getParameter("price");
            String quantity = req.getParameter("quantity");

//            Board board= new Board();
//            board.setTitle(name);
//            board.setContent(pass);
//            comment.setContent(content);
//
//            commentDao.insertComment(comment);
//
//        } else if (reqURI.equals(contextPath + "/commentlist.do")) {
//            // 모든 회원정보를 조회
//
//            List<Comment> commentList = commentDao.selectAll();
//            String url = "/jsp/single.jsp";
//
//
//            req.setAttribute("commentList", commentList);
//
//            req.getRequestDispatcher(url)
//                    .forward(req, resp);
//
//
//
        }
    }
}
