package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Map_main {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Question q1 = new Question();
		q1.setQuestion_id(121);
		q1.setQuestion("Full form of OOP");
		
		Answer ans = new Answer();
		ans.setAnswer_id(221);
		ans.setAnswer("Object Oreinted Programming");
		
		q1.setAnswer(ans);
		
		Session session = factory.openSession();
		
		Transaction t = session.beginTransaction();
		
		session.save(q1);
		session.save(ans);
		
		t.commit();
		
		session.close();
		factory.close();
	}
}	
