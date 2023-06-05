package com.Hibernate.learnHibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws IOException{
		System.out.println("Project Started");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// creating object of entity student
		Student std = new Student();
		std.setsName("Vihal");
		std.setsCity("Dehradun");
		std.setCert(new Certificate("BCA","3yrs"));

		System.out.println(std);
		
		Student std1 = new Student();
		std1.setsName("Rahul");
		std1.setsCity("Bihar");
		std1.setCert(new Certificate("B.E","4yrs"));
		
		// creating object of entity address
		Address ad = new Address();
		ad.setStreet("street 11");
		ad.setCity("Dehradun");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(122.3435);
		
		// reading image
//		FileInputStream fis = new FileInputStream("C:\\Users\\Hemant Maurya\\Pictures\\Screenshot 2023-05-22 115955.png");			
//		
//		byte[] data = new byte[fis.available()];
//		fis.read(data);		
//		ad.setImage(data);
		
		
		Session session = factory.openSession();
		
//		session.beginTransaction();
		Transaction t = session.beginTransaction();
		
		// saving the std obj
		session.persist(std);
		session.save(ad);
		session.save(std1);
		
		// commit
//		session.getTransaction().commit();
		t.commit();
		
		session.close();
		
		
		
		
	}
}
