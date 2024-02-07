package com.hibdemo.HibernateCrud;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	CrudUtil crudUtil=new CrudUtil();
        System.out.println( "Hello World!" );
      //  Product product=new Product(101, "choclates", 20.00); 
       // crudUtil.deleteById(101);
        crudUtil.get();
    }
}
