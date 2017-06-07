package com.saladseller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saladseller.dao.CommentDao;
import com.saladseller.model.Comment;




@WebServlet(urlPatterns = "/comment")

public class CommentServlet extends HttpServlet {

	CommentDao commentDao;

	public CommentServlet() {

		commentDao = commentDao.getInstance();
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

		if (reqURI.equals(contextPath + "/comment.do")) {

			String name = req.getParameter("name");	
			String pass = req.getParameter("pass");
			String content = req.getParameter("content");
			
			Comment comment = new Comment();
			comment.setName(name);
			comment.setPass(pass);
			comment.setContent(content);
			try{
				commentDao.insertComment(comment);
			}catch (Exception e){
				e.printStackTrace();
			}

			
		} else if (reqURI.equals(contextPath + "/commentlist.do")) {
			// 모든 회원정보를 조회
			try{
				List<Comment> commentList = commentDao.selectAll();
				String url = "/jsp/single.jsp";


				req.setAttribute("commentList", commentList);

				req.getRequestDispatcher(url)
						.forward(req, resp);
			}catch (Exception e){
				e.printStackTrace();
			}


			


		} 
	}

}
