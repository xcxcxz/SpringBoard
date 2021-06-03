<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>${sessionScope.loginId}님의페이지</h1>

	<form action="deleteMember" method="post"
		onsubmit="return confirm('정말 회원탈퇴를 하시겠습니까?(모든 게시물이 삭제됩니다.)');">
		<input type="submit" value="회원탈퇴">
	</form>

	<form action="logout" method="get">
		<input type="submit" value="logout">
	</form>
	<a href="/board/write">게시글 작성</a>
	<a href="/board/getBoardlist">게시글 목록</a>
	
	<form action="getBoardlist" method="get">
	<input type="hidden" value="${navi.currentPage}">검색 : <input type="text" name="searchWord" value="${searchword}">
	<input type="submit" value="검색">
	</form>



</body>
</html>