package in.autowiring;

public class Car {
	private DesielEngine desielEngine;
	
	public void setDesielEngine(DesielEngine desielEngine)
	{
		this.desielEngine = desielEngine;
	}
	/*public Car(DesielEngine desielEngine)
	{
		this.desielEngine=desielEngine;
	}*/
	public Car()
	{
		System.out.println("Car::constructor");
	}
	public void drive() {
		int start=desielEngine.isActive();
		if(start>=1)
		{
			System.out.println("engine started successfull");
		}else {
			System.out.println("engine failed");
		}
	}

}
