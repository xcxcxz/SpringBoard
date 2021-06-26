<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
	<div class="container text-center">
		<h1>intro페이지</h1>
		<div class="row">
			<a href="/board/reg" class="btn btn-info">회원가입</a> <a
				href="/board/login" class="btn btn-info">로그인</a>
		</div>
		<div>▼개발자 github▼</div>
		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"
			onclick="plusDivs(-1)"></span> <img src="resources/img/GITHUB_QR.png"
			id=mainImage alt="slide" /> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"
			onclick="plusDivs(+1)"></span>
		<div>
			<button id="paypay" type="button">기부하기</button>
		</div>
	</div>

	<script>
		var myImage = document.getElementById("mainImage");
		var imageArray = [ "resources/img/GITHUB_QR.png",
				"resources/img/SPRING_BOARD_QR.png",
				"resources/img/NODE_BOARD_QR.png", "resources/img/INSTA_QR.png" ];
		var imageIndex = 0;

		function changeImage() {
			myImage.setAttribute("src", imageArray[imageIndex]);
			imageIndex++;
			if (imageIndex >= imageArray.length) {
				imageIndex = 0;
			}
		}
		setInterval(changeImage, 3000);

		function plusDivs(n) {
			myImage.setAttribute("src", imageArray[imageIndex]);
			imageIndex++;
			if (imageIndex >= imageArray.length) {
				imageIndex = 0;
			}
		}
	</script>
	<script>
		$("#paypay").click(function() {
			IMP.init("imp59427294");
			IMP.request_pay({ // param
				pg : "html5_inicis",
				pay_method : "card",
				merchant_uid : "ORD20180131-0000011",
				amount : 100,
				buyer_name : "홍길동"
			}, function(rsp) { // callback
				console.log(rsp);
				if (rsp.success) {
					var msg = '결제가 완료되었습니다.';
					msg += '고유ID : ' + rsp.imp_uid;
					msg += '상점 거래ID : ' + rsp.merchant_uid;
					msg += '결제 금액 : ' + rsp.paid_amount;
					msg += '카드 승인번호 : ' + rsp.apply_num;
				} else {
					var msg = '결제에 실패하였습니다.';
					msg += '에러내용 : ' + rsp.error_msg;
				}
				alert(msg);
			});
		});
	</script>
</body>
</html>
