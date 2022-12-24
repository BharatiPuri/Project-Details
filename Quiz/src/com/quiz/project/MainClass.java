package com.quiz.project;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		StudentRegistration sr = new StudentRegistration();
		StudentLogin sl = new StudentLogin();
		QuizQuestion qq = new QuizQuestion();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Registration Quiz Test ");
		System.out.println("Press 2 for Student login If Registeration is Completed");
		int select = sc.nextInt();
		
		switch(select) {
		case 1 :
			sr.registerUser();
			break;
		case 2 :
			sl.loginUser();
			break;
		}

	}

}
