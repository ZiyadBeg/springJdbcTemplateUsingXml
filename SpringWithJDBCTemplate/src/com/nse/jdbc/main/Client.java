package com.nse.jdbc.main;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nse.jdbc.model.Employee;
import com.nse.jdbc.service.Service;
import com.nse.jdbc.serviceImpl.ServiceImpl;

public class Client {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");

		Service employeeService = ctx.getBean("empService", ServiceImpl.class);
		Employee emp = new Employee();
		emp.setEmpid(3);
		emp.setName("Humera");
		emp.setAddress("DIVA");
		emp.setEmail("humera@gmail.com");

		// getallEmployeeDetails(employeeService);
		// getEmployeeById(employeeService);
		// insertedIntoEmployee(employeeService,emp);
		// updateEmployeeDetails(employeeService, emp);
		//deleteEmployee(employeeService);
	}

	private static void deleteEmployee(Service employeeService) {
		int status = employeeService.deleteEmployee(1);
		if (status > 0) {
			System.out.println("Deleted");
		} else {
			System.out.println("Not Deleted");
		}
	}

	private static void updateEmployeeDetails(Service employeeService, Employee emp) {
		int status = employeeService.updateEmployee(emp);
		if (status > 0) {
			System.out.println("Updated ");
		} else {
			System.out.println("Not Updated");
		}
	}

	private static void insertedIntoEmployee(Service employeeService, Employee emp) {

		int status = employeeService.createEmployee(emp);
		if (status > 0) {
			System.out.println("Interested");
		} else {
			System.out.println("Not Interested");
		}
	}

	private static void getEmployeeById(Service employeeService) {
		Employee employee = employeeService.getEmployeeById(1);

		System.out.println("GetEmployeeById::: " + employee.getEmpid() + "\t" + employee.getName() + "\t"
				+ employee.getAddress() + "\t" + employee.getEmail());
	}

	private static void getallEmployeeDetails(Service employeeService) {
		List<Employee> emp = employeeService.fetchEmployee();
		for (Employee employee : emp) {
			System.out.println(employee.getEmpid() + "\t" + employee.getName() + "\t" + employee.getAddress() + "\t"
					+ employee.getEmail());
		}
	}
}
