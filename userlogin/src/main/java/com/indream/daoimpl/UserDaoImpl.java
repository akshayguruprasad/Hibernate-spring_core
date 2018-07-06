package com.indream.daoimpl;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.indream.dao.UserLoginDao;
import com.indream.model.User;

public class UserDaoImpl implements UserLoginDao {

	@Override
	public int addUser(Session session, User user) {// USES THE SAVE METHOD OF SESSION TO PERSSIT OBJECT IN DB
		session.save(user);
		session.flush();// FLUSH TO GET THE USER ID
		return user.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteuser(Session session, int id) {
		boolean isDeleted = false;
		try {
			Query<User> query1 = session.createQuery("delete Users u where u.id=:id");
			query1.setParameter("id", id);
			isDeleted = query1.executeUpdate() > 0 ? true : false;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return isDeleted;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User selectuser(Session session, int id) {
		Query<User> query1 = session.createQuery("From Users u where u.id=:id");
		query1.setParameter("id", id);
		return query1.getSingleResult();

	}
}
