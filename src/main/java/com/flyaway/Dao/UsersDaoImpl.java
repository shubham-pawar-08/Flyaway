package com.flyaway.Dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flyaway.config.HibConfig;
import com.flyaway.entities.Users;

public class UsersDaoImpl implements UsersDao{

	@Override
	public void addUser(Users user) {
		// TODO Auto-generated method stub
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
		try {
			factory=HibConfig.getFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void changePassword(String username, String password) {
		// TODO Auto-generated method stub
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
		try {
			factory=HibConfig.getFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Users> query =session.createQuery("update login set pass = ? where uname = ?");
			query.setParameter(1, password);
			query.setParameter(2, username);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void deleteUser(int uno) {
		// TODO Auto-generated method stub
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
		try {
			factory=HibConfig.getFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			Users usr= session.get(Users.class,uno);
			session.delete(usr);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}
		
	}

	@Override
	public List<Users> getUser(String Username) {
		// TODO Auto-generated method stub
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
		List<Users> user=null;
		try {
			factory=HibConfig.getFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Users> query = session.createQuery("Select * from login where u.userName=?1");
			query.setParameter(1, Username);
			user = query.list();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		return user;
	}

}
