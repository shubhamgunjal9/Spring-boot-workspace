package com.message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class SendSMS {


	///send sms on mobile
	public void sendSMS(String cContact,String sms) throws IOException
	{
		System.out.println("inside msg ");
	try
	{ 
	sms=sms.replace(" ", "%20");
	System.out.println("in send sms"+cContact);
	URL url2=new URL("http://173.45.76.227/send.aspx?"
	+"username=autodoctor"  
	+"&pass=autodoctor123"
	+"&route=trans1" 
	+"&senderid=AUTODR"
	+"&numbers="+cContact
	+"&message="+sms+"%20%20Regards%20%20HomeRent");
	BufferedReader reader2 = new BufferedReader(new InputStreamReader(url2.openStream()));
	StringBuffer buffer1 = new StringBuffer();
	System.out.println(url2);    
	    int read1;
	    char[] chars1 = new char[1024];
	    while ((read1 = reader2.read(chars1)) != -1)
	        buffer1.append(chars1, 0, read1);
	    String responce=new String(buffer1);
	System.out.println("mobile sms status      "+responce);
	}
	catch(Exception e)
	{
	System.out.println("sms meth exe : "+e);
	}
	}

}
