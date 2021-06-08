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

	<c:if test="${sessionScope.loginId==board.id}">
		<form action="deleteContent" method="post">
			<input type="hidden" name="boardSeq" value="${board.boardSeq}">
			<button type="submit">삭제</button>
		</form>
		<form action="updateBoard" method="get">
	 	<input type="hidden" name="boardSeq" value="${board.boardSeq}">
	 	<button type="submit">수정</button>
	</form>
	</c:if>
	<br>
	<form action="insertReply" method="post">
	<input type="hidden" value="${board.boardSeq}" name="boardSeq">
	댓글 : <input type="text" name="content"> <input type="submit" value="댓글등록">
	</form>
	<br>
	댓글목록
	<br>
	<c:forEach items="${reply}" var="hMap">
	${hMap.ID} : ${hMap.CONTENT} - ${hMap.REGDATE}
	<br>
	</c:forEach>

	<a href="/board/getBoardlist">목록으로</a>

</body>
</html>