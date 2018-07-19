<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String ip = request.getRemoteAddr();
String conType = request.getContentType();
String method = request.getMethod();
String uri = request.getRequestURI();
String root = request.getContextPath();
int port = request.getServerPort();
%>
아이피 : <%=ip%><br>
콘텐트타입 : <%=conType%><br>
요청메소드 : <%=method%><br>
요청URI : <%=uri%><br>
루트패스 : <%=root%><br>
포트 : <%=port%><br>
</body>
</html>