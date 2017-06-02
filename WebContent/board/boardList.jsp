<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/board.css">
<title>Insert title here</title>

</head>
<body>
	<%--여기다가....게시글 목록을 출력합니다
		서버에다가 목록을 출력해 달라는 요청을 해야합니다..
	 --%>
	 <div id = "wrap" align = "center">
	 	<table class ="list">
	 			<tr>
	 				<td colspan="5" style="border: white; text-align: right"> 
	 					<a href = "BoardServlet?command=board_write_form">게시글 등록</a>
	 				</td>
	 			</tr>
	 			<tr>
	 				<th>번호</th>
	 				<th>제목</th>
	 				<th>작성자</th>
	 				<th>작성일</th>
	 				<th>조회수</th>
	 			</tr>
	 			
	 			<c:forEach var = "board" items = "${boardList}">
	 				<tr>
	 					<td>${board.num}</td>
	 					<td><a href ="BoardServlet?command=board_view&num=${board.num}">${board.title}</a></td>
	 					<td>${board.name}</td>
	 					<td> <fmt:formatDate value="${board.writedate}" type = "date"/> </td>
	 					<td>${board.readCount}</td>
	 				</tr>
	 			</c:forEach>
	 	</table>
	  </div>
	 
	 
	 
		
	 
	 
	 
</body>
</html>