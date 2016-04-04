package mum.eud.week1ExtraCredit.factory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import mum.eud.week1ExtraCredit.domain.Artist;
import mum.eud.week1ExtraCredit.domain.Director;
import mum.eud.week1ExtraCredit.domain.Movie;

/**
 * @author PatiRam
 *
 */
public class HibernateUtilFactory {
private static final SessionFactory sessionFactory;
	
	static{
		try {
			
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Director.class);
			configuration.addAnnotatedClass(Artist.class);
			configuration.addAnnotatedClass(Movie.class);
			configuration.configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			
		} catch (Throwable e) {
			
			e.printStackTrace();	
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
