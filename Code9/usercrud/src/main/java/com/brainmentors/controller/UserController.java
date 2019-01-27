package com.brainmentors.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brainmentors.UserService;
import com.brainmentors.models.User;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping(value="/")
	public String loadHome() {
		return "index";
	}
	@RequestMapping(value="/doregister",method=RequestMethod.POST)
	public String doRegister(HttpServletRequest request) {
		String userid = request.getParameter("userid");
		String password =request.getParameter("password");
		String name = request.getParameter("username");
		User userObject = new User();
		//userObject.setId(1001);
		userObject.setUserid(userid);
		userObject.setPassword(password);
		userObject.setName(name);
		String message = userService.add(userObject);
		request.setAttribute("msg", message);
		return "welcome";
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String loadRegister() {
		return "register";
	}
	
}
