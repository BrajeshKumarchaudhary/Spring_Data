package com.app;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.config.HibernateConfig;
import com.app.entities.Answer;
import com.app.entities.Question;

public class Mapping {

	public static void main(String[] args) {
	
		Question q=new Question();
		q.setQuestion("What is Java?.");
		
		Answer ans=new Answer();
		ans.setAnswer("Java is a programming language");
		ans.setQuestion(q);
		List<Answer> ansList=new LinkedList<Answer>();
		q.setAnsId(ansList);
		
		Transaction txn=null;
		Session session=null;
		try {
		session = HibernateConfig.getSessionFactory().openSession();
		txn = session.beginTransaction();
		session.save(q);
		session.save(ans);
		txn.commit();
		session.close();
		}catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			session.close();
		}
	   readQuestion();
	}
  private static void readQuestion() {
	  Session session = HibernateConfig.getSessionFactory().openSession();
	  Question q=(Question)session.get(Question.class, 1);
//	  session.createQuery("from Question where").;
	  System.out.println(q.getAnsId());
  }
}
