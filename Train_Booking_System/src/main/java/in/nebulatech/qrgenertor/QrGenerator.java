package in.nebulatech.qrgenertor;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import in.nebulatech.bindings.Booking;

public class QrGenerator {
	
	public static void generateQRcode(Booking booking) throws WriterException, IOException
	{
		String QRcodepath="C:\\Users\\Shree\\Documents\\workspace-spring-tool-suite-4-4.15.3.RELEASE\\Train_Booking_System\\src\\main\\webapp\\qrcodes\\";
		String QRcodename=QRcodepath+booking.getEmail()+"QRCODE.png";
		//var qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix =new QRCodeWriter().encode("NAME:"+booking.getName()+
				"\nEMIAL:"+booking.getEmail()+"\nCONTACT:"+booking.getContact()+
				"\nCOUNT:"+booking.getCount()+"\nFROM:"+booking.getFromLocation()+
				"\n TO:"+booking.getToLocation()+"\n DATE:"+booking.getCheckInDate()+
				"\n PREFERENCES:"+booking.getTrainPreferences()+"\nCATAGORY:"+
				booking.getPassengerCatagory()
				,BarcodeFormat.QR_CODE,400,400);
		Path path = FileSystems.getDefault().getPath(QRcodename);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG",path);
		System.out.println("qrcode generation successfull");
	}

}
