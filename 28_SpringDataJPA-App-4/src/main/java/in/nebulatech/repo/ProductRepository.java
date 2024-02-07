package in.nebulatech.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nebulatech.product.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
