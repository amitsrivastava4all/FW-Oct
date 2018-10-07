package com.srivastava.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Helper {
	@Autowired
	@Qualifier("dao2")
	IDAO dao;
	
	// Constructor Injection
	@Autowired
	public Helper(DAO3 dao3) {
		System.out.println("HELPER Calling Dao 3 Called...");
		dao3.dao3();
	}
	
	
	public EmpDO callDB() {
		return dao.db();
	}

}
