package com.srivastava.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("dao")
@Primary
public class DAO implements IDAO{
	@Autowired
	EmpDO empDO;
	
	@Override
	public EmpDO db() {
		empDO.setId(1001);
		empDO.setName("Ram");
		return empDO;
	}

}
