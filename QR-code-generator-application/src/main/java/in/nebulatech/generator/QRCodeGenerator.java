package in.nebulatech.generator;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


import in.nebulatech.entity.Employee;
import lombok.experimental.var;

public class QRCodeGenerator {
	
	public static void generateQRcode(Employee employee) throws WriterException, IOException
	{
		String QRcodepath="D:\\QRcode\\";
		String QRcodename=QRcodepath+employee.getEmplName()+employee.getEmplId()+"QRCODE.png";
		@SuppressWarnings("deprecation")
		var qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode("ID:"+employee.getEmplId()+
				"\nNAME:"+employee.getEmplName()+"\nLOCATION:"+employee.getEmplLocation()+
				"\nSALARY:"+employee.getEmplSalary()+"\nCONTACT:"+employee.getEmplContact()+"\n"
				,BarcodeFormat.QR_CODE,400,400);
		Path path = FileSystems.getDefault().getPath(QRcodename);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG",path);
	}

}
