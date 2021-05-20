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
	<h1>게시글 작성</h1>

	<form action="write" method="post">
		제목: <input type="text" name="title"><br> 내용:
		<textarea rows="20" cols="20" name="content"></textarea>
		<br> <input type="submit" value="등록하기">
	</form>

</body>
</html>