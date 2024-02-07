package in.paymentapp;

public class CashPayment implements Payment {

	@Override
	public String pay(double ammount) {
		// TODO Auto-generated method stub
		return "payment given by cash:-"+ammount;
	}
	
}
