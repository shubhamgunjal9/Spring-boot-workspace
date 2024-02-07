package in.paymentapp;

public class BillCollector {
	
	private Payment payment;
	public void setPayment(Payment payment)
	{
		this.payment=payment;
	}
	
	public BillCollector(){	}

	public BillCollector(Payment payment)
	{
		this.payment=payment;
	}

	public void billcollect(double ammount)
	{
		
		String status=payment.pay(ammount);
		System.out.println(status);
	}
}
