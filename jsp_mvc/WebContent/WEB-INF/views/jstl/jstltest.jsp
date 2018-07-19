<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL TEST</title>
</head>
<body>
<c:set var="numArr" value="<%=new int[]{1,2,3,4,5}%>" scope="request"/>
<% 
RequestDispatcher rd = request.getRequestDispatcher("/views/jstl/jstl2");
rd.forward(request, response);
%>
</body>
</html>