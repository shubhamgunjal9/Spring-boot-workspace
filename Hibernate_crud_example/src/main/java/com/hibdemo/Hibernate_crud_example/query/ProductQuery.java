package com.hibdemo.Hibernate_crud_example.query;

import com.hibdemo.Hibernate_crud_example.entity.Product;

public class ProductQuery {
	
	public String delete(Integer pId) {
		return "delete from Product where id="+pId;
	}
	public String update(Integer pId, Product product) {
		return "UPDATE Product SET name = "+product.getProductName()+", price = "+product.getProductPrice()+" WHERE id="+pId;
	}

}
