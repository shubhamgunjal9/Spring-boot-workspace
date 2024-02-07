package in.nebulatech.binding;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Product {
	
	
	@Id 
	private Integer productID;
	
	private String productName;
	
	private Double productPrice;
	
	private String productDesc;
	

}
