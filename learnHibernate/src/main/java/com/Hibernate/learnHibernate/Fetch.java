package com.Hibernate.learnHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch {
	public static void main(String[] args) {
		
		// creating Session factory
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		// Creating session from sessionFactory
		Session session =  factory.openSession();
		
		Student studentOut = (Student)session.get(Student.class, 4);
		System.out.println(studentOut);
		
		
		Address add = (Address)session.get(Address.class, 1);
		System.out.println(add.getCity());
		
		session.clear();
		
		factory.close();
	}
}
