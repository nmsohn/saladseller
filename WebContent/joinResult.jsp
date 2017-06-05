<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	boolean result = (boolean)request.getAttribute("result");


	if(result){
		//회원가입완료! 메시지 출력 후, loginForm으로 이동
		%>
			<script>
				alert("회원가입 성공!");
				location.href("loginForm.do");
			</script>
		
		<%
	}else{
		//회원가입 실패! 메시지 출력 후, joinForm으로 이동 
		%>
			<script>
				alert("회원가입 실패 ㅠㅠ");
				location.href("joinForm.do");
			</script>		
		<%
	}

%>    
<%--
	join.do의 요청결과를 alert()으로 출력하고..
	결과에 따라서...성공이면 loginForm.do
	실패면 joinForm.do
 --%>

