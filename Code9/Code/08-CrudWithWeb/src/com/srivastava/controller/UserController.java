package com.srivastava.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srivastava.dao.UserDAO;
import com.srivastava.domainobject.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/usercontroller")
public class UserController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("email");
		String password = request.getParameter("pwd");
		String operation = request.getParameter("operation");
		String message = "";
		if("add".equals(operation)){
			User userObject = new User();
			userObject.setUserid(userid);
			userObject.setPassword(password);
			UserDAO userDAO = new UserDAO();
			if(userDAO.addUser(userObject)){
				message = "User Added SuccessFully...";
			}
			else
			{
				message = "Error in New User Addition ";
			}
		}
	}

}
