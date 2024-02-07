package com.springBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String...args)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("Spring-Beans.xml");
		
		Car car1=context.getBean("car", Car.class);
		System.out.println(car1.hashCode());    			//1.
		Car car2=context.getBean("car", Car.class);
		System.out.println(car2.hashCode());				//2.
		
		/* 1. in first approach we are used by default bean scope means singleton bean scope
		 * 2. only one object got created thats why statement 1 and 2 hashcode is same
		 * 3. only one object got created thats why constructor calling is only once*/
		
		
		Motor motor1=context.getBean("motor",Motor.class);
		System.out.println(motor1.hashCode());				//3.
		
		Motor motor2=context.getBean("motor" , Motor.class);
		System.out.println(motor2.hashCode());				//4.
		
		/*1. in second approach we are using prototype bean scope it means whenever we are calling getBean()
		 * method that time a seperate object will be created but in singleton there is only one object will
		 * be created
		 *2. there are two objects created thats why statement 3. and 4. is diffrent
		 *3. two object created thats why constuctor calling was twice */
		
	}

}
