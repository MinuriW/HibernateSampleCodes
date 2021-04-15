package com.hcl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.*;
public class EmployeeDAO {
	
    SessionFactory factory;	

    public EmployeeDAO() {
    	factory=HibernateUtil.getSessionFactory();
    }
    
    public List<Employee> searchByCity(String keyword){
    	Session session=factory.openSession();
    	String hql = "from Employee where city like :city";
    	session.beginTransaction();
    	Query query = session.createQuery(hql);
    	query.setParameter("city", "%" + keyword + "%");
    	 
    	List<Employee> list = query.list();
    	session.getTransaction().commit();
    	return list; 

    }
    
    
    public void copyFromTable() {
    	
    	Session session=factory.openSession();
    	String hql = "insert into EmpTemp (eno,ename,city)"
    	        + " select eno, ename,city from Employee";
    	session.beginTransaction();
    	Query query = session.createQuery(hql);
    	int rowsAffected = query.executeUpdate();
    	session.getTransaction().commit();
    	if (rowsAffected > 0) {
    	    System.out.println(rowsAffected + "(s) were inserted");
    	}
    	
    }
    
    public void updateEmployee(int eno,String city) {
    	String hql = "update Employee set city = :city where eno = :eno";
    	Session session =factory.openSession();
    	session.beginTransaction();
    	Query query = session.createQuery(hql);
    	query.setParameter("city",city);
    	query.setParameter("eno", eno);
    	int rowsAffected = query.executeUpdate();
    	session.getTransaction().commit();
    	if (rowsAffected > 0) {
    	    System.out.println("Updated " + rowsAffected + " rows.");
    	}
    }
    
    
    

}
