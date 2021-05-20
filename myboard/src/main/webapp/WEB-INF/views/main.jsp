<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>${sessionScope.loginId}님의페이지</h1>
	
	<form action="logout" method="get">
		<input type="submit" value="logout">
	</form>
	<a href="/board/write">게시글 작성</a>
	<table>
	<tr>
	<td>제목</td>
	<td>작성자</td>
	<td>작성일</td>
	</tr>
	
	<c:forEach items="${list}" var="board">
	<tr>
	<td><a href="contentDetail?boardSeq=${board.boardSeq}">${board.title}</a></td>
	<td>${board.id}</td>
	<td>${board.regdate}</td>
	</tr>
	</c:forEach>
	</table>
	
</body>
</html>