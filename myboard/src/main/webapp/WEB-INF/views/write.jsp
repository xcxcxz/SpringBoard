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
	<c:if test="${board.boardSeq != null}">
		<form action="updateBoard" method="post">
			<input type="hidden" name="boardSeq" value="${board.boardSeq}">
	</c:if>

	<c:if test="${board.boardSeq==null}">

		<form action="write" method="post">
	</c:if>
	제목:
	<textarea name="title">${board.title}</textarea>
	<br> 내용:
	<textarea rows="20" cols="20" name="content">${board.content}</textarea>
	<br>
	<input type="submit" value="등록하기">
	</form>


</body>
</html>