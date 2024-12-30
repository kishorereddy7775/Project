package com.flm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.flm.model.Booking;
import com.flm.model.Route;

@Component
public class BookingDAOImpl implements BookingDAO {
	
	String getroute="Select route_id,numseats,price from route where source=? and destination=? and date=?";
	String InsertBooking="insert into bookings (user_id,route_id,seatsbooked,amountpaid) values (?,?,?,?)";
	String UpdateRoute="Update route set numseats=? where route_id=?";
	String getbook="select booking_id from bookings where user_id=? and route_id=?";
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	RouteRowMapper routeMapper;
	
	@Autowired
	BookingRowMapper bookingMapper;
	
	@Override
	public Route getRoute(Booking book) {
		List<Route> routes=jdbcTemplate.query(getroute,routeMapper,book.getSource(),book.getDestination(),book.getDate());
		if(routes.size()==0)
			return new Route();
		return routes.get(0);
	}

	@Override
	public Booking bookticket(Booking book) {
		jdbcTemplate.update(InsertBooking,book.getUserId(),book.getRouteId(),book.getNumberOfSeatsRequired(),book.getNumberOfSeatsRequired()*book.getPriceOfEachTicket());
		jdbcTemplate.update(UpdateRoute,book.getNumberOfSeatsAvailable()-book.getNumberOfSeatsRequired(),book.getRouteId());
		List<Booking> books=jdbcTemplate.query(getbook,bookingMapper,book.getUserId(),book.getRouteId());
		return books.get(0);
	}
	

}
