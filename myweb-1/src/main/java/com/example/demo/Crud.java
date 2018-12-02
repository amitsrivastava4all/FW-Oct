package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class Crud {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public List<User> getUsers(String ...arg){
		
		if(arg!=null && arg.length==0) {
		return jdbcTemplate.query("select * from user_mst", 
				new Object[] {}, new UserRowMapper());
		}
		else if(arg!=null && arg.length>0) {
			System.out.println("Arg is "+arg[0]);
			
			return jdbcTemplate.query("select * from user_mst where userid=?", 
					new Object[] {arg[0]}, new UserRowMapper());
		}
		return null;
	}

}
