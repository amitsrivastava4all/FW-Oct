package com.srivastava.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public User getOne(User user) {
		try {
		return jdbcTemplate.queryForObject("select * from user_mst where userid=? and password=?", new RowMapper<User>() {

			
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User userDTO = new User();
				userDTO.setUserid(rs.getString("userid"));
				userDTO.setPwd(rs.getString("password"));
				return userDTO;
			}
			
		},user.getUserid(),user.getPwd());
		}
		catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	

}
