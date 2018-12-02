package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping(value="/load")
	public String loadHtml(HttpSession session) {
		System.out.println("Inside Index....." +session+" ::::::::");
		session.setAttribute("uid", "amit");
		return "index";
	}
}
