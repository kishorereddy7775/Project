package com.flm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.flm.model.Route;
import com.flm.model.User;

@Component
public class AgentDAOImpl implements AgentDAO {

	String getAllUsers="Select * from user";
	String getAllRoutes="select * from route";
	String getOneRoute="select * from route where route_id=?";
	String addRoute="insert into route(source,destination,date,numseats,price,busName) values (?,?,?,?,?,?)";
	String updateRoute="update route set source=?,destination=?,date=?,numseats=?,price=?,busName=? where route_id=?";
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	UserRowMapper userMapper;
	
	@Autowired
	RouteRowMapper routeMapper;
	
	@Override
	public List<User> getUsers() {
		List<User> users=jdbcTemplate.query(getAllUsers, userMapper);
		return users;
	}

	@Override
	public List<Route> getAllroute() {
		List<Route> routes=jdbcTemplate.query(getAllRoutes, routeMapper);
		return routes;
	}

	@Override
	public void addroute(Route route) {
		jdbcTemplate.update(addRoute,route.getSource(),route.getDestination(),route.getDate(),route.getNumberOfSeatsAvailable(),route.getPriceOfEachTicket(),route.getBusName());
	}

	@Override
	public Route getOneRoute(int id) {
		List<Route> routes=jdbcTemplate.query(getOneRoute, routeMapper,id);
		return routes.get(0);
	}

	@Override
	public void updateRoute(Route route) {
		jdbcTemplate.update(updateRoute,route.getSource(),route.getDestination(),route.getDate(),route.getNumberOfSeatsAvailable(),route.getPriceOfEachTicket(),route.getBusName(),route.getRouteId());
	}


}
