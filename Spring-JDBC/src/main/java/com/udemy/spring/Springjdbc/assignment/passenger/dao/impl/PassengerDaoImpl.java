package com.udemy.spring.Springjdbc.assignment.passenger.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.udemy.spring.Springjdbc.assignment.employee.dao.rowmapper.EmployeeRowMapper;
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

		int pId = checkPID();
		int id = checkId();
		
		if (passenger.getPId() > pId && emp.getId()>id) {

			String sql = "insert into passenger values(?,?,?)";
			result = jdbcTemplate.update(sql, passenger.getPId(),passenger.getFirstName(),passenger.getLastName());
			value = passenger.getPId()+1;

			String sql1 = "insert into employee values(?,?,?)";
			result1 = jdbcTemplate.update(sql1,emp.getId(),emp.getName(),passenger.getPId());
		}else {
			String sql = "insert into passenger values(?,?,?)";
			result = jdbcTemplate.update(sql, pId+1,passenger.getFirstName(),passenger.getLastName());
			value = pId+2;

			String sql1 = "insert into employee values(?,?,?)";
			result1 = jdbcTemplate.update(sql1,id+1,emp.getName(),pId+1);
		}
		return value;



	}


	public int checkPID() {

		PassengerRowMapper row = new PassengerRowMapper();
		Passenger queryForObject = jdbcTemplate.queryForObject("select MAX(pId) last from Passenger", row);

		return queryForObject.getPId();

	}
	public int checkId() {

		EmployeeRowMapper row = new EmployeeRowMapper();
		Employee queryForObject = jdbcTemplate.queryForObject("select MAX(id) eid from Employee", row);

		return queryForObject.getId();

	}

}
