package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;
import domain.User;

public class UserDAO {
	public void insert(User user) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);

		session.getTransaction().commit();

	}

	public User find(Integer id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		User user = (User) session.get(User.class, id);
		session.getTransaction().commit();
		return user;
	}
}
