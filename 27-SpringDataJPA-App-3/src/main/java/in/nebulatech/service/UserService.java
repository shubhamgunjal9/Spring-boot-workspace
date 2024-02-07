package in.nebulatech.service;


import java.time.LocalDateTime;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import in.nebulatech.entity.User;

@Service
public class UserService {
	
	public List<User> saveUser()
	{
		
		
		LocalDateTime dob1= LocalDateTime.of(2004, 7, 13, 5, 40);
		LocalDateTime login1= LocalDateTime.now();
		long age1=ChronoUnit.YEARS.between(dob1, login1);
		
		
		User user1= new User();
		user1.setUserName("shubham");
		user1.setUserDOB(dob1);
		user1.setLogin(login1);
		user1.setUserAge(age1);
		user1.setGender("male");
		user1.setLocation("india");
		user1.setLogin(login1);
		user1.setPassword("shubham123");
		
		LocalDateTime dob2= LocalDateTime.of(2006, 12, 1, 6, 40);
		long age2=ChronoUnit.YEARS.between(dob2, login1);
		User user2=new User(5,"siddharta","siddhartha123","male",age2,dob2,login1,"india");
		
		LocalDateTime dob3= LocalDateTime.of(2006, 11, 04, 3, 30);
		long age3=ChronoUnit.YEARS.between(dob3, login1);
		User user3=new User(6,"aditya","aditya098","male",age3,dob3,login1,"india");
		
		LocalDateTime dob4= LocalDateTime.of(2007, 2, 20, 7, 4);
		long age4=ChronoUnit.YEARS.between(dob4, login1);
		User user4=new User(7,"chaitanya","chaitanya345","male",age4,dob4,login1,"india");
		
		LocalDateTime dob5= LocalDateTime.of(2005, 4, 14, 8, 4);
		long age5=ChronoUnit.YEARS.between(dob5, login1);
		User user5=new User(8,"shruti","shruti987","fe-male",age5,dob5,login1,"india");
		
	
		return Arrays.asList(user1,user2,user3,user4,user5);
	}

}
