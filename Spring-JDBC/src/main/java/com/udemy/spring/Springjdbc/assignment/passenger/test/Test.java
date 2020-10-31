package com.udemy.spring.Springjdbc.assignment.passenger.test;

import java.util.List;

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
		passenger.setPId(66);
		passenger.setFirstName("test");
		passenger.setLastName("google");
		
		Employee employee = new Employee();
		employee.setId(11);
		employee.setName("vvn");
		
		if (passengerDao.create(passenger,employee) ==1 ) {
			
			System.out.println("record inserted ");
		}
				
		else {
			System.out.println("record not inserted ");
		}		




	}
}
