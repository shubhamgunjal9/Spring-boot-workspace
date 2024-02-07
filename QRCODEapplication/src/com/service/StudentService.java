package com.service;

import java.util.Scanner;

import com.pojos.Student;

public class StudentService {
	
	public Student setData()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("::::data insertion::::");
		Student student=new Student();
		System.out.println("enter student id");
		int id= sc.nextInt();
		student.setStudentId(id);
		System.out.println("enter student name");
		String name = sc.next();
		student.setStudentName(name);
		System.out.println("enter student Address");
		String add=sc.next();
		student.setStudentAddress(add);
		System.out.println("enter student Contact");
		long contact=sc.nextLong();
		student.setStudentContact(contact);
		
		return student;	
	}
	
	

}
