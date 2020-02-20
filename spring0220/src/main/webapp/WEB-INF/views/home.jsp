<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
</head>
<body>
	<a href="display">jsp 출력</a><br/>
	<a href="param?num=10">Request를 이용한 파라미터 처리</a><br/>
	
	<form action="get" method="get">
		검색어:<input type="text" name="keyword" />
		<input type="submit" value="검색"/>
	</form>
	
	<form action="login" method="post">
		<input type="text" name="id" 
		placeholder="아이디를 입력하세요!" required='required'/><br/>
		<input type="password" name="pw" 
		placeholder="비밀번호를 입력하세요!" required='required'/><br/>
		<input type="submit" value="로그인"/>
	</form>
	
	<a href="article/20">20번글</a><br/>
</body>
</html>








