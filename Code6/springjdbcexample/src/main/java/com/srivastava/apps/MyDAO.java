package com.srivastava.apps;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MyDAO {
	@Autowired
private JdbcTemplate jdbcTemplate;
	
	public void add(String userid, String pwd) {
		
		String result = jdbcTemplate.update("insert into user_mst(userid,password) values(?,?)",userid,pwd)>0?"Added":"Not Added";
	System.out.println("Result "+result);
	}
	
	public UserDTO getOne() {
		return jdbcTemplate.queryForObject("select * from user_mst where uid=?", new RowMapper<UserDTO>() {

			@Override
			public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				UserDTO userDTO = new UserDTO();
				userDTO.setUserid(rs.getString("userid"));
				userDTO.setPassword(rs.getString("password"));
				return userDTO;
			}
			
		},1);
	}
	
	public List<UserDTO> getAll(){
		return jdbcTemplate.query("select * from user_mst",new RowMapper<UserDTO>() {

			@Override
			public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				UserDTO userDTO = new UserDTO();
				userDTO.setUserid(rs.getString("userid"));
				userDTO.setPassword(rs.getString("password"));
				return userDTO;
			}
			
		});
	}
}
