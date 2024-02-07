package in.paymentapp;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PaymentApp {

	public static void main(String[] args) {
		
		ApplicationContext apc=new ClassPathXmlApplicationContext("in/paymentapp/Spring-Bean.xml");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter ammount");
		double ammount=sc.nextDouble();
		
		while(true)
		{
			System.out.println("--------------------------------------------");
			System.out.println("1.credit card");
			System.out.println("2.upi paymennt");
			System.out.println("3.debit card payment");
			System.out.println("4.cash payment");
			System.out.println("5.EXIT");
			System.out.println("---------------------------------------------");
			System.out.println("enter your choice:==");
			int key=sc.nextInt();
			
			switch (key) {
			case 1: 
			{
				BillCollector bs=apc.getBean("BillCollect4", BillCollector.class);
				bs.billcollect(ammount);
				break;
			}
			case 2: {	
				BillCollector bs=apc.getBean("BillCollect3", BillCollector.class);
				bs.billcollect(ammount);
				break;
			}
			case 3: {	
				BillCollector bs=apc.getBean("BillCollect2", BillCollector.class);
				bs.billcollect(ammount);
				break;
			}
			case 4: {
				BillCollector bs=apc.getBean("BillCollect1", BillCollector.class);
				bs.billcollect(ammount);
				break;
			}
				
			case 5:
			{
				System.exit(0);
				break;
			}
			default:
			{
				throw new IllegalArgumentException("Unexpected value: " + key);
			}
				

				
			}
		}

		
		
		
	}

}