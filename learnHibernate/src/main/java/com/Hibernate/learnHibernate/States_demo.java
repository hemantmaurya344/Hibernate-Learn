package com.Hibernate.learnHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class States_demo {
	public static void main(String[] args) {
		
		// states Demo
		
		SessionFactory f = new Configuration().configure().buildSessionFactory();
		
		Student std =new Student();
		std.setsId(1);
		std.setsName("Rohan");
		std.setsCity("Bhopal");
		std.setCert(new Certificate("Java","3 Months"));
		// right now in transient
		
		
		Session s = f.openSession();
		Transaction t = s.beginTransaction();
		s.save(std);
		// in persistent state
		std.setsName("rahul");
		
		t.commit();
				
		s.close();
		std.setsName("ram");
		System.out.println(std);
		// now in detached state
		
		
		f.close();
	}
}
