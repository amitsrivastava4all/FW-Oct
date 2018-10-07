package com.srivastava.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dao2")
public class DAO2 implements IDAO{

	@Autowired
	EmpDO empDO;
	
	@Override
	public EmpDO db() {
		empDO.setId(1002);
		empDO.setName("Shyam");
		return empDO;
	}

}
