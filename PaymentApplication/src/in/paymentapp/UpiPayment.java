package in.paymentapp;

public class UpiPayment implements Payment
{
	
	@Override
	public String pay(double ammount) {
		
		return "payment successfull using upi:-"+ammount;
	}

}
