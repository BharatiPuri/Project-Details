package com.quiz.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentRegistration {
      Scanner sc = new Scanner(System.in);
      
	public void registerUser() {
		System.out.println("Enter the First Name : ");
		String fName = sc.next();
		System.out.println("Enter the Last Name : ");
		String lName = sc.next();
		System.out.println("Enter the Mobile Number : ");
		long mNumber = sc.nextLong();
		System.out.println("Enter the Email Id : ");
		String email = sc.next();
		System.out.println("Enter the UserName : ");
		String uName = sc.next();
		System.out.println("Enter the Password : ");
		String pWard = sc.next();
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizproject","root","bharati@123");
		PreparedStatement pstmt = con.prepareStatement("insert into studentregistration(FirstName,LastName,MobileNo,EmailId, Username,Password)Values(?,?,?,?,?,?)");
		pstmt.setString(1, fName);
		pstmt.setString(2, lName);
		pstmt.setLong(3,mNumber);
		if(mNumber<10) {
		  System.out.println("Invalid Mobile Number");
		}
		pstmt.setString(4, email);
		pstmt.setString(5, uName);
		pstmt.setString(6, pWard);
		
		pstmt.executeUpdate();
		System.out.println("Registration Done");
		
		con.close();
		pstmt.close();
		
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
