import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class ItemDAO {
    SessionFactory factory;
    
    public ItemDAO() {
        factory = HibernateUtil.getSessionFactory();
    }
    public List<Item> list(){
        String hql = "from Item order by id asc";
        Session session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(hql);
        List<Item> list = query.list();
        session.getTransaction().commit();
        
        return list;
        
    }
    public Item find(int id) {
        String hql = "from Item where id = :id";
        Session session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        List result = query.list();
        session.getTransaction().commit();
        if(result.size()!=0) {
            Item item = (Item)result.get(0);
            return item;
        }
        return null;
    }
    public void updateItemPriceById(Item item) {
        String hql = "update Item set price = :price where id = :id";
        Session session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(hql);
        
        query.setParameter("price", item.getPrice());
        query.setParameter("id", item.getId());
        
        query.executeUpdate();
        
        session.getTransaction().commit();
    }
    public void delete(Item item) {
//        String hql = "delete from Item where id = :id";
        Session session = factory.openSession();
        session.beginTransaction();
        //Query query = session.createQuery(hql);
       // query.setParameter("id", item.getId());
        
        session.delete(item);
        session.getTransaction().commit();
        
    }
}