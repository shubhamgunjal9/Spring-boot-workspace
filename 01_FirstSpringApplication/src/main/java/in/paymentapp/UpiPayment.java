package in.paymentapp;

public class UpiPayment implements Payment
{
	
	public String pay(double ammount) {
		
		return "payment successfull using upi:-"+ammount;
	}

}
