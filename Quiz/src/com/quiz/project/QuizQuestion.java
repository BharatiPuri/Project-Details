package com.quiz.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
    public class QuizQuestion {
     Scanner sc = new Scanner(System.in);
    
	public void Question( int studentId, String FirstName, String LastName) {
		
		int TotalMarks = 10;
		int CorrectAns=0;
		int WrongAns=0;
		int count=0;
	    int id = studentId ;
	    String fname = FirstName;
	    String lname = LastName;
	    String grade = null;
	    
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Read the instruction carefully and type next to proceed");
	  String Inst = sc.next();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizproject","root","bharati@123");
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM quiz Order by RAND();");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
			  System.out.println("Q1-"+rs.getInt(1));	
			  System.out.println(""+rs.getString(2));
			  System.out.println("Option="+rs.getString(3));
			  System.out.println("Option="+rs.getString(4));
			  System.out.println("Option="+rs.getString(5));
			  System.out.println("Option="+rs.getString(6));
			  
			  String Answer = rs.getString(7);
			  System.out.println("Enter the answer");
			  String UserAns = sc.next();
			  if(UserAns.equals(Answer)) {
				  System.out.println("Your Answer is Correct");
				  CorrectAns++;
			  }
			  else {
				  System.out.println("Your Answer is Wrong");
			      WrongAns++;
			      System.out.println("-------------------------------------------------------------------");
			  }
			  }
			System.out.println("Total Marks = "+CorrectAns);
			System.out.println("Wrong = "+WrongAns);
			   if(CorrectAns>=8&&CorrectAns<=10) {
				   System.out.println("Grade = 'A'(Distinction)");
				   grade="A";
			   }
			   else if(CorrectAns>=6&&CorrectAns<=8) {
				   System.out.println("Grade = 'B'(Average)");
				   grade="B";
			   }
			   else if(CorrectAns==5) {
				   System.out.println("Grade = 'C'(Good)");
				   grade="C";
			   }
			   else if(CorrectAns<5) {
				   System.out.println("Grade = 'D'(Fail)");
				   grade="D";
			   }
			   PreparedStatement pstmt1 = con.prepareStatement("insert into studentmarks(StudentId,FirstName, LastName,TotalMarks,Grade)Values(?,?,?,?,?)");
		       pstmt1.setInt(1, id);
		       pstmt1.setString(2, fname);
		       pstmt1.setString(3,lname);
		       pstmt1.setInt(4, CorrectAns);
		       pstmt1.setString(5,grade);
		       pstmt1.executeUpdate();
		       
		       System.out.println("Data Inserted Successfully");
			   pstmt1.close();
			con.close();
			pstmt.close();
			rs.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
