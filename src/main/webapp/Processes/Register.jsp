<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Process</title>
</head>
<body>
<%@page import="com.MangeStudden.StudentDATA" %>
<jsp:useBean id="s" class="com.MangeStudden.StudentInformation" />
<jsp:setProperty name="s" property="*" />

<%
System.out.println(s);
String studentFName = request.getParameter("Fname");
String studentLName = request.getParameter("Lname");
String studentEmail = request.getParameter("email");
String studentPassword = request.getParameter("password");
if(studentFName.isEmpty()&&studentEmail.isEmpty()){
	String errorMessage = "pleas entar all data";
    request.setAttribute("error", errorMessage);
    // Forward the request to the register.jsp page with the error attribute
    request.getRequestDispatcher("../register.jsp").include(request, response);
}
s.setStudentFName(studentFName);
s.setStudentLName(studentLName);
s.setSudentEmail(studentEmail);
s.setStudentPassword(studentPassword);
int num = StudentDATA.save(s);
if (num > 0) {
    response.sendRedirect("../InformationPage/StudentAdded.jsp");
} else {
    String errorMessage = "Please correct data";
    request.setAttribute("error", errorMessage);
    // Forward the request to the register.jsp page with the error attribute
    request.getRequestDispatcher("../register.jsp").forward(request, response);
}
%>

</body>
</html>