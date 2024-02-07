package in.nebulatech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.nebulatech.repository.UserRepository;
import in.nebulatech.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context =SpringApplication.run(Application.class, args);
		
		UserRepository userRepository=context.getBean(UserRepository.class);
		
		UserService userService = context.getBean(UserService.class);
		
		userRepository.saveAll(userService.saveUser());
		//userRepository.deleteById(4);
	}

}
