package com.udemy.spring.Springjdbc.assignment.passenger.dao;

import com.udemy.spring.Springjdbc.assignment.passenger.dto.Passenger;
import com.udemy.spring.Springjdbc.employee.dto.Employee;

public interface PassengerDao {
	int create(Passenger passenger,Employee emp);
}
