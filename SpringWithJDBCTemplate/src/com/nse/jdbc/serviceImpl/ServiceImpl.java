package com.nse.jdbc.serviceImpl;

import java.util.List;

import com.nse.jdbc.dao.Dao;
import com.nse.jdbc.model.Employee;
import com.nse.jdbc.service.Service;

public class ServiceImpl implements Service {

	private Dao employeeDAO;

	public void setEmployeeDAO(Dao employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public int createEmployee(Employee emp) {
		return  employeeDAO.insertEmployee(emp);
		
	}

	@Override
	public List<Employee> fetchEmployee() {
		return employeeDAO.fetchEmployeeDetails();
	}

	@Override
	public int updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeDAO.updateEmployee(emp);
	}

	@Override
	public int deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		return employeeDAO.deleteEmployee(empId);
	}

	@Override
	public Employee getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployeeById(empId);
	}

}
