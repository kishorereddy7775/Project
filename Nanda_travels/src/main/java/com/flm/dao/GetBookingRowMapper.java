package com.flm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.flm.model.Booking;

@Component
public class GetBookingRowMapper implements RowMapper<Booking> {

	@Override
	public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
		Booking bo=new Booking();
		bo.setBookingId(rs.getInt("booking_id"));
		bo.setUserId(rs.getInt("user_id"));
		bo.setRouteId(rs.getInt("route_id"));
		bo.setNumberOfSeatsRequired(rs.getInt("seatsbooked"));
		bo.setNumberOfSeatsAvailable(rs.getInt("numseats"));
		bo.setPriceOfEachTicket(rs.getInt("price"));
		bo.setSource(rs.getString("source"));
		bo.setDestination(rs.getString("destination"));
		bo.setDate(rs.getString("date"));
		return bo;
	}

}
