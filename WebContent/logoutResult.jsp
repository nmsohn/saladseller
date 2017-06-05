<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	alert("로그아웃 성공!");
</script>
<%
	session.invalidate(); // 모든세션정보 삭제
	response.sendRedirect("loginForm.jsp"); // 로그인 화면으로 다시 돌아간다.
%>

