package com.myapp;

public class Main {

	public static void main(String[] args) {
		System.out.println(
				"*************************** Welcome To Student Management System ***************************");

		Student st1;
		st1 = new Student("Kajal", 28, "M-70");

		st1.enrollCourse("Java");
		st1.enrollCourse("DevOps");
		st1.enrollCourse("Python");
		st1.enrollCourse("C++");

		//System.out.println(st1);
		st1.studentInfo();

		Student st2 = new Student("Mahesh", 30, "M-72");
		st2.enrollCourse("Java");
		st2.enrollCourse("Python");
		//System.out.println(st2);
		st2.studentInfo();

		Student st3 = new Student("Javed", 25, "M-485");
		st3.enrollCourse("DevOps");
		//System.out.println(st3);
		st3.studentInfo();

	}

}
