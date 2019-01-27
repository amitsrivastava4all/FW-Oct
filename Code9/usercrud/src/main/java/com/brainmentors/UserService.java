package com.brainmentors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainmentors.dao.UserDAO;
import com.brainmentors.models.User;

@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;
	public String add(User userObject) {
		System.out.println("Before Save");
		userDAO.save(userObject);
		
		System.out.println("After Save");
		return "Record Added";
	}
}
