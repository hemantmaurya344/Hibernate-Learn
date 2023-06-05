package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.Hibernate.learnHibernate.Student;

public class Hql {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = factory.openSession();
		// HQL 
		
//		String q = "from Student where sCity='Bihar'";
		
//		String q = "from Student where cert.course='B.E'";
			
//		String q = "from Student where sCity=:x";

		String q = "from Student as s where s.sCity=:x and s.sName=:n";

		Query query = session.createQuery(q);
		
//		query.setParameter("x", "Dehradun");
		
		query.setParameter("x", "Dehradun");
		query.setParameter("n", "Rahul");

		
		List<Student> list = query.list();
		
		for(Student s : list) {
			System.out.println(s.getsName() +" : "+s.getCert().getCourse()+" : "+s.getsId());
		}
		
		
		session.close();
		factory.close();
		
	}
}
