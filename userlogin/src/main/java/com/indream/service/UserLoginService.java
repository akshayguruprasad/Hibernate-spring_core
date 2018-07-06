package com.indream.service;

import com.indream.model.User;

public interface UserLoginService {

	int adduser(User user);

	boolean deleteUser(int id);

	User selectUser(int id);

}
