package com.udemy.spring.Springjdbc.assignment.passenger.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.udemy.spring.Springjdbc.assignment.passenger.dao.PassengerDao;
import com.udemy.spring.Springjdbc.assignment.passenger.dao.rowmapper.PassengerRowMapper;
import com.udemy.spring.Springjdbc.assignment.passenger.dto.Passenger;
import com.udemy.spring.Springjdbc.assignment.passenger.exception.PassengerException;
import com.udemy.spring.Springjdbc.employee.dto.Employee;

import lombok.Data;

@Data
@Component("passengerDao")
public class PassengerDaoImpl implements PassengerDao {

	//	private JdbcTemplate jdbcTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public synchronized int create(Passenger passenger , Employee emp) {
		int value = 0;
		int result = 0;
		int result1 = 0;
			
		int cId = passenger.getPId()+1;

				try {
					String sql = "insert into passenger values(?,?,?)";
					 result = jdbcTemplate.update(sql, passenger.getPId(),passenger.getFirstName(),passenger.getLastName());
					 value = passenger.getPId()+1;
					 
				}catch (Exception e) {
					String sql = "insert into passenger values(?,?,?)";
					 result = jdbcTemplate.update(sql,cId,passenger.getFirstName(),passenger.getLastName());
					 value = cId+1;
				}
		try {
			String sql1 = "insert into employee values(?,?,?)";
			result1 = jdbcTemplate.update(sql1,emp.getId(),emp.getName(),passenger.getPId());

		}catch (Exception e) {
			String sql1 = "insert into employee values(?,?,?)";
			result1 = jdbcTemplate.update(sql1,emp.getId()+1,emp.getName(),cId);
		}

		return value;



	}



}
