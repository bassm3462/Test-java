package com.MangeStudden;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlat extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    StudentInformation Info = new StudentInformation();
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    Info.setSudentEmail(email);
	    Info.setStudentPassword(password);
	    
	    try (Connection connection = StudentDATA.getConnection()) {
	        String query = "SELECT * FROM register WHERE email = ? AND password = ?";
	        
	        try (PreparedStatement pst = connection.prepareStatement(query)) {
	            pst.setString(1,Info.getSudentEmail()); 
	            pst.setString(2, Info.getStudentPassword());
	            try (ResultSet rs = pst.executeQuery()) {
	                if (rs.next()) {
	                    HttpSession session = request.getSession();
	                    session.setAttribute("email", email);
	                    response.sendRedirect("index.jsp");
	                } else {
	                    request.setAttribute("status", "Invalid login, please check the information");
	                    RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
	                    dispatcher.forward(request, response);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Handle the exception as needed, log or show an error page
	    }
	}


}
