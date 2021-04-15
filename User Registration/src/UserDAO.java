package src;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDAO {

    public void insert(User user) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();

	}

	public List<User> list() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
	    String hql="from User u order by u.name, u.phoneNumber asc";
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery(hql);
        List<User> list=query.list();
       
        session.getTransaction().commit();
       
        return list;
	}
}
