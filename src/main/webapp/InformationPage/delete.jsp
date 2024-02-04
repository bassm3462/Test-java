<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.MangeStudden.StudentDATA" %>
<%@page import ="com.MangeStudden.StudentInformation" %>
<%
String Id = request.getParameter("id");
StudentInformation s = StudentDATA.getInfoById(Integer.parseInt(Id));
%>

<form action="">
<input value="${s.getId()}">
<input value="${s.getStudentPassword()}">
<input value="${s.getSudentEmail()}">
<input value="${s.getStudentName()}">
</form>
</body>
</html>