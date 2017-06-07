package com.saladseller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.saladseller.model.Comment;
import com.saladseller.model.Member;

public class CommentDao {
	private static CommentDao instance;

	private Connection connection;
	private static String URL = "jdbc:mysql://localhost:3306/saladseller";
	private static String USERNAME = "root";
	private static String PASSWORD = "elephantroom";

	public static CommentDao getInstance() {
		if (instance == null) {
			instance = new CommentDao();
		}
		return instance;
	}

	private CommentDao() {
		// 드라이버 로딩
		// 디비연결
		// 연결획득
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로딩실패");
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	public void insertComment(Comment comment) throws Exception{
		// 댓글 정보 삽입
		connection = ConnectionProvider.getConnection();
		String sql = "insert into comment (name, pass, content) values(?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, comment.getName());
			pstmt.setString(2, comment.getPass());
			pstmt.setString(3, comment.getContent());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<Comment> selectAll()  throws Exception{
		connection = ConnectionProvider.getConnection();
		String sql = "select * from comment";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Comment> result = new ArrayList<Comment>();
		try {
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Comment comment = new Comment();

				comment.setName(rs.getString("name"));
				comment.setPass(rs.getString("pass"));
				comment.setContent(rs.getString("content"));

				result.add(comment);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}
}
