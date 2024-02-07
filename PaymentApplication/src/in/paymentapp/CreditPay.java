package in.paymentapp;

public class CreditPay implements Payment
{
	@Override
	public String pay(double ammount) {
		
		return "payment successfull using credit card :-"+ammount;
	}

}
