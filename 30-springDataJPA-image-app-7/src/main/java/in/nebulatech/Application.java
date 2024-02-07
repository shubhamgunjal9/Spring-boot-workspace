package in.nebulatech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.nebulatech.service.AccountService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
		AccountService service=context.getBean(AccountService.class);
		service.setAccountData();
		service.getDataUsingPk();
		context.close();
	}

}
