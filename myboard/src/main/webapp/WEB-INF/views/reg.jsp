<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>reg</title>
</head>
<body>
	<h1>회원가입</h1>

	<form action="reg" method="post">
		ID:<input type="text" id="id" name="id">
		<button type="button" class="idCheck" id="idCheck"
			onclick="fn_idCheck();" value="N">중복확인</button>
		<div id="idmessage"></div>
		PW:<input type="password" id="pw" name="pw"><br>
		<div id="pwmessage"></div>
		NAME:<input type="text" name="name"><br> PHONE:<input
			type="tel" name="phone"><br> EMAIL:<input type="email"
			name="email"><br> BIRTHDATE:<input type="date"
			name="birthdate"><br>
		<button type="submit" id="submit" disabled="disabled">회원가입</button>
	</form>
	<script>
		function fn_idCheck() {
			$.ajax({
				url : "/board/idCheck",
				type : "post",
				dataType : "json",
				data : {
					"id" : $("#id").val()
				},
				success : function(data) {
					if (data == 1) {
						alert("중복된 아이디 입니다.");
						$("#submit").attr("disabled", "disabled");
					} else if (data == 0) {
						$("#idCheck").attr("value", "Y");
						alert("사용가능한 아이디입니다.", data);
						$("#submit").removeAttr("disabled");
					}
				}
			})
			
		}
	</script>
</body>
</html>
