package com.hibdemo.HibernateCrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetConnection {
	
	public Session getConnection() {
		Configuration cfg=new Configuration().configure("Hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
       // System.out.println(sf);
        Session s=sf.openSession();
        return s;
	}

}
