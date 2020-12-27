package com.app;

import org.hibernate.Query;
import org.hibernate.Session;

import com.app.config.HibernateConfig;
import com.app.entities.Question;

public class HQLExample {
public static void main(String[] args) {
	 Session session = HibernateConfig.getSessionFactory().openSession();
	  Question q=(Question)session.get(Question.class, 1);
	  //JPQL Syntax.
	  String query="from Student where id=:x";
	  Query qry= session.createQuery(query);
	  qry.setParameter("x", 10);
	  System.out.println(qry.list());	//use list for Multiple Result and unique for Single Result.
}
}
