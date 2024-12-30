package com.flm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.flm.model.Booking;

@Component
public class BookingRowMapper implements RowMapper<Booking>{

	@Override
	public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
		Booking bo=new Booking();
		bo.setBookingId(rs.getInt("booking_id"));
		return bo;
	}

}
