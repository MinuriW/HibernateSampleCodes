package com.hcl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TraineeDAO {
    SessionFactory factory;
    
        public TraineeDAO() {
            factory=HibernateUtil.getSessionFactory();
        }
        
        public void addTrainee(Trainee ob) {
                Session session=factory.getCurrentSession();
                session.beginTransaction();
                session.save(ob);
                session.getTransaction().commit();
                System.out.println("Trainee has been added successfully!");
            
        }
        
    
    public Trainee getTraineeById(int id) {
        
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        Trainee ob=(Trainee)session.get(Trainee.class,id);
        session.getTransaction().commit();
        return ob;
        
    }
    
    public void deleteTrainee(Trainee ob) {

 

        Session session=factory.getCurrentSession();
        session.beginTransaction();
        session.delete(ob);
        session.getTransaction().commit();
        System.out.println("Deleted!");
        
    }
    
    public List<Trainee> getAllTrainees(){
    	   
        String hql="from Trainee";
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery(hql);
        List<Trainee> list=query.list();
       
        session.getTransaction().commit();
       
        return list;
    }
   
 

}
 