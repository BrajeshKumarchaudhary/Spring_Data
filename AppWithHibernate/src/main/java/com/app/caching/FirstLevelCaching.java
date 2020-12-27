package com.app.caching;

import org.hibernate.Session;

import com.app.config.HibernateConfig;
import com.app.entities.Student;

public class FirstLevelCaching {
public static void main(String[] args) {
	  Session session = HibernateConfig.getSessionFactory().openSession();
	  Student std=(Student)session.get(Student.class, 1);
	  System.out.println(std);
	  //it is not fire second Time Query for same Object store into session cache.
	  Student std1=(Student)session.get(Student.class, 1);
	  System.out.println(std1);
	  System.out.println(session.contains(std1));
}
}
