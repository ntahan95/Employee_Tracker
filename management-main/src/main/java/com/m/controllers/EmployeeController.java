package com.m.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m.api.Employee;
import com.m.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String handleIndex(Model model) {
		
		return "redirect:/showEmployee";
	}
	
	/**
	 * Passes information loaded from the database to the page
	 * @param model
	 * @return
	 */
	@GetMapping("/showEmployee")
	public String showEmployeeList(Model model) {
		
		// call service to get the data here
		
		List<Employee> employeeList = employeeService.loadEmployees();
		
		model.addAttribute("employees", employeeList);
		
		return "employee-list";
	}
	
	/**
	 * Present the add feature to enter a new entry to the database
	 * @param model
	 * @return
	 */
	@GetMapping("/showAddEmployee")
	public String addEmployee(Model model) {
		
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		
		return "add-employee";
	}
	
	@PostMapping("/save-employee")
	public String saveEmployee(Employee employee) {		
		
		System.out.println(employee);
		
		// if employee doesn't have an id save it, otherwise we will update it
		if (employee.getId() == 0) {
			employeeService.saveEmployee(employee);
		} else {
			// do a service call to update the employee
			employeeService.update(employee);
		}
		

		
		return "redirect:/showEmployee";
	}
	
	
	/**
	 * Present the add feature to enter a update to the database
	 * @param model
	 * @return
	 */
	@GetMapping("/updateEmployee")
	public String updateEmployee(@RequestParam("userId") int id, Model model) {
		
		// display employee data here to be updated
		System.out.println("Looking up the data for the employee for employee id: " + id);
		
		Employee employeeData = employeeService.getEmployee(id);
		System.out.println(employeeData);
		
		model.addAttribute("employee", employeeData);

		return "add-employee";
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("userId") int id) {
		
		// capture the id of the record to be deleted
		// after record id is captured, do a service call to delete it
		
		employeeService.deleteEmployee(id);

		return "redirect:/showEmployee";
	}
	
	
}
