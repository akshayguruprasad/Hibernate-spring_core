package com.indream.dao;

import org.hibernate.Session;

import com.indream.model.User;

public interface UserLoginDao {

	int addUser(Session connection,User user);
	boolean deleteuser(Session session,int id);
	public User selectuser(Session session, int id) ;
}
