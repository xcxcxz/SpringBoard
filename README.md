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
>- 회원가입시 jquery / ajax를 이용한 중복확인 기능 구현.(아이디 비중복시 회원가입 버튼 활성화)  
![image](https://user-images.githubusercontent.com/75213468/120637211-90a23a00-c4a9-11eb-8712-e8b991b5a503.png)  
![image](https://user-images.githubusercontent.com/75213468/120637333-ba5b6100-c4a9-11eb-8617-1ef218b6e2f9.png)  


</details>
  
<details>
  <summary>회원탈퇴 기능(펼치기)</summary>
  
* 회원탈퇴 기능  
>- 회원탈퇴시 회원이 작성한 모든 게시물 삭제되도록 구현.  
![image](https://user-images.githubusercontent.com/75213468/119369238-e8dd7d00-bcee-11eb-88bd-75ef00daa141.png)
![image](https://user-images.githubusercontent.com/75213468/120614677-714be280-c492-11eb-81ec-3e9924a55fd5.png)
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
  
* 게시물 페이징처리.  
>- 게시물 페이징 처리
  
![image](https://user-images.githubusercontent.com/75213468/120614259-00a4c600-c492-11eb-9a4d-54a4d3919419.png) ![image](https://user-images.githubusercontent.com/75213468/120614302-0bf7f180-c492-11eb-8b89-bb5fccd65496.png)  

* 게시물 검색기능.  
>- 게시물 겸색기능
  
![image](https://user-images.githubusercontent.com/75213468/120619879-5f207300-c497-11eb-939e-c0b72ca460a9.png)  

* 게시물 댓글기능.  
>- 댓글기능 추가를 위한 REPLY테이블 생성 및 세션에서 로그인 한 사용자의 정보를 가져와서 댓글등록시 사용.
  
![image](https://user-images.githubusercontent.com/75213468/121128470-67492b80-c866-11eb-8998-c81a9190b7ef.png)  

* 게시물 파일 업/다운로드 기능.  
>- MultipartFile을 이용한파일 업/다운로드를 구현.  

![image](https://user-images.githubusercontent.com/75213468/121160961-84422680-c887-11eb-983c-a71568b0fd0f.png) ![image](https://user-images.githubusercontent.com/75213468/121161321-d4b98400-c887-11eb-8671-831df00cc9f8.png)  

  


  </details>

2.테이블설계.  
>-Member  
![image](https://user-images.githubusercontent.com/75213468/119369446-25a97400-bcef-11eb-8786-ef3b1d4b4342.png)  
![image](https://user-images.githubusercontent.com/75213468/120108596-d48ef980-c1a0-11eb-903d-8cfa5f55c731.png) (이메일 인증 기능 추가를 위한 authkey와 authstatus 추가)  
Board  
![image](https://user-images.githubusercontent.com/75213468/119369623-5a1d3000-bcef-11eb-8a91-145a554135ee.png)  
REPLY  
![image](https://user-images.githubusercontent.com/75213468/121128791-eb031800-c866-11eb-9564-f07af2a7adec.png) (댓글기능 추가로 인한 REPLY테이블 추가)  
FILE  
![image](https://user-images.githubusercontent.com/75213468/121161457-f7e43380-c887-11eb-9bfd-0954dcad02f2.png) (FILE 업/다운로드를 위한 FILE 테이블 추가)  


  
3.구현하고 싶은 기능 및 결과
  <details>
  <summary>회원가입시 이메일 인증 기능(펼치기)</summary>  
    
>- SMTP를 이용한 메일 발송, 링크 클릭을 통해 DB의 AUTHSTATUS를 UPDATE 해주어서 로그인시 AUTHSTATUS를 확인하여 로그인 가능 여부 판단 후 로그인 가능하게 구현완료.  
![image](https://user-images.githubusercontent.com/75213468/120108462-2edb8a80-c1a0-11eb-9ef8-5d177fa41e5e.png) ![image](https://user-images.githubusercontent.com/75213468/121165289-1dbf0780-c88b-11eb-8082-24af45e44145.png)  
![image](https://user-images.githubusercontent.com/75213468/120108404-f8057480-c19f-11eb-9136-619d974b2f5f.png)
  </details>
 
  다중 파일 업다운로드 
   
  <details>
  <summary>이미지 슬라이더 삽입(펼치기)</summary>  
    
  >- js를 이용한 이미지 슬라이더(자동 및 버튼) 구현
    
  ![image](https://user-images.githubusercontent.com/75213468/121662344-2fe5b380-cae0-11eb-97a6-562b4b7f3e06.png) ![image](https://user-images.githubusercontent.com/75213468/121666622-6cb3a980-cae4-11eb-998d-1a4c6ff3abb4.png)  
  </details>
  
<details>
<summary>기부하기 기능(결제)(펼치기)</summary>
  
* 기부하기 기능  
>- home에서 기부하기 버튼 클릭시 익명으로 기부, 로그인이후 메인페이지에서 기부하기 버튼 클릭시 회원의 id, 기부금액 등이 db에 저장. 아임포트api 사용.  
![image](https://user-images.githubusercontent.com/75213468/123036556-3e10c980-d428-11eb-9ffa-6b7069196bdb.png)
![image](https://user-images.githubusercontent.com/75213468/123036456-1d487400-d428-11eb-99c9-e42e9ed29246.png)  

![image](https://user-images.githubusercontent.com/75213468/123036652-5c76c500-d428-11eb-9c86-992b4c367b2f.png)

</details>

test1

