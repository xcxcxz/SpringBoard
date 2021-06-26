<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
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
		<input type="hidden" value="${navi.currentPage}">검색 : <input
			type="text" name="searchWord" value="${searchword}"> <input
			type="submit" value="검색">
	</form>
	<div>

		<a href="#" id="paypay" type="button">기부하기</a>
	</div>
	<script>
		$("#paypay").click(function() {
			IMP.init("imp59427294");
			IMP.request_pay({ // param
				pg : "html5_inicis",
				pay_method : "card",
				merchant_uid : 'merchant_' + new Date().getTime(),
				amount : 100,
				buyer_name : ${sessionScope.loginId}
			}, function(rsp) { // callback
				console.log(rsp);
				if (rsp.success) {
					var msg = '결제가 완료되었습니다.';
					msg += '결제자ID : ' + rsp.buyer_name;
					msg += '고유ID : ' + rsp.imp_uid;
					msg += '상점 거래ID : ' + rsp.merchant_uid;
					msg += '결제 금액 : ' + rsp.paid_amount;
					msg += '카드 승인번호 : ' + rsp.apply_num;
					msg += '::' + rsp;
					
					$.ajax({
				        url: "http://localhost:8080/board/give",
				        type:"post",
				        data: JSON.stringify(rsp),
				        contentType: "application/json",
				        success: function(data) {
				            alert("통신성공" + data);
				        },
				        error: function() {
				            alert("error");
				        }
				    }) 
					//$.post("http://localhost:8080/board/login#/", rsp);


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