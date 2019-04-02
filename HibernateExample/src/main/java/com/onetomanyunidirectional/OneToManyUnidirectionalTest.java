package com.onetomanyunidirectional;

import java.io.Serializable;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mkyong.util.HibernateUtil;

public class OneToManyUnidirectionalTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		insertCountryAndStates(sessionFactory);
		showCountryAndStates(sessionFactory);
		System.out.println("End of main");
	}

	private static void showCountryAndStates(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Country con = (Country)session.get(Country.class, new Long(1));
		System.out.println(con.getStates().size());
	}

	private static void insertCountryAndStates(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		State st1 =  new State("Odisha");
		State st2 =  new State("Chennai");
		State st3 =  new State("Karnatak");
		session.save(st1);
		session.save(st2);
		session.save(st3);
		Set<State> set = new HashSet<State>();
		set.add(st1);
		set.add(st2);
		set.add(st3);
	
		
		Country c1 = new Country("India");
		c1.setStates(set);
		session.save(c1);
		session.getTransaction().commit();
		session.close();
	System.out.println(c1);
	
	
	}
}
