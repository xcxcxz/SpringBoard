<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글상세</h1>


	제목 : ${board.title}<br> 
	작성자 : ${board.id}<br> 
	작성일 : ${board.regdate}<br>
	내용 : ${board.content}<br>

	<br>

	<a href="/board/getBoardlist">목록으로</a>

</body>
</html>