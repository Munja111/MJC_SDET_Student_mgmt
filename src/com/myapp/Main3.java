package com.myapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {
	
	private static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println(
				"*************************** Welcome To The Student Management System ***************************");
		
		studentList = new ArrayList<Student>();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student Name: ");
		String name= scanner.next(); // 	for string data type used next
		System.out.println("You have entered the name "+name);
		
		System.out.println("Enter the student Age: ");
		int age= scanner.nextInt(); // 	for integer data type used nextInt
		System.out.println(name+" is "+age+ " years old");

		
	}
	
	private static void sortByName() {
		Comparator<Student> studentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());
				
				 // above used lambda expression instead of below lines of code
				/*
				Comparator<Student> studentNameComparator = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		
		*/
				
		Collections.sort(studentList,studentNameComparator);
		System.out.println(studentList);
	}

	public static Student findStudentById(String studentId) {
		
		Student result = null;  // Explicit initialization
		try {
		result= studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
		.orElseThrow(()-> new RuntimeException("No Data Found"));
		}
		catch (RuntimeException e) {
			System.err.println("Student with Id "+studentId+" not Found");
		}
		return result;
		
	}
	
	

}
