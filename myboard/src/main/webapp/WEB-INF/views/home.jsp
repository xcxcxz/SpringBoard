<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>회원가입</h1>

	<form action="insertMember" method="post">
		ID:<input type="text" name="id"><br>
		<font color="red">${message}</font><br>
		PW:<input type="password" name="pw"><br>
		NAME:<input type="text" name="name"><br>
		PHONE:<input type="tel" name="phone"><br>
		EMAIL:<input type="email" name="email"><br>
		BIRTHDATE:<input type="date" name="birthdate"><br>
		<input type="submit" value="SIGNUP">
	</form>
</body>
</html>
