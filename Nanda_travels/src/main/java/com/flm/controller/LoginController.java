package com.flm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flm.dao.UserDAO;
import com.flm.model.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	
	@Autowired
	UserDAO dao;
	
	@RequestMapping("/redirectLogin")
	public String redirectLogin() {
		return "Login.jsp";
	}
	
	@RequestMapping("/redirecttoUnlock")
	public String redirecttoUnlock() {
		return "Unlock.jsp";
	}
	
	@RequestMapping("/UnlockAccount")
	public String UnlockAccount(HttpServletRequest request) {
		String username=request.getParameter("mail");
		dao.activateUser(username);
		return "Unlock.jsp?msg=Account Unlocked Successfully!!";
	}
	
	public String LoginValidationHelper(String url,String username,String password) {
		User user=dao.getOneUser(username);
		if(user.getActiveStatus().equals("I")) {
			return url+"?msg=Account Locked";
		}
		else if(!(user.getPassword().equalsIgnoreCase(password))) {
			int attempt_remaining=3-(user.getFailedCount()+1);
			if(user.getFailedCount()>=2) {
				dao.inActivateUser(username);
				return url+"?msg=Account Locked";
			}else {
				dao.updateFailedCount(username, user.getFailedCount()+1);
				return url+"?msg=Invalid Password&num="+attempt_remaining;
			}
		}
		return null;
	}
	
	@RequestMapping("/LoginValidation")
	public String LoginValidation(HttpServletRequest request, Model m) {
		String username=request.getParameter("mail");
		String password=request.getParameter("password");
		User user=dao.getOneUser(username);
		String login=LoginValidationHelper("Login.jsp",username,password);
		if(login!=null)
			return login;
		m.addAttribute("user", user);
		return "MainPage.jsp?user_id="+user.getUser_id();
	}
	
	
	@RequestMapping("/redirecttoMainPage")
	public String redirecttoMainPage(HttpServletRequest request,Model m) {
		int id=Integer.parseInt(request.getParameter("user_id"));
		User user=dao.getOneUser(id);
		m.addAttribute("user", user);
		return "MainPage.jsp?user_id="+id;
	}
	
	@RequestMapping("/redirecttosignup")
	public String redirecttosignup() {
		return "signup.jsp";
	}
	
	@RequestMapping("/signup")
	public String signup(HttpServletRequest request) {
		User us=new User();
		us.setFirstName(request.getParameter("fname"));
		us.setLastName(request.getParameter("lname"));
		us.setMobileNumber(request.getParameter("mnumber"));
		us.setGender(request.getParameter("gender"));
		us.setEmail(request.getParameter("mail"));
		us.setPassword(request.getParameter("pass"));
		dao.insertuser(us);
		return "Login.jsp?msg=Signup Successfull!!";
	}
	
	@RequestMapping("/AgentLoginValidation")
	public String AgentLoginValidation(HttpServletRequest request, Model m) {
		String username=request.getParameter("mail");
		String password=request.getParameter("password");
		User user=dao.getOneUser(username);
		String login=LoginValidationHelper("AgentLogin.jsp",username,password);
		if(login!=null)
			return login;
		return "AgentMainPage.jsp?name="+user.getFirstName()+"&user_id="+user.getUser_id();
	}
	
	@RequestMapping("/redirectAgentLogin")
	public String redirectAgentLogin() {
		return "AgentLogin.jsp";
	}
	
}
