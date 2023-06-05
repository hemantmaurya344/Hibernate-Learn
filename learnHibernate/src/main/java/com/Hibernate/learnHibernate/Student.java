package com.Hibernate.learnHibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="student_details")
public class Student {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sId;
	private String sName;
	private String sCity;
	
	private Certificate cert;
	
	public Student(int sId, String sName, String sCity) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sCity = sCity;
	}

	public Student() {
		super();
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsCity() {
		return sCity;
	}

	public void setsCity(String sCity) {
		this.sCity = sCity;
	}

	@Override
	public String toString() {
		
		return this.sId+" : "+this.sName+" : "+sCity;
	}

	public Certificate getCert() {
		return cert;
	}

	public void setCert(Certificate cert) {
		this.cert = cert;
	}
	
	
}
