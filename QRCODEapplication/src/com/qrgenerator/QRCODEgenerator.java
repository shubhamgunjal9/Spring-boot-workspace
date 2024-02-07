package com.qrgenerator;



import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.pojos.Student;

public class QRCODEgenerator {
/*
	public void generateQR(Student student) 
	{
		try
		{
			File file=new File("D:\\coreQR\\"+student.getStudentId()+student.getStudentName()+"qr.png");
			ByteArrayOutputStream out=QRCode.from("---YOUR DATA---\n"+"student id  :  "
					+student.getStudentId()+"\n student name   :   "
					+ ""+student.getStudentName()+"\n  student address  :  "
					+student .getStudentAddress()+"\n student  contact  :  "
					+student.getStudentContact()).to(ImageType.PNG).stream();
			
			FileOutputStream fos=new FileOutputStream(file);
			fos.write(out.toByteArray());
			fos.close();
			System.out.println("qr code generation  successfull");
			
		}
		catch (Exception e) {
			System.out.println("exception raised ");
			e.printStackTrace();
		}
		
	}*/
	public void generate(Student student) throws Exception
	{
		String QRcodepath="D:\\coreQR\\";
		String QRcodename=QRcodepath+student.getStudentName()+student.getStudentId()+"QRCODE.png";
		
		BitMatrix bitMatrix = new MultiFormatWriter().encode("---YOUR DATA---\n"+"student id  :  "
				+student.getStudentId()+"\n student name   :   "
				+ ""+student.getStudentName()+"\n  student address  :  "
				+student .getStudentAddress()+"\n student  contact  :  "
				+student.getStudentContact()
				,BarcodeFormat.QR_CODE,400,400);
		File path =  new File(QRcodename);
		MatrixToImageWriter.writeToFile(bitMatrix, "PNG",path);
		System.out.println("generation successfull");
	}
	
}
