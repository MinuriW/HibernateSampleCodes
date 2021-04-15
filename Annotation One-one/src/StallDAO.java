import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

public class StallDAO {
    SessionFactory factory;

	public StallDAO() {
		factory = HibernateUtil.getSessionFactory();
	}

	public void insert(Stall stall) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(stall);
		session.getTransaction().commit();
	}

	public Stall find(int id) {
		String hql = "from Stall where stallId = :stallId";
		Session session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("stallId", id);
		List result = query.list();
		session.getTransaction().commit();
		if (result.size() != 0) {
			Stall stall = (Stall) result.get(0);
			return stall;
		}
		return null;
	}

	public void update(Stall stall) {
		//String hql = "update Stall set license = :license where stallId = :stallId";
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(stall);
		//Query query = session.createQuery(hql);

		//query.setParameter("license", stall.getLicense());
		//query.setParameter("stallId", stall.getStallId());

		//query.executeUpdate();

		session.getTransaction().commit();
	}

	public List<Stall> list() {
		Session session=factory.openSession();
		String hql="from Stall order by stallId";
	    session.beginTransaction();
	    Query query=session.createQuery(hql);
	    List<Stall> list=query.list();
		
		return list;
	}
}
