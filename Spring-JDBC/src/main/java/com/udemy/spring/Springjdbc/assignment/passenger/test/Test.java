package com.udemy.spring.Springjdbc.assignment.passenger.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.udemy.spring.Springjdbc.assignment.passenger.dao.PassengerDao;
import com.udemy.spring.Springjdbc.assignment.passenger.dto.Passenger;
import com.udemy.spring.Springjdbc.employee.dto.Employee;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/udemy/spring/Springjdbc/assignment/passenger/test/config.xml");
		PassengerDao passengerDao = (PassengerDao) context.getBean("passengerDao");
		Passenger passenger = new Passenger();
		passenger.setPId(3);
		passenger.setFirstName("test");
		passenger.setLastName("google");
		
		Employee employee = new Employee();
		employee.setId(5);
		employee.setName("vvn");
		
		int genId = passengerDao.create(passenger,employee);
		
		
		if (genId >= passenger.getPId() ) {
			
			System.out.println("record inserted ");
			System.out.println("the returned id :"+genId);
		}
				
		else {
			System.out.println("record not inserted ");
		}		

		
		

	}
}
