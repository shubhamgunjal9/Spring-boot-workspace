package com.hibdemo.HibernateCrud;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Product {
	@Id
 private Integer productId;
 private String productName;
 private Double ammount;
public Integer getProductId() {
	return productId;
}
public void setProductId(Integer productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public Double getAmmount() {
	return ammount;
}
public void setAmmount(Double ammount) {
	this.ammount = ammount;
}
public Product(Integer productId, String productName, Double ammount) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.ammount = ammount;
}
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Product [productId=" + productId + ", productName=" + productName + ", ammount=" + ammount + "]";
}
 
}
