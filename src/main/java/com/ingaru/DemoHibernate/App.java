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

//	        Laptop lap = session.get(Laptop.class, 6);
//	        System.out.println(lap);
	        
	        Laptop lap = session.load(Laptop.class, 6);
	        System.out.println(lap);
	        

	        session.getTransaction().commit();

	      
	        
	        session.close();
	    }
	}
