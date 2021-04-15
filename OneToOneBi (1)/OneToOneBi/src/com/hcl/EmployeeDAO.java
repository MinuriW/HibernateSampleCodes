package com.hcl;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeDAO {
	
	SessionFactory factory;
	
	public EmployeeDAO() {
		factory=HibernateUtil.getSessionFactory();
	}
	
	public void addEmployee(Employee e) {
		Session session=factory.openSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		System.out.println("Employee Added Successfully.");
	}
	
	
	
	public List<Employee> getAllEmployees(){
		Session session=factory.openSession();
		String hql="from Employee";
	    session.beginTransaction();
	    Query query=session.createQuery(hql);
	    List<Employee> list=query.list();
		
		return list;
	}

}











