package com.myapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	private String name;
	private int age;
	private String studentId;
	private List<String> courses;

	public Student(String name, int age, String studentId) {
		super();
		if (validatAge(age) && validateName(name) && validateStudentId(studentId)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<String>(); // Initialization
		}
	}

	private boolean validateStudentId(String studentId) {
		String studentIdRegex = "M-\\d+$"; // or use-> M-[0-9]+$ , [here 'd' means 0-9 digit]
		Pattern studentIdPattern = Pattern.compile(studentIdRegex);
		Matcher studentIdMatcher = studentIdPattern.matcher(studentId);

		if (studentIdMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Id,Enter in given format [M-123]");
		}

		return false;
	}

	public void enrollCourse(String course) {
		if (validateCourseName(course)) {
			if (!courses.contains(course)) {
				courses.add(course);
				System.out.println(name+" enrolled to the " + course + " course Successfully!!\n");

			} else {
				System.err.println("Student is already enrolled to the course " + course);
			}
		}
	}

	public void studentInfo() {
		System.out.println("=================== Student Information ===================");
		System.out.println("Student Name is " + name);
		System.out.println("Student Age is " + age);
		System.out.println("Student Id is " + studentId);
		System.out.println("Student Enrolled to the " + courses +" coures");
	}

	@Override
	public String toString() {
		return "student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

	// handling the Validation

	public boolean validatAge(int age) {
		if (age >= 18 && age <= 35) {
			return true;
		} else {
			System.err.println("Invalid Age,it should be in between 18 to 35");
			return false;
		}
	}

	public boolean validateName(String name) {

		String nameRegex = "^[a-zA-Z\\s]+$"; // regex for name

		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);

		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Name!!, Please enter alphabets only!");
			return false;
		}

	}

	public boolean validateCourseName(String course) {
		if (course.equalsIgnoreCase("Python") || course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DevOps")) {
			return true;
		} else {
			System.err.println(course+" is Invalid Course!!, Please select valid course from the list [Python, Java , DevOps]");
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}
	
	

}
