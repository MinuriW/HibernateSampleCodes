import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDAO {
	SessionFactory factory;
    
    public UserDAO() {
        factory=HibernateUtil.getSessionFactory();
    }
	public void insert(User user) {
		Session session=factory.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    
	}
	
	public User find(String id){
		Session session=factory.getCurrentSession();
        session.beginTransaction();
        User user=(User)session.get(User.class,id);
        session.getTransaction().commit();
        return user;
        
	}
}

