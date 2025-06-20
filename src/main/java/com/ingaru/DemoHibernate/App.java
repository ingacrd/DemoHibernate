	package com.ingaru.DemoHibernate;
	
	import com.ingaru.DemoHibernate.Student;

import java.util.List;
import java.util.Random;


import org.hibernate.query.Query;


import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
	
	/**
	 * Hello world!
	 *
	 */
	public class App 
	{
	    public static void main( String[] args )
	    {
	    	Student s = null;

	        
	        Configuration config = new Configuration();
	        config.configure("hibernate.cfg.xml");
	        
	        SessionFactory factory = config.buildSessionFactory();
	        Session session = factory.openSession();
	        session.beginTransaction();
	        
	        
	        //HQL
	        //Query<Student> query = session.createQuery("from Student", Student.class);
	        //Query<Student> query = session.createQuery("from Student where marks > 50", Student.class);
	        //Query<Student> query = session.createQuery("from Student where rollno=7", Student.class);
//	        Query<Object[]> query = session.createQuery("select rollno, sname, marks from Student where rollno=7", Object[].class);
	        //Query<Object[]> query = session.createQuery("select s.rollno, s.sname, s.marks from Student s where s.rollno = 7", Object[].class);
	        //Query<Object[]> query = session.createQuery("select rollno, sname, marks from Student", Object[].class);
	        int b = 60;
	        //Query<Long> query = session.createQuery("select sum(marks) from Student s where s.marks>60", Long.class);
	        Query<Long> query = session.createQuery("select sum(marks) from Student s where s.marks>: b", Long.class);
	        query.setParameter("b", b);
	        Long marks = (Long) query.uniqueResult();
	        System.out.println(marks);
	        //List<Object[]> students = query.getResultList();
	        //Object[] student = query.uniqueResult();
	        
//	        for(Object[] o : students) {
//	        	System.out.println(o[0] + " " + o[1] + " " + o[2]);
//	        }
	        
	        //Student student = query.uniqueResult();
	        //System.out.println(student);
	        //List<Student> students = query.getResultList();
	        
	        
//	        for(Student stu: students) {
//	        	System.out.println(stu);
//	        }

	        session.getTransaction().commit();
	        session.close();
	        
 
	    }
	}
