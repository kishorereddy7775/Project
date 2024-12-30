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
	
	@RequestMapping("/LoginValidation")
	public String LoginValidation(HttpServletRequest request, Model m) {
		String username=request.getParameter("mail");
		String password=request.getParameter("password");
		User user=dao.getOneUser(username);
		if(user.getActiveStatus().equals("I")) {
			return "Login.jsp?msg=Account Locked";
		}
		else if(!(user.getPassword().equalsIgnoreCase(password))) {
			int attempt_remaining=3-(user.getFailedCount()+1);
			if(user.getFailedCount()>=2) {
				dao.inActivateUser(username);
				return "Login.jsp?msg=Account Locked";
			}else {
				dao.updateFailedCount(username, user.getFailedCount()+1);
				return "Login.jsp?msg=Invalid Password&num="+attempt_remaining;
			}
		}
		return "MainPage.jsp?name="+user.getFirstName()+"&user_id="+user.getUser_id();
	}
	
	@RequestMapping("/redirecttoMainPage")
	public String redirecttoMainPage(HttpServletRequest request) {
		String id=request.getParameter("user_id");
		return "MainPage.jsp?user_id="+id;
	}
}
