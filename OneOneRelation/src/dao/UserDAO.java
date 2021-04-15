package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;
import domain.User;

public class UserDAO {
	public void insert(User user) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		session.save(user);
		
		session.getTransaction().commit();
	}

	public User find(Integer id) {
SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		User user = (User) session.get(User.class, id);
		
		session.getTransaction().commit();
		return user;
	}
}
