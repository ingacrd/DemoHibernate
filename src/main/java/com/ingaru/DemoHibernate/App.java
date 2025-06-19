	package com.ingaru.DemoHibernate;
	
	import com.ingaru.DemoHibernate.Student;
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
	        //Student student = new Student(103,"Carolina");
	        
	        Configuration config = new Configuration();
	        //Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
	        //ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
	        config.configure("hibernate.cfg.xml");
	        
	        SessionFactory factory = config.buildSessionFactory();
	        Session session = factory.openSession();
	        //Transaction tx = session.beginTransaction();
	        session.beginTransaction();
	        //session.save(student);
	        
	        s= (Student) session.get(Student.class, 101);
	        System.out.println(s);
	        session.getTransaction().commit();
	        session.close();
	        
	        Session session2 = factory.openSession();
	        session2.beginTransaction();
	        s = (Student) session2.get(Student.class, 101);
	        System.out.println(s);
	        session2.getTransaction().commit();
	        session2.close();
	        
	        
	        
	        //tx.commit();
	        
	        System.out.println("Record Saved Succesfully");
	        
	        
	        
	        
	    }
	}
