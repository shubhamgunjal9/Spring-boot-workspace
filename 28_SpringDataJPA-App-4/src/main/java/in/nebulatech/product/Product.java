package in.nebulatech.product;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;


@Data
@Entity
@Table(name="PRODUCT_MASTER" )
public class Product {
	
	@Id
	@Column(name = "PRODUCT_ID")
	private int productID;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "PRODUCT_PRICE")
	private double productPrice;
	
	@Column(name = "INSERTED_DATE",updatable = false)
	@CreationTimestamp
	private LocalDate creatDate;
	
	@UpdateTimestamp
	@Column(name = "UPDATED_DATE",insertable = false)
	private LocalDate updateDate;
	

}
