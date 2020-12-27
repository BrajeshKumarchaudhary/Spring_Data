package com.app.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.app.entities.Address;
import com.app.entities.Answer;
import com.app.entities.Question;
import com.app.entities.Student;


public class HibernateConfig {

	private static SessionFactory factory;
	public static SessionFactory getSessionFactory() {
		if(factory==null) {
			try {
            Configuration cfg =new Configuration();
            Properties properties=new Properties();
            properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
            properties.put(Environment.USER, "brajesh");
            properties.put(Environment.PASS, "p@$$W0rd");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            properties.put(Environment.SHOW_SQL, true);
            properties.put(Environment.HBM2DDL_AUTO, "update");
            //for Enabling second lavel cache.
//            properties.put(Environment.USE_SECOND_LEVEL_CACHE, true);
//            properties.put(Environment.CACHE_REGION_FACTORY,org.hibernate.cache.ehcache.EhCacheRegionFactory);
            cfg.setProperties(properties);
            cfg.addAnnotatedClass(Student.class);
            cfg.addAnnotatedClass(Address.class);
            cfg.addAnnotatedClass(Question.class);
            cfg.addAnnotatedClass(Answer.class);
            ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
            factory=cfg.buildSessionFactory(serviceRegistry);
			}catch (Exception e) {
			}
		}
		return factory;
	}
}
