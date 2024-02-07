package in.nebulatech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import in.nebulatech.binding.Product;
import in.nebulatech.repo.ProductRepo;

@Component
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	public void saveProduct(Product product)
	{
	}
	

}
