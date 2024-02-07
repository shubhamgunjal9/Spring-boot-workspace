package in.paymentapp;

import java.lang.invoke.VolatileCallSite;
import java.util.Scanner;

public class PaymentApp {

	public static void main(String[] args) {
		
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
				BillCollector bl=new BillCollector(new CreditPay());
				bl.billcollect(ammount);
				break;
			}
			case 2: {	
				BillCollector bl=new BillCollector(new UpiPayment());
				bl.billcollect(ammount);
				break;
			}
			case 3: {	
				BillCollector bl=new BillCollector(new DebitcardPayment());
				bl.billcollect(ammount);
				break;
			}
			case 4: {
				BillCollector bl=new BillCollector(new CashPayment());
				bl.billcollect(ammount);
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
