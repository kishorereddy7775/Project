package com.flm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flm.dao.BookingDAO;
import com.flm.dao.UserDAO;
import com.flm.model.Booking;
import com.flm.model.Route;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BookingController {
	
	@Autowired
	BookingDAO dao;

	@RequestMapping("/redirecttobooking")	
	public String redirecttobooking(HttpServletRequest request) {
		String id=request.getParameter("user_id");
		System.out.println("Inside redirect controller");
		System.out.println("'"+id+"'");
		return "booking.jsp?user_id="+id;
	}
	
	@RequestMapping("/checkAvailability")
	public String checkAvailability(HttpServletRequest request) {
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		Booking bo=new Booking();
		bo.setUserId(user_id);
		bo.setSource(request.getParameter("source"));
		bo.setDestination(request.getParameter("dest"));
		bo.setDate(request.getParameter("date"));
		bo.setNumberOfSeatsRequired(Integer.parseInt(request.getParameter("num")));
		Route available_route=dao.getRoute(bo);
		bo.updateroute(available_route);
		if(bo.getRouteId()==0) {
			String message="No Buses are available in that route...!";
			return "booking.jsp?user_id="+user_id+"&msg="+message;
		}else if(bo.getNumberOfSeatsAvailable()<bo.getNumberOfSeatsRequired()) {
			String message="No seats Available!!";
			return "booking.jsp?user_id="+user_id+"&msg="+message;
		}
		Booking com_book=dao.bookticket(bo);
		String message="Successfully Booked the ticket and the Booking ID is "+com_book.getBookingId();
		return "booking.jsp?user_id="+user_id+"&msg="+message;
	}
	
}
