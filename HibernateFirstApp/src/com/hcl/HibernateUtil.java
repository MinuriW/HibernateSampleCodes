package com.hcl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//public class HibernateUtil {
//    
//    public static SessionFactory getSessionFactory() {
//        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Trainee.class).buildSessionFactory();
//        return factory;
//    }
 
public class HibernateUtil {
    private static SessionFactory factory = null;
    
    public static SessionFactory getSessionFactory() {
        if(factory == null) {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            cfg.addAnnotatedClass(Trainee.class);
            factory =  cfg.buildSessionFactory();
        }
        
        return factory;
    }
}

