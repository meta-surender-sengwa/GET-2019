package com.metacube.sms.model;

import java.util.ArrayList;

public class AllStudent {
	
	public static  ArrayList<Student> studentList = new ArrayList<Student>();

	public static ArrayList<Student> getStudent() {
	
		ArrayList<Student> studentList = new ArrayList<Student>();
	
		Student s1 = new Student("Surender", "Sengwa", "KL Sengwa", "Surender.Sengwa@metacube.com", "8", "12");
		Student s2 = new Student("Vinod", "Sharma", "RS Sharma", "vinod.sharma@metacube.com", "12", "12");
		Student s3 = new Student("Vinay", "Pancholi", "DK Pancholi", "vinay.pancholi@metacube.com", "1", "1");
		Student s4 = new Student("Bhupendra", "Kumawat", "BK", "Bhupendra.Kumawat@metacube.com", "10", "2");
	
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
	
		return studentList;
	}
}
