package com.srivastava.test;

import java.util.Scanner;

import com.srivastava.dao.EmployeeDAO;
import com.srivastava.entity.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Scanner scanner = new Scanner(System.in);
		while(true){
		System.out.println("1. Add");
		System.out.println("2. Delete");
		System.out.println("3. Find");
		System.out.println("4. Update");
		System.out.println("5. Exit");
		System.out.println("Enter Your Choice ");
		
		int choice = scanner.nextInt();
		scanner.nextLine();
		if(choice==1){
			/*System.out.println("Enter Empno");
			int empno = scanner.nextInt();
			scanner.nextLine();*/
			System.out.println("Enter Name");
			
			String name = scanner.nextLine();
			System.out.println("Enter Address");
			
			String address = scanner.nextLine();
			Employee employee = new Employee();
			//employee.setId(empno);
			employee.setName(name);
			employee.setAddress(address);
			String message = employeeDAO.add(employee);
			System.out.println(message);
		}
		else
		if(choice == 2){
			System.out.println("Enter the Empno to Delete");
			int empno = scanner.nextInt();
			String message = employeeDAO.delete(empno);
			System.out.println(message);
		}
		else
		if(choice == 3){
			System.out.println("Enter the Empno to Search");
			int empno = scanner.nextInt();
			Employee employee = employeeDAO.findById(empno);
			if(employee!=null){
				System.out.println("Employee Found... "+employee);
			}
			else {
				System.out.println("Employee Not found...");
			}
		}
		else
		if(choice == 4){
			System.out.println("Enter the Empno to Update");
			int empno = scanner.nextInt();
			String message = employeeDAO.update(empno);
			System.out.println(message);
		}
		else {
			System.out.println("Thanks for Using ");
			System.exit(0);
		}
			
		
		}
		
	}

}
