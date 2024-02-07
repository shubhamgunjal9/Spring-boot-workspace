package in.nebulatech.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nebulatech.binding.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	public Product findByProductID(Integer productID);

}
