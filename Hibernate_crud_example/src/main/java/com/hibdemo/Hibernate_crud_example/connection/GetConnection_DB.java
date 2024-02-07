package com.hibdemo.Hibernate_crud_example.connection;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetConnection_DB {
	
	public Session getConnection() {
		Configuration con=new Configuration().configure("Hibernate.cfg.xml");
		SessionFactory sessionFactory=con.buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
		
	}

}
