<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<%@page import="com.MangeStudden.StudentDATA" %>
<%@page import ="com.MangeStudden.StudentInformation" %>
<%@page import="jakarta.servlet.http.*,jakarta.servlet.*" %>

<%
List<StudentInformation> list =StudentDATA.getAllInformation();
request.setAttribute("list", list);
%>

<table>
<tr>
<td>id</td>
<td>name</td>
<td>email</td>
<td>password</td>

</tr>
<c:forEach var="S" items="${list}">
<tr>
<td>${S.getId}</td>
<td>${S.getStudentName}</td>
<td>${S.getSudentEmail}</td>
<td>${S.getStudentPassword}</td>
<td>
<a href="delete.jsp?id${S.getId}">Delete</a>
<a href="edit.jsp?id${S.getId}">edit</a>
</td>



</tr>
<!--</c:forEach>
</table>
<p> methode tow</p>

<%List<StudentInformation> list2 =StudentDATA.getAllInformation(); %>
<table>
<tr>
<td>id</td>
<td>name</td>
<td>email</td>
<td>password</td> --!>

</tr>
<%for(StudentInformation LIST: list2) { %>
<tr>
<td> <%= LIST.getId() %> </td>
<td><%= LIST.getStudentFName() %></td>
<td><%= LIST.getStudentLName()%>
<td><%= LIST.getSudentEmail() %></td>
<td><%= LIST.getStudentPassword()%></td>
<td>
<a href="delete.jsp?id=<%= LIST.getId() %>">Delete</a> 
<a href="edit.jsp?id=<%= LIST.getId() %>">edit</a>
</td>
<% } %>
</body>
</html>