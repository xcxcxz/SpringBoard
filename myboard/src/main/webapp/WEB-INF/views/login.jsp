<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>로그인</h1>
			
			<form action="login" onsubmit="return test()" method="post"
				class="form-horizontal">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">ID
						: </label>
					<div class="col-xs-4">
						<input type="text" name="id" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">PW
						: </label>
					<div class="col-xs-4">
						<input type="password" name="pw" class="form-control">
					</div>
				</div>
				<br> <font color="red">${message}</font>
				<div class="form-row float-right">
					<input type="submit" value="login" class="btn btn-success">
					<a href="/board/reg" class="btn btn-success">회원가입</a>
				</div>
			</form>
		</div>
	</div>

</body>
</html>