package com.flm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;

import com.flm.model.Route;

@Controller
public class RouteRowMapper implements RowMapper<Route> {

	@Override
	public Route mapRow(ResultSet rs, int rowNum) throws SQLException {
		Route route=new Route();
		route.setRouteId(rs.getInt("route_id"));
		route.setNumberOfSeatsAvailable(rs.getInt("numseats"));
		route.setPriceOfEachTicket(rs.getInt("price"));
		route.setDate(rs.getString("date"));
		route.setDestination(rs.getString("destination"));
		route.setSource(rs.getString("source"));
		route.setBusName(rs.getString("busName"));
		return route;
	}

}
