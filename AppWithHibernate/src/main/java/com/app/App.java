package com.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.config.HibernateConfig;
import com.app.entities.Address;
import com.app.entities.Certificate;
import com.app.entities.Student;
import com.mysql.cj.protocol.FullReadInputStream;

public class App {
	public static void main(String[] args) throws IOException {
		// heavyWeight dataBase connection that connect one time to Databse and remain
		// in app until shut the App.
//        Configuration cfg=new Configuration();
//        cfg.configure("hibernate.cfg.xml");
//        SessionFactory  factory=cfg.buildSessionFactory();
//        System.out.println(factory);
		Student student = new Student();
		student.setId(101);
		student.setFirstName("brajesh");
		student.setLastName("Kumar");
		student.setEmail("bk04031997@gmail.com");
	     Address address=new Address();
	     address.setAddedDate(new Date());
	     address.setCity("Kanpur");
	     address.setPincode("209112");
	     address.setStreet("Dibair");
	     
	     //reading image
//	     FileInputStream fis=new FileInputStream("/home/brajesh/Documents/brajesh/github/Spring_Data/AppWithHibernate/src/main/java/com/app/Screenshot.png");
//	     byte[] data=new byte[fis.available()];
//	     fis.read(data);
//	     address.setImage(data);
	     
	     Certificate cert=new Certificate();
	     cert.setCertificate_year(2020);
	     cert.setCourse("JAVA");
	     student.setCert(cert);
	     saveStudent(student,address); 
//	     readValue();
	}
	private static  void saveStudent(Student std,Address adrr) {
		Transaction txn=null;
		Session session=null;
		try {
		session = HibernateConfig.getSessionFactory().openSession();
		txn = session.beginTransaction();
		session.save(std);
		session.save(adrr);
		txn.commit();
		session.close();
		}catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			session.close();
		}
	
	}
	
	private static void readValue() {
		Session session=null;
		try {
		session = HibernateConfig.getSessionFactory().openSession();
//		Student student= (Student)session.get(Student.class, 10);
		Student student= (Student)session.load(Student.class, 10);
		System.out.println(student);
		}
		catch (Exception e) {
		e.printStackTrace();
		}
	}
}
