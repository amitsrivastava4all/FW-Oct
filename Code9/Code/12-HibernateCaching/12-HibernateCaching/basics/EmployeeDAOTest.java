package com.srivastava.basics;

import java.util.Date;

public class EmployeeDAOTest {

	
	public static void main(String[] args) {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		int id = 1000;
		String name[]={"Ram","Shyam","Sohan","Mohan","Tim","Kim","Rim","Sim","Gim","Bim"};
		for(int i= 0; i<=9; i++,id++){
			employeeDAO.add(id, name[i], 9000*(i+1), new Date());
		}
		employeeDAO.firstLevelCache();
		employeeDAO.secondLevelCache();
		employeeDAO.secondLevelQueryCache();

	}

}
