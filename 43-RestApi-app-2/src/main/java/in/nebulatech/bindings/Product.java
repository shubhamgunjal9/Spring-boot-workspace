package in.nebulatech.bindings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	private Integer productId;
	
	private String productName;
	
	private String productDesc;
	
	private Double productPrice;
	
	

}
