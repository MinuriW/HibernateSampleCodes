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
	     
	   
	    public List<User> listDetails(){
	    	SessionFactory factory = HibernateUtil.getSessionFactory();
		    String hql="from User order by userid";
	        Session session=factory.openSession();
	        session.beginTransaction();
	        Query query=session.createQuery(hql);
	        List<User> list=query.list();
	       
	        session.getTransaction().commit();
	       
	        return list;
	    }
	 
	    public void updateUser(Integer userid,String password ){
	    	SessionFactory factory = HibernateUtil.getSessionFactory();
	    	 String hql = "update User set password = :password where userid = :userid";
	         Session session = factory.openSession();
	         session.beginTransaction();
	         Query query = session.createQuery(hql);
	         
	         query.setParameter("password", password);
	         
	         query.executeUpdate();
	         
	         session.getTransaction().commit();
	         
			
		}
	}
	

