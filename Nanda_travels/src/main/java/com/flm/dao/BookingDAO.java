package com.flm.dao;

import java.util.List;

import com.flm.model.Booking;
import com.flm.model.Route;

public interface BookingDAO {
	List<Route> getRoute(Booking book);
	Booking bookticket(Route route,int user_id, int seatsRequired);
	Booking getBookingDetails(int booking_id, int user_id);
	void cancelBooking(Booking bo);
	List<Booking> getAllBookingDetails(int user_id);
}
