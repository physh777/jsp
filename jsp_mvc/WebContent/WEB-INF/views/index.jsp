<%@page import="com.test.jsp.vo.UserInfo"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
<div class="container">
	안녕하세요 ${user.name}님, 반갑습니다.<br>
	${user.name}님의 정보는 아래와 같아요~<br>
	<ul>
		<li>ID : ${user.id}</li>
		<li>취미 : ${user.hobby}</li>
		<li>사시는곳 : ${user.address}</li>
		<li>성별 : ${user.trans==1?"남자":"여자"}</li>
		<li>Password : ${user.pwd}</li>
	</ul>
</div> 
</body>
</html>