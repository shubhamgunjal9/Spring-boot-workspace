package com.main;

import java.util.Scanner;

import com.pojos.Student;
import com.qrgenerator.QRCODEgenerator;
import com.service.StudentService;

public class QRMain {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StudentService studentService=new StudentService();
		QRCODEgenerator qrcodEgenerator=new QRCODEgenerator();
		
		System.out.println("qr code application");
		System.out.println("enter y to continue");
		
		char ch=sc.next().charAt(0);
		if(ch=='y' || ch=='Y')
		{
			System.out.println("insert you data");
			Student student = studentService.setData();
			qrcodEgenerator.generate(student);
		}
		else
		{
			System.exit(0);
		}
		
		
	}

}
