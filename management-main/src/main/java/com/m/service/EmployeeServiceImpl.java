package com.m.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m.DAO.EmployeeDAO;
import com.m.api.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public List<Employee> loadEmployees() {

		List<Employee> employeeList = employeeDAO.loadEmployees();
		
		return employeeList;
	}

	@Override
	public void saveEmployee(Employee employee) {

		if (employee.getCompany().equals("Amazon")) {
			
			//write email sending logic here
			
			System.out.println("Email sent to : " + employee.getName());
		}
		
		employeeDAO.saveEmployee(employee);
		
	}

	@Override
	public Employee getEmployee(int id) {
		
		return employeeDAO.getEmployee(id);
	}

	@Override
	public void update(Employee employee) {

		employeeDAO.update(employee);
		
	}

	@Override
	public void deleteEmployee(int id) {
		
		employeeDAO.delete(id);
		
	}

}
