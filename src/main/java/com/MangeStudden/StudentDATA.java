package com.MangeStudden;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class StudentDATA {
	private static final String JDBC_URL = "jdbc:mysql://Localhost:3306/logiandregisterjava";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			System.out.println("conect to database");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("invalid conection");
		}
		return connection;
	}
	public static int save(StudentInformation Info) {
		int status = 0;
		try {
			Connection conn = getConnection();
			PreparedStatement per = conn.prepareStatement("INSERT INTO register (Fname, Lname,email,password) VALUES (?, ?, ?,?)");
			per.setString(1, Info.getStudentFName());
			per.setString(2, Info.getStudentLName());
			per.setString(3, Info.getSudentEmail());
			per.setString(4, Info.getStudentPassword());
			System.out.println(Info);
			status = per.executeUpdate();
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static int Login(String email, String password) {
	    System.out.println(email + password);
	    try {
	        Connection conn = getConnection();
	        PreparedStatement per = conn.prepareStatement("SELECT * FROM register WHERE email=? AND password=?");

	        per.setString(1, email);
	        per.setString(2, password);
	        ResultSet rs = per.executeQuery();

	        if (rs.next()) {
	            StudentInformation user = new StudentInformation();
	            user.setSudentEmail(email);
	            System.out.println("valid login");
	            return 1; 
	        } else {
	            System.out.println("Invalid login");
	        }

	    } catch (Exception e) {
	        e.printStackTrace(); 
	    }
	    return 0;
	}
	public static int Update(StudentInformation Info) {
		int status = 0;
		try {
			Connection conn = getConnection();
			PreparedStatement per = conn.prepareStatement("UPDATE register set name=?,email=?,password=?,Where id=?");
			per.setString(1, Info.getStudentFName());

			per.setString(2, Info.getSudentEmail());
			per.setString(3, Info.getStudentPassword());
			per.setInt(4, Info.getId());
			status = per.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int Delete(StudentInformation Info) {
		int status = 0;
		try {
			Connection conn = getConnection();
			PreparedStatement per = conn.prepareStatement("Delete from register where id=?");
			per.setInt(4, Info.getId());
			status = per.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static List<StudentInformation> getAllInformation() {
		List<StudentInformation> list = new ArrayList<StudentInformation>();

		try {
			Connection conn = getConnection();
			PreparedStatement per = conn.prepareStatement("SELECT * FROM register");
			ResultSet rs = per.executeQuery();
			while (rs.next()) {
				StudentInformation student = new StudentInformation();
				student.setId(rs.getInt("id"));
				student.setStudentFName(rs.getString("name"));
				student.setSudentEmail(rs.getString("email"));
				student.setStudentPassword(rs.getString("password"));
				list.add(student);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static StudentInformation getInfoById(int Id) {
		StudentInformation Student = null;
		try {
			Connection conn = getConnection();
			PreparedStatement per = conn.prepareStatement("SELECT * FROM register Where id=?");
			per.setInt(1, Id);
			ResultSet rs = per.executeQuery();
			while (rs.next()) {
				Student = new StudentInformation();
				Student.setId(rs.getInt("id"));
				Student.setStudentFName(rs.getString("Fname"));
				Student.setSudentEmail(rs.getString("email"));
				Student.setStudentPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return Student;
	}
}
