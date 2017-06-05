<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel= "stylesheet" type = "text/css" href = "css/board.css">
<script type="text/javascript" src = "script/board.js"></script>
<title>게시글 수정</title>
</head>
<body>
	<%--
		포함 되어야 될 내용
		큰 틀은 boardWrite.jsp와 동일...
		기존내용이 포함되어 있어야함..
	 --%>
	 <form action = "BoardServlet" name= "frm" method = "post">
	 	<input type="hidden" name = "command" value = "board_update">
	 	<input type= "hidden" name = "num" value = "${board.num}">
	 	
	 	<table>
	 		<tr>
	 			<th>작성자</th>
	 			<td><input type = "text" name = "name" 
	 			value = "${board.name}" readonly="readonly">*필수</td>
	 		</tr>
	 		
	 		<tr>
	 			<th>비밀번호</th>
	 			<td><input type = "password" name = "pass">*필수(게시판 수정 삭제시 필요)</td>
	 		</tr>
	 		
	 		<tr>
	 			<th>이메일</th>
	 			<td><input type = "text" name = "email" 
	 			value = "${board.email}" readonly="readonly"></td>
	 		</tr>
	 		
	 		<tr>
	 			<th>제목</th>
	 			<td><input type = "text" name = "title"
	 			 value = "${board.title}"></td>
	 		</tr>
	 		
	 		<tr>
	 			<th>내용</th>
	 			<td>
	 				<textarea rows="15" cols="70" name = content>
	 					${board.content}
	 				</textarea>
	 			</td>
	 		</tr>
	 	</table>
	 	<br>
	 	<input type = "submit" value = "수정" onclick="return boardCheck()">
	 	<input type = "reset" value = "다시 작성">
	 	<input type = "button" value = "목록" onclick="location.href='BoardServlet?command=board_list'">
	 </form>
	 
	 
	 
</body>
</html>