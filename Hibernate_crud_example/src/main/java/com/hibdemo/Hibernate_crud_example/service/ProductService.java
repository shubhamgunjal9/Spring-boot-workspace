package com.hibdemo.Hibernate_crud_example.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibdemo.Hibernate_crud_example.connection.GetConnection_DB;
import com.hibdemo.Hibernate_crud_example.entity.Product;
import com.hibdemo.Hibernate_crud_example.query.ProductQuery;

public class ProductService {
	
	private GetConnection_DB connectionDb=new GetConnection_DB();
	Scanner sc=new Scanner(System.in);
	public String insertProduct(Product product) {
		Session session = connectionDb.getConnection();
		Transaction tx = session.beginTransaction();
		session.save(product);
		tx.commit();
		session.close();
		return "inserted succesfully";
	}
	public void getAllProducts() {
		Session session = connectionDb.getConnection();
		Transaction tx = session.beginTransaction();
		Query query=session.createQuery("from Product");
		List<Product> list=query.getResultList();
		for(Product product: list) {
			System.out.println("product id:"+product.getProductId()+
					"\nproduct name:"+product.getProductName()+
					"\nproduct price:"+product.getProductPrice());
		}
		tx.commit();
		session.close();
	}
	public void getProductById(Integer pId) {
		Session session = connectionDb.getConnection();
		Transaction tx = session.beginTransaction();
		Product product=session.get(Product.class, pId);
		System.out.println(product);
		tx.commit();
		session.close();
		
	}
	public void updateProduct() {
		System.out.println("enter product id:");
		Integer pId=sc.nextInt();
		new ProductService().getProductById(pId);
		System.out.println("this is your previous product");
		System.out.println("eneter new product name:");
		String name=sc.next();
		System.out.println("enter new product price:");
		Double price=sc.nextDouble();
		Product product=new Product(name,price);
		Session session = connectionDb.getConnection();
		Transaction tx = session.beginTransaction();
		Query query=session.createQuery(new ProductQuery().update(pId, product));
		int i=query.executeUpdate();
		if(i>0) {
			System.out.println("updation success");
		} else {
			System.out.println("failed");
		}
		tx.commit();
		session.close();
	}

	public void deleteById() {
		System.out.println("enter product id:");
		Integer i=sc.nextInt();
		Session session = connectionDb.getConnection();
		Transaction tx = session.beginTransaction();
		Query query=session.createQuery(new ProductQuery().delete(i));
		int row=query.executeUpdate();
		if(row>0)
			System.out.println("success");
		else
			System.out.println("failed");
		tx.commit();
		session.close();
	}
}
