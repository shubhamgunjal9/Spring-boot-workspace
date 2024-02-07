package in.nebulatech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.nebulatech.service.ProductService;

@SpringBootApplication
public class Application {

	public static void main(String[] args)throws Exception {
		ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
		ProductService productService=context.getBean(ProductService.class);
		productService.setData();
	}

}
