package in.nebulatech.restController;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nebulatech.bindings.Product;

@RestController
public class ProductRestController {

	@GetMapping("/allproduct")
	public ResponseEntity<List<Product>> getAllProduct()
	{
		Product product1 = new Product(101,"mouse","for comp also laps",659.99);
		Product product2 = new Product(102,"keyboard","same as mouse",499.99);
		Product product3 = new Product(103,"charger","mobile charger",99.00);
		Product product4 = new Product(104,"earphones","wireless",399.99);
		Product product5 = new Product(105,"earbuds","blutooth",79.00);
		List<Product> list=Arrays.asList(product1,product2,product3,product4,product5);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
}
