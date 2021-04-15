package com.hcl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory=null;
	
		
	public static SessionFactory getSessionFactory() {
		if(factory==null) {
	      factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(EmpTemp.class).buildSessionFactory();
		}
		return factory;
	}
	

}
