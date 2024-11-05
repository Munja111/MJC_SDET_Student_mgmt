package com.myapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main4 {

	private static List<Student> studentList;
	private static Scanner scanner;

	public static void main(String[] args) {
		System.out.println(
				"*************************** Welcome To The Student Management System ***************************");

		studentList = new ArrayList<Student>();

		scanner = new Scanner(System.in);

		while (true) {
			System.out.println("******************** Welcome ********************");
			System.out.println("Select an option..... ");
			System.out.println("1. Register a student ");
			System.out.println("2. Find student with studentId");
			System.out.println("3. List all student information");
			System.out.println("4. List all student in sorted order");
			System.out.println("5. Exit");

			int option = scanner.nextInt();

			switch (option) {
			case 1:
				enrollStudent(scanner);
				break;

			case 2:
				findStudentById(scanner);
				break;

			case 3:
				printAllStudentData(scanner);
				break;

			case 4:
				sortByName();
				break;

			case 5:
				exit();
				break;

			default:
				System.out.println("Invalid Option Selected!... Enter beween  1 to 5");

			}
		}

	}

	private static void exit() {

		System.out.println("Good Bye!!!!");

		System.exit(0);

	}

	private static void printAllStudentData(Scanner scanner2) {
		
		if(studentList.size()>0) {
		
		System.out.println("**************** Print All Student Data ****************");
		for (Student student : studentList) {
			student.studentInfo();
		}
		System.out.println("**************** * ****************");
	}else {
		System.err.println("Student list is Empty!! No record found");
	}
		

	}

	private static void findStudentById(Scanner scanner2) {
		
		Student studentFound = null; // Explicit initialization
		System.out.println("Enter the student Id");
		String studentId= scanner2.next();
		
		try {
			studentFound = studentList.stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No Data Found"));
		} catch (RuntimeException e) {
			System.err.println("Student with Id " + studentId + " not Found");
		}
		
		studentFound.studentInfo();

	}

	private static void enrollStudent(Scanner scanner2) {
		System.out.println("Enter the student name");
		String studentName = scanner2.next();

		System.out.println("Enter the student age");
		int studentAge = scanner2.nextInt();

		System.out.println("Enter the student Id");
		String studentId = scanner2.next();

		Student newStudent = new Student(studentName, studentAge, studentId);
		studentList.add(newStudent);

		while (true) {
			System.out.println("Enter the course name to be enrolled!!....Type Done for exit");
			String courseName = scanner2.next();
			if (courseName.equalsIgnoreCase("done")) {
				break;
			}
			newStudent.enrollCourse(courseName);
		}
		newStudent.studentInfo();
	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

		// above used lambda expression instead of below lines of code
		/*
		 * Comparator<Student> studentNameComparator = new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student o1, Student o2) { return
		 * o1.getName().compareTo(o2.getName()); } };
		 * 
		 */

		Collections.sort(studentList, studentNameComparator);
		// System.out.println(studentList);   // It will print data in one line
		
		 	printAllStudentData(scanner);
	}

	

	public static Student findStudentById(String studentId) {

		Student result = null; // Explicit initialization
		try {
			result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No Data Found"));
		} catch (RuntimeException e) {
			System.err.println("Student with Id " + studentId + " not Found");
		}
		return result;

	}

}
