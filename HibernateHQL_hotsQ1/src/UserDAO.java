import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDAO {
    SessionFactory factory;

    public UserDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
	public void addUser(User user) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}

	public List<User> listDetails() {
		String hql = "from User order by userid";
		Session session=factory.openSession();
    	session.beginTransaction();
    	Query query = session.createQuery(hql);
    	List<User> list = query.list();
    	session.getTransaction().commit();
    	return list; 
	}

}
