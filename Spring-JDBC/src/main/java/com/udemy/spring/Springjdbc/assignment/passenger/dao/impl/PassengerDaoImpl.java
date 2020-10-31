package com.udemy.spring.Springjdbc.assignment.passenger.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.udemy.spring.Springjdbc.assignment.passenger.dao.PassengerDao;
import com.udemy.spring.Springjdbc.assignment.passenger.dto.Passenger;
import com.udemy.spring.Springjdbc.employee.dto.Employee;

import lombok.Data;

@Data
@Component("passengerDao")
public class PassengerDaoImpl implements PassengerDao {

	//	private JdbcTemplate jdbcTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Passenger passenger , Employee emp) {
		String sql = "insert into passenger values(?,?,?)";
		String sql1 = "insert into employee values(?,?,?)";
		int result = jdbcTemplate.update(sql, passenger.getPId(),passenger.getFirstName(),passenger.getLastName());
		int result1 = jdbcTemplate.update(sql1,emp.getId(),emp.getName(),passenger.getPId());
		return result;
		
		

	}
	


}
