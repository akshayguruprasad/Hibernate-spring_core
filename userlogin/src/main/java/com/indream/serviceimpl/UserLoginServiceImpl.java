package com.indream.serviceimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.indream.dao.UserLoginDao;
import com.indream.model.User;
import com.indream.service.UserLoginService;

public class UserLoginServiceImpl implements UserLoginService {

	private SessionFactory sessionFactory;

	private UserLoginDao dao;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserLoginDao getDao() {
		return dao;
	}

	public void setDao(UserLoginDao dao) {
		this.dao = dao;
	}

	@Override
	public int adduser(User user) {
		int id = 0;
		Session session = null;
		try {
			
			try {
				session = sessionFactory.openSession();
				session.beginTransaction();
			} catch (Exception e) {
				System.out.println("sesssion factory problem [UserLoginService] " + e.getMessage());
			}
			id = dao.addUser(session, user);
			if (id < 1) {
				throw new Exception("Failed to add the user to the list");
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return id;
	}

	@Override
	public boolean deleteUser(int id) {
		Session session = null;
		boolean isDeleted = false;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			isDeleted = dao.deleteuser(session, id);
			if (!isDeleted) {
				throw new Exception("Could not delete");
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			session.getTransaction().rollback();
		}
		return isDeleted;
	}

	@Override
	public User selectUser(int id) {
		Session session = null;
		User user = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			user = dao.selectuser(session, id);
			if (user == null) {
				throw new Exception("No records found");
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			session.getTransaction().rollback();
		}
		return user;

	}
}
