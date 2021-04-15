import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

public class StallDAO {
    //fill your code here
	public void insert(Stall stall) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(stall);
		
		session.getTransaction().commit();
		
	}
	public Stall find(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Stall stall = (Stall) session.get(Stall.class, new Integer(id));
		
		session.getTransaction().commit();
		
		return stall;
	}
	public void update(Stall stall) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.update(stall);
		
		session.getTransaction().commit();
	}
	public List list() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		String hql = "FROM Stall ORDER BY stallId";
		Session session = sf.openSession();
		session.beginTransaction();
		
		Query q = session.createQuery(hql);
		List<Stall> stalls = q.list();
		
		session.getTransaction().commit();
		
		return stalls;
	}
}
