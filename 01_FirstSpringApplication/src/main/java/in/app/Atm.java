package in.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
public class Atm{
	static double balance;
	
	public static void main(String []args)throws Exception
	{
		SubAtm [] subAtm=new SubAtm[50];
		int i=0;
		double withdraw,deposit;
		Scanner sc=new Scanner(System.in);
		while(true){
			System.out.println("Automatic Teller Machine");
			System.out.println("Choose 1 for deposit:");
			System.out.println("choose 2 for withdraw");
			System.out.println("choose 3 for check balance:");
			System.out.println("choose 4 for check bank statment");
			System.out.println("choose 5 for EXIT:");
			System.out.println("choose the operation you want to perform");
			
			int choice=sc.nextInt();
			switch(choice){
				case 1:
					System.out.println("enter your money to be deposited:");
					deposit=sc.nextDouble();
					balance=balance+deposit;
					System.out.println("your money has been succesfully deposited");
					System.out.println("");
					SubAtm s=new SubAtm();
					s.setOperation("deposite");
					s.setAmmount(deposit);
					s.setCurrentBal(balance);
					subAtm[i++]=s;
					//i=1
					
					
					break;
				
				
				case 2:
					System.out.println("Enter money to be withdraw:");
					withdraw=sc.nextDouble();
					
					
					
					
					if(balance >= withdraw)
					{
						balance=balance-withdraw;
						
						System.out.println("please collect your money");
						
						
					}
					else
					{
						System.out.println("insufficient balance");
					}
					System.out.println("");
					SubAtm s2=new SubAtm();
					s2.setOperation("withdraw");
					s2.setAmmount(withdraw);
					s2.setCurrentBal(balance);
					subAtm[i++]=s2;
					//i=2
					break;
					

				
				
				case 3:
				System.out.println("balance:"+balance);
				System.out.println("");
				break;
				
				case 4:
					System.out.println("*___________bank statement__________*");
					for(int i1=0;i1<i;i1++)
					{
						SubAtm sub2=subAtm[i1];
						System.out.println("opration="+sub2.getOperation()+"ammount="+sub2.getAmmount()+"current balance="+sub2.getCurrentBal());
					}
					System.out.println("current balance:"+balance);
					System.out.println("\t");
					break;
				
				case 5:
				System.exit(0);
				break;
				
				
				default:
				System.out.println("enter a valid key");
			}
		}   
	       
	}	
}