package com.srivastava.clients;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srivastava.apps.A;
import com.srivastava.apps.Employee;
import com.srivastava.apps.IProducer;
class W<T>{
	T x;
	T y;
	W(T x , T y){
		this.x = x;
		this.y = y;
	}
	void show() {
		System.out.println(" x is "+x+" Y is "+y);
	}
}
public class Consumer {
	public static void main(String[] args) {
		W<String> w1 = new W<>("hello","ok");
		w1.show();
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		System.out.println("Context is Loaded....");
//		IProducer producer = (IProducer)context.getBean("prod");
//		//IProducer producer2 = (IProducer)context.getBean("prod");
//		//System.out.println("Ref "+(producer==producer2));
//		int result = producer.add(100, 200);
//		System.out.println("Add is "+result);
//		System.out.println("Message is "+producer.getMessage());
//		Employee emp = (Employee)context.getBean("emp");
//		System.out.println(emp);
//		Employee emp2 = (Employee)context.getBean("emp");
//		System.out.println(emp2==emp);
		//A a1 = context.getBean("a",A.class);
		A a = (A) context.getBean("a");
		System.out.println(a.getZZ());
		System.out.println(a.getZZ().getName());
		
	}

}
