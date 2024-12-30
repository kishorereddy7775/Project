package com.flm.dao;

import java.util.List;

import com.flm.model.User;

public interface UserDAO {
	
	User getOneUser(String email);
	List<User> getUserDetails();
	void activateUser(String email);
	void inActivateUser(String email);
	void updateFailedCount(String email,int count);
}
