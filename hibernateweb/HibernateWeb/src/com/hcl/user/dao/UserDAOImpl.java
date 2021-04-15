package com.hcl.user.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.hcl.user.domain.User;
import com.hcl.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public Boolean insertUser(User user) {
		SessionFactory sessionFactory = HibernateUtil.geSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		boolean isSaved = true;
		
		try {
			session.save(user);
		} catch(HibernateException e) {
			isSaved = false;
		}
		
		
		session.getTransaction().commit();
		
		return isSaved;
	}

	@Override
	public User getUserByEmail(String email) {
		SessionFactory sessionFactory = HibernateUtil.geSessionFactory();
		Session session=sessionFactory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(User.class);
        cr.add(Restrictions.eq("email", email));
        
        List<User> results = cr.list();
        
        session.getTransaction().commit();
        
        
        if(results != null && results.size()!=0) {
        	return results.get(0);
        }
        return null;
	}

}
