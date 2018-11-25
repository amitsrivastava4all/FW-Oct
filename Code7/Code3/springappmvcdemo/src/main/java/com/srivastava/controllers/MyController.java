package com.srivastava.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@Autowired
	DAO dao;
	
	@RequestMapping(value="/login2",method=RequestMethod.POST)
	public String doLogin2(@ModelAttribute("user") User user,HttpSession session) {
		User userObject = dao.getOne(user);
		if(userObject!=null && userObject.getUserid()!=null && userObject.getUserid().trim().length()>0) {
			user.setMessage("Welcome "+user.getUserid());
			session.setAttribute("uid", user.getUserid());
			System.out.println("Session is "+session.getAttribute("uid"));
		}
		else {
			user.setMessage("Invalid Userid or Password");
		}
		/*if(user.getUserid().equals(user.getPwd())) {
			user.setMessage("Welcome "+user.getUserid());
			session.setAttribute("uid", user.getUserid());
			System.out.println("Session is "+session.getAttribute("uid"));
		}
		else {
			user.setMessage("Invalid Userid or Password");
		}*/
		System.out.println("User "+user);
		return "welcome";
	}
	
	@RequestMapping(value="/home")
	public String loadHome(Model model) {
		model.addAttribute("msg", "Hello Spring MVC Demo");
		System.out.println("Inside Home "+model );
		return "index";
	}
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public ModelAndView doLogin(@RequestParam("userid") String userid, @RequestParam("pwd") String password) {
		System.out.println("Userid "+userid+" Password "+password);
		String message = "";
		if(userid.equals(password)) {
			message = "Welcome "+userid;
		}
		else {
			message="Invalid Userid or Password";
		}
		return new ModelAndView("welcome", "msg",message);
	}
}
