<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>reg</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>회원가입</h1>

			<form action="reg" method="post" class="form-horizontal">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">ID
						: </label>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="id" name="id">
					</div>

					<button type="button" class="btn btn-info" id="idCheck"
						onclick="fn_idCheck();" value="N">중복확인</button>
					<div id="idmessage"></div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">PW
						: </label>
					<div class="col-xs-4">
						<input type="password" id="pw" class="form-control" name="pw">
					</div>
					<div id="pwmessage"></div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">NAME
						: </label>
					<div class="col-xs-4">
						<input type="text" name="name" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">PHONE
						: </label>
					<div class="col-xs-4">
						<input type="tel" name="phone" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">EMAIL
						: </label>
					<div class="col-xs-4">
						<input type="email" name="email" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">BIRTHDATE
						: </label>
					<div class="col-xs-4">
						<input type="date" name="birthdate" class="form-control">
					</div>
				</div>
				<div class="form-row float-right">
					<button type="submit" id="submit" disabled="disabled"
						class="btn btn-success">회원가입</button>
					<a href="/board/login" class="btn btn-success">돌아가기</a>
				</div>
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
		</div>
	</div>
</body>
</html>