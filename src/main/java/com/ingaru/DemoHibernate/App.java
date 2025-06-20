	package com.ingaru.DemoHibernate;
	
	import com.ingaru.DemoHibernate.Student;

import java.util.List;
import java.util.Random;

import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;


import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Map;
import java.util.HashMap;
	
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
//	        
	        
//	        NativeQuery<Student> query = session.createNativeQuery(
//	        	    "select * from student where marks > 60", Student.class
//	        	);
	        Query<Map<String, Object>> query = session.createNativeQuery(
	        	    "select sname, marks from student where marks > 60", Object.class
	        	).unwrap(NativeQuery.class);
	        query.setTupleTransformer((tuple, aliases) -> {
	        	     Map<String, Object> map = new HashMap<>();
	        	     for (int i = 0; i < aliases.length; i++) {
	        	         map.put(aliases[i], tuple[i]);
	        	     }
	        	     return map;
	        	});
	        List<Map<String, Object>> results = query.getResultList();

	        for (Map<String, Object> row : results) {
	            System.out.println(row.get("sname") + " - " + row.get("marks"));
	        }
        
//        for(Student o : students) {
//        	System.out.println(o);
//        }


	        session.getTransaction().commit();
	        session.close();
	        
 
	    }
	}
