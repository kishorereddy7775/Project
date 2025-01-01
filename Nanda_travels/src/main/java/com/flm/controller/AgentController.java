package com.flm.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.flm.dao.AgentDAO;
import com.flm.dao.UserDAO;
import com.flm.model.Route;
import com.flm.model.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AgentController {
	
	@Autowired
	AgentDAO agentdao;
	
	@Autowired
	UserDAO userdao;
	
	@RequestMapping("/redirecttoAgentMainPage")
	public String redirecttoAgentMainPage() {
		return "AgentMainPage.jsp";
	}
	
	@RequestMapping("/redirecttoManageUsers")
	public String redirecttoManageUsers(Model m) {
		List<User> users=agentdao.getUsers();
		m.addAttribute("users", users);
		return "ManageUsers.jsp";
	}
	
	@RequestMapping("/InactivateUser")
	public void deleteUser(HttpServletRequest request, HttpServletResponse response , Model m) throws IOException {
		String username=request.getParameter("email");
		userdao.inActivateUser(username);
		response.sendRedirect("redirecttoManageUsers");
	}
	
	@RequestMapping("/redirecttoManageRoutes")
	public String redirecttoManageRoutes(Model m) {
		List<Route> routes=agentdao.getAllroute();
		m.addAttribute("routes", routes);
		return "ManageRoutes.jsp";
	}
	
	
	@RequestMapping("/redirecttoAddroute")
	public String redirecttoAddroute() {
		return "AddRoute.jsp";
	}
	
	@RequestMapping("/saveRoute")
	public void saveRoute(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Route route=new Route();
		route.setSource(request.getParameter("source"));
		route.setDestination(request.getParameter("destination"));
		route.setDate(request.getParameter("date"));
		route.setNumberOfSeatsAvailable(Integer.parseInt(request.getParameter("seats")));
		route.setPriceOfEachTicket(Integer.parseInt(request.getParameter("price")));
		route.setBusName(request.getParameter("busName"));
		agentdao.addroute(route);
		response.sendRedirect("redirecttoManageRoutes");
	}
	
	@RequestMapping("/redirecttoeditroute")
	public String redirecttoeditroute(HttpServletRequest request,Model m) {
		int route_id=Integer.parseInt(request.getParameter("route_id"));
		Route route=agentdao.getOneRoute(route_id);
		m.addAttribute("route", route);
		return "EditRoute.jsp";
	}
	
	@RequestMapping("/editRoute")
	public void editRoute(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Route route=new Route();
		route.setSource(request.getParameter("source"));
		route.setDestination(request.getParameter("destination"));
		route.setDate(request.getParameter("date"));
		route.setNumberOfSeatsAvailable(Integer.parseInt(request.getParameter("seats")));
		route.setPriceOfEachTicket(Integer.parseInt(request.getParameter("price")));
		route.setRouteId(Integer.parseInt(request.getParameter("route_id")));
		route.setBusName(request.getParameter("busName"));
		agentdao.updateRoute(route);
		response.sendRedirect("redirecttoManageRoutes");
	}
}

