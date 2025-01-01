package com.flm.dao;

import java.util.List;

import com.flm.model.Route;
import com.flm.model.User;

public interface AgentDAO {
	List<User> getUsers();
	List<Route> getAllroute();
	void addroute(Route route);
	Route getOneRoute(int id);
	void updateRoute(Route route);
}
