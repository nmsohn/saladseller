<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		아이디와 비밀번호를 입력받을 수있는 창,
		로그인버튼과, 회원가입버튼..
	 --%>
		
	<form action = "login.do">
		아이디 : <input type= "text" name = "id"><br>
		비밀번호 :  <input type= "password" name = "pw"><br>
		<input type="submit" value = "로그인">
	</form>
	<input type="button" value="회원가입" 
	   onclick="location.href='joinForm.do'">
	
	
	
</body>
</html>