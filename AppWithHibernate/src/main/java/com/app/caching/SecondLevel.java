package com.app.caching;

import org.hibernate.Session;

import com.app.config.HibernateConfig;
import com.app.entities.Student;

import net.sf.ehcache.hibernate.EhCacheRegionFactory;


public class SecondLevel {
public static void main(String[] args) {
	Session session = HibernateConfig.getSessionFactory().openSession();
	  Student std=(Student)session.get(Student.class, 1);
	  System.out.println(std);
}
}
