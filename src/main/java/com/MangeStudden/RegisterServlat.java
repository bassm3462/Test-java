package com.MangeStudden;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterServlat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlat() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		StudentInformation information = new StudentInformation();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if (fname.isEmpty() && email.isEmpty() && password.isEmpty()) {
			request.setAttribute("status", "Please enter the information");
			response.sendRedirect("register.jsp");
		} else {

			information.setStudentFName(fname);
			information.setStudentLName(lname);
			information.setSudentEmail(email);
			information.setStudentPassword(password);
			int num = StudentDATA.save(information);
			if (num > 0) {
				System.out.println("insert inserted successfully ");
				response.sendRedirect("Login.jsp");
			} else {
//	                    out.println("No rows inserted.");
				request.setAttribute("statuse", "falied");
				response.sendRedirect("register.jsp");
			}
		}
	}

}
