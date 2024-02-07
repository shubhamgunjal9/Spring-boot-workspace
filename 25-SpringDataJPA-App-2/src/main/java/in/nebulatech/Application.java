package in.nebulatech;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.nebulatech.entity.User;
import in.nebulatech.repository.UserRepository;





@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		
		
	/*	LocalDate time1 = LocalDate.of(1994,9,25);
		LocalDate time2 = LocalDate.now();
		long years = ChronoUnit.YEARS.between(time1, time2);
		User user1= new User();
		user1.setUserName("kishor");
		user1.setUserAge(years);
		user1.setUserLocation("india");
		user1.setUserDOB(time1);
		user1.setUserGender("male");
		
		//userRepository.save(user1);
		
		LocalDate time3 = LocalDate.of(2004,7,13);
		LocalDate time4 = LocalDate.now();
		long years1 = ChronoUnit.YEARS.between(time3, time4);
		User user2= new User();
		user2.setUserName("shubham");
		user2.setUserAge(years1);
		user2.setUserLocation("india");
		user2.setUserDOB(time3);
		user2.setUserGender("male");
		
		LocalDate time5 = LocalDate.of(2006,11,01);
		LocalDate time6 = LocalDate.now();
		long years3 = ChronoUnit.YEARS.between(time5, time6);
		User user3= new User();
		user3.setUserName("siddhartha");
		user3.setUserAge(years3);
		user3.setUserLocation("india");
		user3.setUserDOB(time5);
		user3.setUserGender("male");
		
		userRepository.saveAll(Arrays.asList(user1,user2,user3));
		*/
		
		/*Optional<User> findbyId=userRepository.findById(7);
		if(findbyId.isPresent()) {
			System.out.println(findbyId);
		} else { System.out.println("not present in table");} */
		
		
		
		/* Iterable<User> findall=userRepository.findAll();
		for (User user : findall) {
			System.out.println(user);
		} */
		
	/*	Iterable<User> findAllByid=userRepository.findAllById(Arrays.asList(7,8,9,10));
		findAllByid.forEach(User->{System.out.println(User);});
		*/
		
	/*	long count= userRepository.count();
		System.out.println("present records in table::"+count);
	*/
		
	/*	boolean existsbyID=userRepository.existsById(20);
		System.out.println("20 is exists::"+existsbyID);	*/
		
		/*userRepository.deleteById(7);*/
		
		/*userRepository.deleteAllById(Arrays.asList(8,9));*/
		
		List<User> findbyuserLocation=userRepository.findByUserLocation
				("india");
		findbyuserLocation.forEach(user->{System.out.println(user);});
			
		
	}

}
