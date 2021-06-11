<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container text-center">
		<h1>intro페이지</h1>
		<div class="row">
			<a href="/board/reg" class="btn btn-info">회원가입</a> <a href="/board/login" class="btn btn-info">로그인</a>
		</div>
		<div>
		▼개발자 github▼</div>
		<img src="resources/img/GITHUB_QR.png" id=mainImage alt="slide"/>
	</div>
	
	<script>
		var myImage = document.getElementById("mainImage");
		var imageArray = ["resources/img/GITHUB_QR.png", "resources/img/SPRING_BOARD_QR.png", "resources/img/NODE_BOARD_QR.png", "resources/img/INSTA_QR.png"];
		var imageIndex = 0;
		
		function changeImage(){
			myImage.setAttribute("src", imageArray[imageIndex]);
			imageIndex++;
			if(imageIndex >= imageArray.length){
				imageIndex = 0;
			}
		}
		setInterval(changeImage, 3000);
	</script>
</body>
</html>
