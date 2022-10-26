package com.flyaway.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.flyaway.entities.Airlines;
import com.flyaway.entities.Flights;
import com.flyaway.entities.Places;
import com.flyaway.entities.Users;


public class HibConfig {
	
	public static SessionFactory getFactory() {

		Configuration configuration = new Configuration();
		Properties properties = new Properties();

		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.URL, "jdbc:mysql://localhost:3306/flway");
		properties.put(Environment.USER, "root");
		properties.put(Environment.PASS, "992029");
		properties.put(Environment.SHOW_SQL, true);
		properties.put(Environment.FORMAT_SQL, true);
		properties.put(Environment.HBM2DDL_AUTO, "update");
		configuration.setProperties(properties);
		configuration.addAnnotatedClass(Places.class);
		configuration.addAnnotatedClass(Airlines.class);
		configuration.addAnnotatedClass(Flights.class);
		configuration.addAnnotatedClass(Users.class);
		return configuration.buildSessionFactory();

	}

}
