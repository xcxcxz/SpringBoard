<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
	<a href = "/board/reg">회원가입</a>
	<form action="login" onsubmit="return test()" method="post">
		
		ID:<input type="text" name="id"><br>
		PW:<input type="password" name="pw"><br>
		<font color="red">${message}</font>
		<input type="submit" value="login">
	</form>

</body>
</html>