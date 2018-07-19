<%@page import="com.test.jsp.vo.UserInfo"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>리퀘스트 영역유저리스트</h3>

<c:forEach var="user" items="${userList}">
	이름 : ${user.name}, 아이디 : ${user.id}, 취미 : ${user.hobby}<br>
</c:forEach>
<h3>세션 영역유저리스트</h3>
<c:forEach var="user" items="${sessionUserList}">
	이름 : ${user.name}, 아이디 : ${user.id}, 취미 : ${user.hobby}<br>
</c:forEach>
</body>
</html>