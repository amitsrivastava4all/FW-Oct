package springaopexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srivastava.apps.Employee;

public class Caller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		Employee emp = (Employee)ac.getBean("employee");
		emp.print();
		System.out.println("**********************");
		emp.show();
	}

}
