<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	boolean result = (boolean)request.getAttribute("result");
	if(result){
		%>
			<script>
				alert("로그인 성공!");
				location.href("index.do");
			</script>
		<%
	}else{
		%>
			<script>
				alert("로그인 실패");
				location.href("loginForm.do");
			</script>		
		<%
	}
%>