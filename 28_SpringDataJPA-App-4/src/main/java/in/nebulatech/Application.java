package in.nebulatech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.nebulatech.product.Product;
import in.nebulatech.repo.ProductRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
		
		ProductRepository productRepository=context.getBean(ProductRepository.class);
		
		Product product =new Product();
		product.setProductID(101);
		product.setProductName("hard disk");
		product.setProductPrice(499.99);
		productRepository.save(product);
	}

}
