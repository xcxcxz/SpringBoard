# SpringBoard
개발환경
---------
### Language : JAVA 1.8  
### Framework : Spring 4.1  
### IDE : Eclipse  
### DB : Oracle 11g  

---------
  
1.기능  
<details>
  <summary>회원가입/로그인 기능(펼치기)</summary>
  
* 회원가입/로그인 기능  
>- 회원가입시 html ```<input type="email">```을 이용한 이메일 정규식활용.  
![image](https://user-images.githubusercontent.com/75213468/118921302-edaed380-b972-11eb-99a5-b64343b8a894.png)  
>- 로그인시 ```try/catch```문을 이용한 유효성 검사 및 Id or Pw가 틀릴경우 message에 담아놓은 문구가 표시되도록 함.  
![image](https://user-images.githubusercontent.com/75213468/118921575-61e97700-b973-11eb-9cb8-c7b1a0170420.png)  
>- 로그인 성공시 Id를 세션에 add하여 세션이 종료될때 까지 로그인이 유지되도록 설정.   
![image](https://user-images.githubusercontent.com/75213468/118922205-94e03a80-b974-11eb-8c0d-a3df8af2bf78.png)  
</details>
  
<details>
  <summary>회원탈퇴 기능(펼치기)</summary>
  
* 회원탈퇴 기능  
>- 회원탈퇴시 회원이 작성한 모든 게시물 삭제되도록 구현.  
![image](https://user-images.githubusercontent.com/75213468/119369238-e8dd7d00-bcee-11eb-88bd-75ef00daa141.png)
![image](https://user-images.githubusercontent.com/75213468/119369342-04488800-bcef-11eb-89ec-4a6ed5bfdb34.png)
</details>

<details>
  <summary>게시물 기능(펼치기)</summary>
  
* 게시물 작성(DB저장).  
>- 게시물 작성시 세션에 저장되어있는 Id를 get/set함으로써 DB에 게시물작성자 저장.  
![image](https://user-images.githubusercontent.com/75213468/118922906-c1e11d00-b975-11eb-8bad-422cf32e7b73.png)  

* 게시물 조회.  
>- 게시물 title 클릭시 해당게시물의 seq를 이용하여 DB로부터 해당게시물의 정보를 가져오며, 해당게시물의 상세페이지로 이동  
![image](https://user-images.githubusercontent.com/75213468/118923252-374ced80-b976-11eb-91b0-031573bee534.png)

* 게시물 수정.  
>- 작성자 id와 로그인 아이디를 ```<c:if>```태그를 이용하여 비교하며, 동일 id일시 게시글 수정버튼이 나오도록 설정 및 수정 가능하도록 설정.  
![image](https://user-images.githubusercontent.com/75213468/119348158-71502380-bcd7-11eb-9bd5-6af7d21989e7.png)  

* 게시물 삭제.  
>- 작성자 id와 로그인 아이디를 ```<c:if>```태그를 이용하여 비교하며, 동일 id일시 게시글 삭제버튼이 나오도록 설정 및 삭제 가능하도록 설정.

![image](https://user-images.githubusercontent.com/75213468/119148490-7f0f6a00-ba87-11eb-8090-b8ea7f530fd5.png) ![image](https://user-images.githubusercontent.com/75213468/119148936-f644fe00-ba87-11eb-8bdc-1c7785b4fad7.png)  
  </details>

2.테이블설계.  
>-Member  
![image](https://user-images.githubusercontent.com/75213468/119369446-25a97400-bcef-11eb-8786-ef3b1d4b4342.png)  
Board  
![image](https://user-images.githubusercontent.com/75213468/119369623-5a1d3000-bcef-11eb-8a91-145a554135ee.png)



