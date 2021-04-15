package com.hcl;
import java.io.*;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
import java.util.*;


public class Main {
	public static void main(String[] args) {
		
//		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Trainee.class).buildSessionFactory();
//		Session session = factory.getCurrentSession();
//		session.beginTransaction();
//		session.save(new Trainee("Betty","php","9087988967"));
//		session.getTransaction().commit();
//		System.out.println("Trainee has been successfully added");
		
		TraineeDAO dao = new TraineeDAO();
		Trainee t = dao.getTraineeById(3);
		System.out.println(t);
		//dao.deleteTrainee(t);
		
		dao.addTrainee(new Trainee("Kathy","Java","8739487293"));
		dao.addTrainee(new Trainee("Nila","python","87434293"));
		dao.addTrainee(new Trainee("Nimal","php","437394874"));
		
		List<Trainee> list = dao.getAllTrainees();
		System.out.println("******Trainee Details*********");
		for(Trainee tt:list) {
			System.out.println(tt);
		}
		
		
	}
}
