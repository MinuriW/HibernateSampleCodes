import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

 

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

 

public class HibernateUtil 
{
   private static SessionFactory sessionFactory=null;

    static {   
        try 
        {
            
            
            ResourceBundle rb = ResourceBundle.getBundle("oracle");
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            cfg.setProperty("hibernate.connection.url", rb.getString("db.url"));
            cfg.setProperty("hibernate.connection.username", rb.getString("db.username"));
            cfg.setProperty("hibernate.connection.password", rb.getString("db.password"));
            cfg.addAnnotatedClass(Stall.class);
            cfg.addAnnotatedClass(StallLicense.class);
            sessionFactory = cfg.buildSessionFactory();
        }
        catch (Throwable ex) 
        {
            System.err.println("SessionFactory initial creation error."+ ex);    
        }
    }
    
    public static SessionFactory getSessionFactory() 
    {
        try {
            Class.forName("HibernateUtil");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sessionFactory;
    }
}