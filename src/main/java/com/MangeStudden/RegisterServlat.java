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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentInformation information = new StudentInformation();
		 try {
			 if (request.getParameter("name").isEmpty() && 
					    request.getParameter("email").isEmpty() && 
					    request.getParameter("pass").isEmpty()) {    
					    request.setAttribute("status", "Please enter the information");
					    response.sendRedirect("register.jsp");
					}else {
	           information.setStudentName(request.getParameter("name"));
	            information.setSudentEmail(request.getParameter("email"));
	             information.setStudentPassword(request.getParameter("pass"));
	            try(Connection connection =StudentDATA.getConnection()){
	            	  String insertQuery = "INSERT INTO register (name, email, password) VALUES (?, ?, ?)";
	            	  try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
	  	                // Set the values for the parameters in the query
	  	                preparedStatement.setString(1,information.getStudentName());
	  	                preparedStatement.setString(2, information.getSudentEmail());
	  	                preparedStatement.setString(3, information.getStudentPassword());
	  	              int rowsAffected = preparedStatement.executeUpdate();
	  	            if (rowsAffected > 0) {
	  	            	System.out.println("insert inserted successfully ");
	                	  response.sendRedirect("Login.jsp");
	                    
	                } else {
//	                    out.println("No rows inserted.");
	                    
	                    request.setAttribute("statuse", "falied");
	                    response.sendRedirect("register.jsp");
	                }
	            }
	            }    }
		 
	}catch (SQLException e) {
		System.out.println("Invalid input for 'namu'. Please provide a valid integer.");
   }
	}

}
