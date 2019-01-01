package embeddemo;

import java.util.Date;

public class EmployeeDAOTest {

	
	public static void main(String[] args) {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.add(1001,"RAM", 90000.0, new Date());
		
		

	}

}
