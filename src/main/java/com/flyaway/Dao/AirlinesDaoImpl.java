package com.flyaway.Dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.flyaway.config.HibConfig;
import com.flyaway.entities.Airlines;

public class AirlinesDaoImpl implements AirlinesDao{

	@Override
	public void insert(Airlines airline) {
		// TODO Auto-generated method stub
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
		try {
			factory = HibConfig.getFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			session.save(airline);			
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		
	}

	@Override
	public void update(int ano, Airlines airline) {
		// TODO Auto-generated method stub
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
		try {
			factory = HibConfig.getFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Airlines> query=session.createQuery("update com.flyaway.entities.Airlines a set a.airLineCode=?1,a.airLineName=?2 where a.airLineId=?3");			
			query.setParameter(1, airline.getAirLineCode());
			query.setParameter(2, airline.getAirLineName());
			query.setParameter(3, ano);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		
	}

	@Override
	public List<Airlines> getAll() {
		// TODO Auto-generated method stub
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
		List<Airlines> airlines=null;
		try {
			factory = HibConfig.getFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Airlines> query=session.createQuery("select a from com.flyaway.entities.Airlines a");			
			airlines = query.list();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		return airlines;
	}

	@Override
	public void delete(int ano) {
		// TODO Auto-generated method stub
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
		try {
			factory = HibConfig.getFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			Airlines airline=session.get(Airlines.class, ano);
			session.delete(airline);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		
	}

}
