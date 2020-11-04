package com.udemy.spring.Springjdbc.assignment.employee.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.udemy.spring.Springjdbc.employee.dto.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setId(rs.getInt(1));
//		emp.setName(rs.getString(2));
//		emp.setPId(rs.getInt(3));
		return emp;
	}

}
