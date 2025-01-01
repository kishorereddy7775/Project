package com.flm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.flm.model.Booking;
import com.flm.model.Route;

@Component
public class BookingDAOImpl implements BookingDAO {
	
	String getroute="Select * from route where source=? and destination=? and date=?";
	String InsertBooking="insert into bookings (user_id,route_id,seatsbooked,amountpaid) values (?,?,?,?)";
	String UpdateRoute="Update route set numseats=? where route_id=?";
	String getbook="select booking_id from bookings where user_id=? and route_id=?";
	String getbookwithbookid="select * from bookings inner join route on bookings.route_id=route.route_id where user_id=? and booking_id=?";
	String getbookwithuser_id="select * from bookings inner join route on bookings.route_id=route.route_id where user_id=?";
	String cancelbook1="update route set numseats=? where route_id=?";
	String cancelbook2="Delete from bookings where booking_id=?";
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	RouteRowMapper routeMapper;
	
	@Autowired
	BookingIDRowMapper bookingMapper;
	
	@Autowired
	GetBookingRowMapper getbookMapper;
	
	@Override
	public List<Route> getRoute(Booking book) {
		List<Route> routes=jdbcTemplate.query(getroute,routeMapper,book.getSource(),book.getDestination(),book.getDate());
		return routes;
	}

	@Override
	public Booking bookticket(Route route,int user_id, int seatsRequired) {
		jdbcTemplate.update(InsertBooking,user_id,route.getRouteId(),seatsRequired,seatsRequired*route.getPriceOfEachTicket());
		jdbcTemplate.update(UpdateRoute,route.getNumberOfSeatsAvailable()-seatsRequired,route.getRouteId());
		List<Booking> books=jdbcTemplate.query(getbook,bookingMapper,user_id,route.getRouteId());
		return books.get(books.size()-1);
	}

	@Override
	public Booking getBookingDetails(int booking_id, int user_id) {
		List<Booking> books=jdbcTemplate.query(getbookwithbookid, getbookMapper,user_id,booking_id);
		return books.get(books.size()-1);
	}

	@Override
	public List<Booking> getAllBookingDetails(int user_id) {
		List<Booking> books=jdbcTemplate.query(getbookwithuser_id, getbookMapper,user_id);
		return books;
	}
	@Override
	public void cancelBooking(Booking bo) {
		int newseats=bo.getNumberOfSeatsAvailable()+bo.getNumberOfSeatsRequired();
		jdbcTemplate.update(cancelbook1,newseats,bo.getRouteId());
		jdbcTemplate.update(cancelbook2,bo.getBookingId());
	}
	
	
	
	

}
