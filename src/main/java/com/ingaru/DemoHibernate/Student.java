package com.ingaru.DemoHibernate;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Student {
	
	@Id
	private int rollno;
	private String sname;
	
	public Student() {
		
	}
	
	public Student(int rollno, String sname) {
		super();
		this.rollno = rollno;
		this.sname = sname;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", sname=" + sname + "]";
	}
	
	

}
