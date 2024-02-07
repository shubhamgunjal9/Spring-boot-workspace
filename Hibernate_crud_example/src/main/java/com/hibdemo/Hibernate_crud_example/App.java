package com.hibdemo.Hibernate_crud_example;

import java.util.Scanner;

import com.hibdemo.Hibernate_crud_example.entity.Product;
import com.hibdemo.Hibernate_crud_example.service.ProductService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ProductService productService=new ProductService();
    	
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("1.insert");
    	System.out.println("2.get all");
    	System.out.println("3.get by id");
    	System.out.println("4.update");
    	System.out.println("5.delete");
    	System.out.println("6.exit");
    	System.out.println("-----------------------");
    	System.out.println("Enter your choice:");
    	int choice=scanner.nextInt();
    	switch (choice) {
		case 1:
			System.out.println("enter product name:");
			String name=scanner.next();
			System.out.println("enter product price:");
			Double price=scanner.nextDouble();
			Product product=new Product(name, price);
			String response=productService.insertProduct(product);
			System.out.println(response);
			break;

		case 2:
			productService.getAllProducts();
			break;
		case 3:
			productService.getProductById(1);
			break;
		case 4:
			productService.updateProduct();
			break;
		case 5:
			productService.deleteById();
			break;
			
		default:
			break;
		}
    	
    	
    }
}
