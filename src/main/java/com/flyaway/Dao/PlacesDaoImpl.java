package com.flyaway.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.flyaway.config.HibConfig;
import com.flyaway.entities.Places;

public class PlacesDaoImpl implements PlacesDao{

	@Override
	public void insert(Places place) {
		// TODO Auto-generated method stub
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
		try {
			factory = HibConfig.getFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			session.save(place);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		
	}

	@Override
	public List<Places> getAll() {
		// TODO Auto-generated method stub
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
		List<Places> places=null;
		try {
			factory = HibConfig.getFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Places> query = session.createQuery("select p from com.flyaway.entities.Places p");
			places = query.list();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		
		return places;
	}

	@Override
	public void update(Places place, int id) {
		// TODO Auto-generated method stub
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
		List<Places> places=null;
		try {
			factory = HibConfig.getFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Places> query = session.createQuery("update com.flyaway.entities.Places p set p.placeCode=?1, p.placename=?2 where p.placeId=?3");
			query.setParameter(1, place.getPlaceCode());
			query.setParameter(2,place.getPlaceName());
			query.setParameter(3, id);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
		try {
			factory = HibConfig.getFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			Places place = session.get(Places.class,id);
			session.delete(place);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public Places get(String placename) {
		// TODO Auto-generated method stub
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
		Places places=null;
		try {
			factory = HibConfig.getFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Places> query = session.createQuery("select p from com.flyaway.entities.Places p where p.placeName=?1");
			query.setParameter(1, placename);
			places = query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		return places;
	}

}
