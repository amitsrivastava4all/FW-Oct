package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyWs {
	@Autowired
	Crud crud;
	@RequestMapping(value="/users")
	public Map<String, List<User>> getUsers() {
		//return crud.getUsers(); 
		Map<String,List<User>> map = new HashMap<>();
		map.put("users",crud.getUsers());
		return map;
	}
	@RequestMapping(value="/welcome/{userid}")
	public Map<String, List<User>> getUsers2(@PathVariable("userid") String userid) {
		System.out.println("Userid is "+userid);
		Map<String,List<User>> map = new HashMap<>();
		map.put("users",crud.getUsers(userid));
		return map;
		//return crud.getUsers(userid); 
	}
}
