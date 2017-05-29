<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- id,pw,name,email을 사용자로 부터 입력받아서
		join요청을 합니다.
	 -->

	<form action = "join.do" method="post">
		아이디 : <input type= "text" name = "id"> <br>
		비밀번호 : <input type= "password" name = "pw"><br>
		이메일 : <input type= "text" name = "email"><br>
		주소 : <input type= "text" name = "addr"><br>
		전화번호 : <input type= "text" name = "phone"><br>
		<br>
		<br>
		<input type="submit" value="회원가입">
		<input type="reset" value = "다시 작성">
		
	</form>
</body>
</html>