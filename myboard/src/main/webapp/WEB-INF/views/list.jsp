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
	<div>
		<c:if test="${navi.currentPage ne 1 }">
			<a href="getBoardlist?page=1&searchWord=${searchWord}">[처음]</a>
		</c:if>
		<c:if test="${navi.currentPage ne 1}">
			<a href="getBoardlist?page=${navi.currentPage-1 }&searchWord=${searchWord}">[이전]</a>
		</c:if>
		<c:forEach var="counter" begin="${navi.startPageGroup }"
			end="${navi.endPageGroup }">
			<c:choose>
				<c:when test="${navi.currentPage eq  page}">
					<span style="font-weight: bold;"><a
						href="getBoardlist?page=${counter}&searchWord=${searchWord}">${counter}</a></span>
				</c:when>
				<c:otherwise>
					<a href="getBoardlist?page=${counter}&searchWord=${searchWord}">${counter}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if
			test="${navi.currentPage ne navi.endPageGroup+1 && navi.endPageGroup+1 > 0}">
			<a href="getBoardlist?page=${navi.endPageGroup+1 }&searchWord=${searchWord}">[다음]</a>
		</c:if>
		<c:if
			test="${navi.currentPage ne navi.totalRecordsCount && navi.totalRecordsCount > 0}">
			<a href="getBoardlist?page=${navi.totalPageCount }&searchWord=${searchWord}">[끝]</a>
		</c:if>
	</div>
	<form action="getBoardlist" method="get">
	<input type="hidden" value="${navi.currentPage}">검색 : <input type="text" name="searchWord" value="${searchword}">
	<input type="submit" value="검색">
	</form>



</body>
</html>