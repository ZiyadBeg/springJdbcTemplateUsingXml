package com.nse.jdbc.service;

import java.util.List;

import com.nse.jdbc.model.Employee;

public interface Service {

	public abstract int createEmployee(Employee emp);
	public abstract List<Employee> fetchEmployee();
	public abstract int updateEmployee(Employee emp);
	public abstract int deleteEmployee(int empId);
	public abstract Employee getEmployeeById(int empId);
}
