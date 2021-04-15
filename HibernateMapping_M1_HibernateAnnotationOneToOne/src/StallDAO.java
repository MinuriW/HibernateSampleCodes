import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

public class StallDAO {

	SessionFactory factory = null;

	public StallDAO() {
		factory = HibernateUtil.getSessionFactory();
	}

	public void insert(Stall stall) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(stall);
		session.getTransaction().commit();
	}

	public Stall find(int id) {
		String hql = "from Stall where stallId='" + id + "'";
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		List<Stall> list = query.list();
		session.getTransaction().commit();
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	public void update(Stall stall) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(stall);
		session.getTransaction().commit();
	}

	public List list() {
		String hql = "from Stall";
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		List<Stall> list = query.list();
		session.getTransaction().commit();
		
		return list;
	}
}
