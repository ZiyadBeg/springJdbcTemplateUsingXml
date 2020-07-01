package com.nse.jdbc.daoImpl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nse.jdbc.dao.Dao;
import com.nse.jdbc.model.Employee;

public class DaoImpl implements Dao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Employee> fetchEmployeeDetails() {
		String SQL = "Select * from Employee";
		List<Employee> emplist = jdbcTemplate.query(SQL, new EmployeeRowMapper());
		return emplist;
	}

	@Override
	public Employee getEmployeeById(int empId) {
		String SQL = "Select * from Employee where empid=?";
		Employee emp = jdbcTemplate.queryForObject(SQL, new Object[] { empId }, new EmployeeRowMapper());
		return emp;
	}

	@Override
	public int insertEmployee(Employee emp) {
		String SQL = "insert into Employee(name,address,email) values(?,?,?)";
		int status = jdbcTemplate.update(SQL, emp.getName(), emp.getAddress(), emp.getEmail());
		return status;
	}

	@Override
	public int updateEmployee(Employee emp) {
		String SQL = "update employee set name=?,address=?,email=? where empid=?";
		int status = jdbcTemplate.update(SQL, emp.getName(), emp.getAddress(), emp.getEmail(),emp.getEmpid());
		return status;
	}

	@Override
	public int deleteEmployee(int empId) {
		String SQL = "Delete from Employee where empid=?";
		//return jdbcTemplate.update(SQL,empId);
		return jdbcTemplate.update(SQL,new Object[]{empId});
	}

}
