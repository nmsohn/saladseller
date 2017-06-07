package com.saladseller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.saladseller.model.Member;

public class MemberDao {
	// 작성해주세요~~~~~~
	private static MemberDao instance;

	private Connection connection;
	private static String URL = "jdbc:mysql://localhost:3306/saladseller";
	private static String USERNAME = "root";
	private static String PASSWORD = "elephantroom";

	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}

	private MemberDao() {
		// 드라이버 로딩
		// 디비연결
		// 연결획득

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertMember(Member member) {
		// 멤버 정보 삽입

		String sql = "insert into member (m_id, m_pass, m_email, m_addr, m_phone) values(?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, member.getM_id());
			pstmt.setString(2, member.getM_pw());
			pstmt.setString(3, member.getM_email());
			pstmt.setString(4, member.getM_addr());
			pstmt.setString(5, member.getM_phone());

			pstmt.executeUpdate();

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
	}

	public Member selectOne(String id) {
		String sql = "select * from member where m_id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member result = null;
		try {
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = new Member();
				result.setM_num(rs.getInt("m_num"));
				result.setM_id(rs.getString("m_id"));
				result.setM_pw(rs.getString("m_pass"));
				result.setM_email(rs.getString("m_email"));
				result.setM_addr(rs.getString("m_addr"));
				result.setM_phone(rs.getString("m_phone"));
			}
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

		return result;
	}

	public List<Member> selectAll() {
		String sql = "select * from member";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> result = new ArrayList<Member>();
		try {
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Member member = new Member();

				member.setM_num(rs.getInt("m_num"));
				member.setM_id(rs.getString("m_id"));
				member.setM_pw(rs.getString("m_pass"));
				member.setM_email(rs.getString("m_email"));
				member.setM_addr(rs.getString("m_addr"));
				member.setM_phone(rs.getString("m_phone"));

				result.add(member);
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

	public void updateMember(Member member) {
		// id를 기준으로 나머지 필드 수정
		String sql = "update member set m_num =?, m_pass =?, m_email =?, m_addr =?, m_phone =?  where id = ?";

		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, member.getM_num());
			pstmt.setString(2, member.getM_pw());
			pstmt.setString(3, member.getM_email());
			pstmt.setString(4, member.getM_addr());
			pstmt.setString(5, member.getM_phone());
			pstmt.setString(6, member.getM_id());

			// executeUpdate : update,insert,delete
			// executeQuery : select
			pstmt.executeUpdate();

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
	}
}
