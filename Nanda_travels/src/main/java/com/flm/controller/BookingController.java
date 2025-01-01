package com.flm.controller;

import java.util.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flm.dao.AgentDAO;
import com.flm.dao.BookingDAO;
import com.flm.dao.UserDAO;
import com.flm.model.Booking;
import com.flm.model.Route;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BookingController {
	
	@Autowired
	BookingDAO bookdao;
	
	@Autowired
	AgentDAO agentDao;

	@RequestMapping("/redirecttobooking")	
	public String redirecttobooking(HttpServletRequest request) {
		String id=request.getParameter("user_id");
		return "booking.jsp?user_id="+id;
	}
	
	@RequestMapping("/checkAvailability")
	public String checkAvailability(HttpServletRequest request,Model m) {
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		Booking bo=new Booking();
		bo.setUserId(user_id);
		bo.setSource(request.getParameter("source"));
		bo.setDestination(request.getParameter("dest"));
		bo.setDate(request.getParameter("date"));
		bo.setNumberOfSeatsRequired(Integer.parseInt(request.getParameter("num")));
		List<Route> routes=bookdao.getRoute(bo);
		if(routes.size()==0) {
			String message="No Buses are available in that route...!";
			return "booking.jsp?user_id="+user_id+"&msg="+message;
		}
		m.addAttribute("routes", routes);
		return "booking.jsp?user_id="+user_id+"&msg=Available Buses@seats="+bo.getNumberOfSeatsRequired();
//		Route available_route=dao.getRoute(bo);
//		bo.updateroute(available_route);
//		if(bo.getRouteId()==0) {
//			String message="No Buses are available in that route...!";
//			return "booking.jsp?user_id="+user_id+"&msg="+message;
//		}else if(bo.getNumberOfSeatsAvailable()<bo.getNumberOfSeatsRequired()) {
//			String message="No seats Available!!";
//			return "booking.jsp?user_id="+user_id+"&msg="+message;
//		}
//		Booking com_book=dao.bookticket(bo);
//		String message="Successfully Booked the ticket and the Booking ID is "+com_book.getBookingId();
//		return "booking.jsp?user_id="+user_id+"&msg="+message;
	}
	
	@RequestMapping("/conformbooking")
	public String conformbooking(HttpServletRequest request) {
		int route_id=Integer.parseInt(request.getParameter("route_id"));
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		int seatsRequired=Integer.parseInt(request.getParameter("route_id"));
		Route route=agentDao.getOneRoute(route_id);
		Booking book= bookdao.bookticket(route, user_id, seatsRequired);
		String message="Successfully Booked the ticket and the Booking ID is "+book.getBookingId();
		return "booking.jsp?user_id="+user_id+"&msg="+message;
	}
	
	
	@RequestMapping("/redirecttocancel")
	public String redirecttocancel(HttpServletRequest request) {
		String id=request.getParameter("user_id");
		System.out.println("'"+id+"'");
		return "cancel.jsp?user_id="+id;
	}
	
	@RequestMapping("/cancelbooking")
	public String cancelbooking(HttpServletRequest request,Model m) {
		int book_id=Integer.parseInt(request.getParameter("book_id"));
		int id=Integer.parseInt(request.getParameter("user_id"));
		Booking book=bookdao.getBookingDetails(book_id, id);
		bookdao.cancelBooking(book);
		m.addAttribute("booking", book);
		return "cancel.jsp?msg=Cancelled Successfully";
	}
	
	@RequestMapping("/redirecttoreshedule")
	public String redirecttoreshedule(HttpServletRequest request) {
		String id=request.getParameter("user_id");
		System.out.println("'"+id+"'");
		return "reschedule.jsp?user_id="+id;
	}
	
//	@RequestMapping("/reschedulebook")
//	public String reschedulebooking(HttpServletRequest request) {
//		int id=Integer.parseInt(request.getParameter("user_id"));
//		int book_id=Integer.parseInt(request.getParameter("book_id"));
//		String date=request.getParameter("date");
//		Booking book=dao.getBookingDetails(book_id, id);
//		Booking new_book=book;
//		new_book.setRouteId(0);
//		new_book.setDate(date);
//		Route available_route=dao.getRoute(new_book);
//		new_book.updateroute(available_route);
//		if(new_book.getRouteId()==0) {
//			String message="No Buses are available in that route...!";
//			return "reschedule.jsp?user_id="+id+"&msg="+message;
//		}else if(new_book.getNumberOfSeatsAvailable()<new_book.getNumberOfSeatsRequired()) {
//			String message="No seats Available!!";
//			return "reschedule.jsp?user_id="+id+"&msg="+message;
//		}
//		Booking com_book=dao.bookticket(new_book);
//		String message="Successfully Rescheduled the ticket and the Booking ID is "+com_book.getBookingId();
//		dao.cancelBooking(book);
//		return "reschedule.jsp?user_id="+id+"&msg="+message;
//	}
//	
	@RequestMapping("/redirecttomybookings")
	public String redirecttomybookings(HttpServletRequest request,Model m) {
		int id=Integer.parseInt(request.getParameter("user_id"));
		List<Booking> books=bookdao.getAllBookingDetails(id);
		m.addAttribute("books", books);
		return "MyBookings.jsp";
	}
	
}

