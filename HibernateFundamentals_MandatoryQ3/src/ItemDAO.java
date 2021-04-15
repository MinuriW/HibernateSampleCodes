import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ItemDAO {
	SessionFactory factory;

	public ItemDAO() {
		factory = HibernateUtil.getSessionFactory();
	}

	public void insert(Item item) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
	}

	public void update(Item item) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(item);
		session.getTransaction().commit();
	}

	public List<Item> list() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		String hql = "from Item order by number desc";
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		List<Item> list = query.list();

		session.getTransaction().commit();

		return list;
	}

	public Item find(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		String hql = "from Item where id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		// Item item=(Item)session.get(Item.class,id);
		List<Item> list = query.list();
		session.getTransaction().commit();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
