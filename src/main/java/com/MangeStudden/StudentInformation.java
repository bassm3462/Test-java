package com.MangeStudden;

public class StudentInformation {

	private String StudentFName,StudentLName,SudentEmail,StudentPassword,StudentGender;
	private int Id;
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getStudentFName() {
		return StudentFName;
	}

	public void setStudentFName(String studentName) {
		StudentFName = studentName;
	}

	public String getStudentLName() {
		return StudentLName;
	}

	public void setStudentLName(String studentLName) {
		StudentLName = studentLName;
	}

	public String getSudentEmail() {
		return SudentEmail;
	}

	public void setSudentEmail(String sudentEmail) {
		
		SudentEmail = sudentEmail;
	}

	public String getStudentPassword() {
		return StudentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		StudentPassword = studentPassword;
	}

	public String getStudentGender() {
		return StudentGender;
	}

	public void setStudentGender(String studentGender) {
		StudentGender = studentGender;
	}
}
