package com.flyaway.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.flyaway.config.HibConfig;
import com.flyaway.entities.Flights;

public class FlightsdaoImpl implements FlightsDao {

	@Override
	public void insert(Flights flight) {
		// TODO Auto-generated method stub
		SessionFactory factory = null;
		Session session = null;
		Transaction tx = null;
		try {
			factory=HibConfig.getFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			session.save(flight);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}

	}

	@Override
	public void update(int id, Flights flight) {
		// TODO Auto-generated method stub
		SessionFactory factory = null;
		Session session = null;
		Transaction tx = null;
		try {
			factory=HibConfig.getFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Flights> query=session.createQuery("update com.flyaway.entities.Flights f set f.airline=?1, f.route=?2, f.price=?3, f.source=?4, f.destination=?5 where f.flightId=?6");
			query.setParameter(1, flight.getAirline());
			query.setParameter(2, flight.getRoute());
			query.setParameter(3, flight.getPrice());
			query.setParameter(4, flight.getSource());
			query.setParameter(5, flight.getDestination());
			query.setParameter(6, id);
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
		SessionFactory factory = null;
		Session session = null;
		Transaction tx = null;
		try {
			factory=HibConfig.getFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			Flights fl=session.get(Flights.class, id);
			session.delete(fl);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public List<Flights> getAll() {
		// TODO Auto-generated method stub
		SessionFactory factory = null;
		Session session = null;
		Transaction tx = null;
		List<Flights> flights=null;
		try {
			factory=HibConfig.getFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Flights> query=session.createQuery("select f from com.flyaway.entities.Flights f");
			flights = query.list();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		return flights;
	}

	@Override
	public List<Flights> getFlight(String source, String Destination) {
		// TODO Auto-generated method stub
		SessionFactory factory = null;
		Session session = null;
		Transaction tx = null;
		List<Flights> flights=null;
		try {
			factory=HibConfig.getFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Flights> query=session.createQuery("select f from com.flyaway.entities.Flights f where f.source=?1 and f.destination=?2");
			query.setParameter(1, source);
			query.setParameter(2, Destination);
			flights = query.list();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		return flights;
	}

	@Override
	public Flights getById(int id) {
		// TODO Auto-generated method stub
		SessionFactory factory = null;
		Session session = null;
		Transaction tx = null;
		Flights flight=null;
		try {
			factory=HibConfig.getFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Flights> query=session.createQuery("select f from com.flyaway.entities.Flights f where f.flightId=?1");
			query.setParameter(1, id);			
			flight = query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		return flight;
	}

}
