package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User user = null;
		
			user = new User();
			user.setUserid(rs.getString("userid"));
			user.setPassword(rs.getString("password"));
		
		return user;
	}

}
