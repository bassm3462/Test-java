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
 <jsp:useBean id = "s" class = "com.MangeStudden.StudentInformation" /> 
<jsp:setProperty name="s" property="*" />  
<%
int num=StudentDATA.Update(s);
if(num>0){
	response.sendRedirect("StudentAdded.js");
	
}else{
	response.sendRedirect("StudentFalid.js");
}
%>
<form action="">
<input type="text" name="name">name
<input type="text" name="email">email
<input type="text" name="password">password
<input type="button" value="edit">
</form>
</body>
</html>