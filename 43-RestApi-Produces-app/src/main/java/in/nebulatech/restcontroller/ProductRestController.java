package in.nebulatech.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nebulatech.bindings.Product;

@RestController
public class ProductRestController {
	
	@GetMapping(value = "/product",
			produces= {"application/xml","application/json"}
			)
	public ResponseEntity<Product> getProductDetails()
	{
		Product productObj = new Product(101,"laptop",69999.99);
		
		return new ResponseEntity<>(productObj,HttpStatus.OK);
		
		
		
	}

}
