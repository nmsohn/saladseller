<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	//update/delete인지 확인하고
	// 각각에 맞게 요청실행
	if(window.name == "update"){
		window.opener.parent.location.href = "BoardServlet?command=board_update_form&num=${param.num}";
	}else if(window.name == "delete"){
		alert('삭제되었습니다.');
		window.opener.parent.location.href = "BoardServlet?command=board_delete&num=${param.num}";
	}
	
	window.close();
</script>