package com.Hibernate.learnHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedExample {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		
		Student student1 = new Student();
		student1.setsName("Rajat Patidar");
		student1.setsCity("Lucknow");
		
		Certificate cert = new Certificate("Btech","4 years");
		 
		student1.setCert(cert);
		
		
		Student student2 = new Student();
		student2.setsName("Piyush Kumar");
		student2.setsCity("West Bengal");
		
		Certificate cert1 = new Certificate("Python","1 yrs");
		 
		student2.setCert(cert1);
		
		Session session  = factory.openSession();
		
		Transaction t = session.beginTransaction();
			
		session.save(student1);
		session.save(student2);
		
		session.close();
		factory.close();
	}
}
