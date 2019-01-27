package com.srivastava.basics;

import java.util.Date;

public class EmployeeDAOTest {

	
	public static void main(String[] args) throws InterruptedException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		int id = 3300;
		String name[]={"Ram","Shyam","Sohan","Mohan","Tim","Kim","Rim","Sim","Gim","Bim"};
		
		for(int i= 0; i<=9; i++,id++){
			employeeDAO.add(id, name[i], 9000*(i+1), new Date());
			
		}
		
		employeeDAO.find("9000 or 1=1");
		System.out.println("Using the Pagination ");
		employeeDAO.pagination();
		System.out.println("Get the Map ");
		employeeDAO.getMap();
		System.out.println("Get the List of Names");
		employeeDAO.getNameList();
		System.out.println("Get Max Salary");
		employeeDAO.getMaxSalary();
		System.out.println("SQL Injection Demo");
		employeeDAO.sqlInjection();
		System.out.println("Position parameter Binding");
		employeeDAO.parameterBinding();
		System.out.println("Named Parameter Binding");
		employeeDAO.namedParameterBinding();
		

	}

}
