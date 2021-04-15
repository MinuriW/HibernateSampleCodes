import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class ItemDAO {
	SessionFactory factory;	
	
	public ItemDAO() {
		factory=HibernateUtil.getSessionFactory();
	}
    public List<Item> list(){
    	String hql = "from Item order by id asc";
    	Session session=factory.openSession();
    	session.beginTransaction();
    	Query query = session.createQuery(hql);
    	List<Item> list = query.list();
    	session.getTransaction().commit();
    	return list; 
	}
	public Double averagePriceByCategory(String category) {
    	String hql = "select avg(price) from Item where category = :category";
    	Session session=factory.openSession();
    	session.beginTransaction();
    	Query query = session.createQuery(hql);
    	query.setParameter("category", category);
    	List rs = query.list();
    	session.getTransaction().commit();
    	Double avg = (Double)rs.get(0);
		return avg;
	}
}
