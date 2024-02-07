package in.nebulatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.nebulatech.binding.Product;
import in.nebulatech.repo.ProductRepo;
import in.nebulatech.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductRepo productRepo;

	// private ProductService productService;

	// post single product object and save in database

	@PostMapping(value = "/product", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		System.out.println(product);
		productRepo.save(product);
		System.out.println("product saved successfull");
		return new ResponseEntity<>("saved single employee", HttpStatus.CREATED);
	}

	@GetMapping("/product/{pid}")
	public ResponseEntity<Product> getProductById(@PathVariable("pid") Integer id) {
		Product product = productRepo.findByProductID(id);
		System.out.println(product);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@PutMapping("/product/{pid}")
	public ResponseEntity<Product> updateProductById(@PathVariable("pid") Integer id, @RequestBody Product product1) {
		Product product = productRepo.findByProductID(id);
		product.setProductName(product1.getProductName());
		product.setProductDesc(product1.getProductDesc());
		product.setProductPrice(product1.getProductPrice());
		productRepo.save(product);
		System.out.println("product updated successfull");
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@DeleteMapping("/product/{pid}")
	public ResponseEntity<Product> deleteProductById(@PathVariable("pid") Integer id) {
		Product product = productRepo.findByProductID(id);
		productRepo.deleteById(id);
		System.out.println("product deletion successfull");
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> list = productRepo.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PostMapping(value = "/product/saveall", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<String> saveAllProduct(@RequestBody List<Product> product) {
		for (Product product1 : product) {
			System.out.println(product1);
		}
		productRepo.saveAll(product);
		System.out.println("product saved successfull");
		return new ResponseEntity<>("saved all employee", HttpStatus.CREATED);
	}

}
