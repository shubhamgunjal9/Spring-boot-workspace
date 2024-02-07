package com.hibdemo.HibernateCrud;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CrudUtil {
	private GetConnection connection=new GetConnection();
	public void insert(Product product) {
		Session session=connection.getConnection();
		Transaction transaction=session.beginTransaction();
		session.save(product);
		transaction.commit();
	}
	public void deleteById(int id) {
		Session session=connection.getConnection();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("DELETE FROM Product WHERE productId="+id);
		int row=query.executeUpdate();
		if(row>0) {
			System.out.println("deleted");
		} else {
			System.out.println("usnsuccessfull");
		}
		transaction.commit();
		
	}
	public void get() {
		Session session=connection.getConnection();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from Product",Product.class);
		List<Product> list=query.getResultList();
	//	query.executeUpdate();
		for(Product product: list) {
			System.out.println("id:"+product.getProductId());
			System.out.println("name:"+product.getProductName());
			System.out.println("ammount:"+product.getAmmount());
		}
		transaction.commit();
	}

}
