<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<th bgcolor="orange" width="100">번호</td>
			<th bgcolor="orange" width="200">제목</td>
			<th bgcolor="orange" width="150">작성자</td>			
			<th bgcolor="orange" width="150">등록일</td>
			<th bgcolor="orange" width="100">조회수</td>
		</tr>
		<c:forEach var="board" items="${boardList}">
		<tr>
			<td>${board.seq }</td>
			<td align="left"><a href="getBoard?seq=${board.seq }">${board.title }</a></td>
			<td>${board.writer }</td>			
			<td><fmt:formatDate value="${board.createDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
			<td>${board.cnt }</td>
		</tr>
		</c:forEach>		
	</table>
	<br>
	<a href="insertBoard">새글 등록</a>	
</body>
</html>