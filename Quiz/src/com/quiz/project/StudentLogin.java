package com.quiz.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class StudentLogin {
	int id;
	String studentId;
	String fname;
	String lname;
	Scanner sc = new Scanner(System.in);

	public void loginUser() {
		QuizQuestion qq = new QuizQuestion();
		System.out.println("Enter Username for login : ");
		String username = sc.next();
		System.out.println("Enter the Password : ");
		String password = sc.next();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizproject", "root", "bharati@123");
		PreparedStatement pstmt = con.prepareStatement("select * from studentregistration");
		ResultSet rs = pstmt.executeQuery();
		boolean flag = false;
		while(rs.next()) {
		    String usernamematch = rs.getString(6);
 			String passwordmatch = rs.getString(7);
			if(username.equals(usernamematch)&&password.equals(passwordmatch)) {
				System.out.println("********************Welcome********************");
				int studentId= rs.getInt(1);
				String FirstName = rs.getString(2);
				String LastName = rs.getString(3);
				qq.Question(studentId,FirstName,LastName);
			}
			else {
				System.out.println("Excess Denied");
			}
		
		}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
