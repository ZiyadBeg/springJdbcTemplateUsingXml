package com.nse.jdbc.dao;

import java.util.List;

import com.nse.jdbc.model.Employee;

public interface Dao {
	
	public abstract int insertEmployee(Employee emp);
	public abstract List<Employee> fetchEmployeeDetails();
	public abstract int updateEmployee(Employee emp);
	public abstract int deleteEmployee(int empId);
	public abstract Employee getEmployeeById(int empId);
}
