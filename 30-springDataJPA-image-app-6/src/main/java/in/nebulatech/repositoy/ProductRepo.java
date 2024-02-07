package in.nebulatech.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nebulatech.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
