package com.hcl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AddressDAO {

SessionFactory factory;
	
	public AddressDAO() {
		factory=HibernateUtil.getSessionFactory();
	}
	
	public void addAddress(Address a) {
		Session session=factory.openSession();
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
		System.out.println("Address Added Successfully.");
	}
	
	public List<Address> getAllAddress(){
		Session session=factory.openSession();
		String hql="from Address";
	    session.beginTransaction();
	    Query query=session.createQuery(hql);
	    List<Address> list=query.list();
	    session.getTransaction().commit();
		return list;
	}
	
	
}
