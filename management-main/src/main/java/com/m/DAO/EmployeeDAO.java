package com.m.DAO;

import java.util.List;

import com.m.api.Employee;

public interface EmployeeDAO {

	List<Employee> loadEmployees();
	
	void saveEmployee(Employee emoployee);
	Employee getEmployee(int id);

	void update(Employee employee);

	void delete(int id);
	
}
