	package com.ingaru.DemoHibernate;
	
	import com.ingaru.DemoHibernate.Alien;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.*;


	
	public class App 
	{
	    public static void main( String[] args )
	    {
	    	Alien a1= new Alien();
	    	a1.setAid(1);
	    	a1.setAname("Maria");
	    	a1.setTech("Hardward");
	    	
	    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myHibernatePU");
	    	EntityManager em = emf.createEntityManager();
	    	
	    	//save
	    	em.getTransaction().begin();
	    	em.persist(a1);
	    	em.getTransaction().commit();
	    	
	    	//fetch
	    	Alien a = em.find(Alien.class,1);
	    	System.out.println(a);
	    	
	    	
	    }
	}
