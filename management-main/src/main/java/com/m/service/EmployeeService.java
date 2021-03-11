package com.m.service;

import java.util.List;

import com.m.api.Employee;

public interface EmployeeService {

	List<Employee> loadEmployees();

	void saveEmployee(Employee employee);

	Employee getEmployee(int id);

	void update(Employee employee);

	void deleteEmployee(int id);

}
