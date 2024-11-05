package com.myapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
	
	private static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println(
				"*************************** Welcome To Student Management System ***************************");
		
		studentList = new ArrayList<Student>();

		Student st1;
		st1 = new Student("Kajal", 28, "M-70");

		st1.enrollCourse("Java");
		
		
		Student st2 = new Student("Mahesh", 30, "M-72");
		
		st2.enrollCourse("Python");
		
		Student st3 = new Student("Yaksh", 35, "M-485");
		st3.enrollCourse("DevOps");
		
		Student st4 = new Student("Aman", 35, "M-100");
		st4.enrollCourse("Java");
		
		studentList.add(st1);
		studentList.add(st2);
		studentList.add(st3);
		studentList.add(st4);
		
		Student result = findStudentById("M-70");
		System.out.println(result);
		
		sortByName();
		
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
