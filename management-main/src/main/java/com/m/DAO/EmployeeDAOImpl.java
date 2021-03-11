package com.m.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.m.api.Employee;
import com.m.rowmapper.EmployeeRowMapper;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	/**
	 * Load data from the database
	 */
	@Override
	public List<Employee> loadEmployees() {
		
		String sql = "SELECT * FROM employees";
		List<Employee> employee = jdbcTemplate.query(sql, new EmployeeRowMapper());

		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {

		// logic to store data inside the db
		Object[] sqlParameters = { employee.getName(), employee.getMobile(), employee.getCompany() };
		
		String sql = "insert into employees(name,mobile,company) values(?,?,?)";
		
		jdbcTemplate.update(sql, sqlParameters);
		
		System.out.println("Record inseted");
		
	}

	@Override
	public Employee getEmployee(int id) {

		String sql = "SELECT * FROM employees WHERE ID = ?";
		Employee employee = jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
		
		return employee;
	}

	@Override
	public void update(Employee employee) {

		String sql = "UPDATE employees SET name=?, mobile=?, company=? WHERE id =?";
		jdbcTemplate.update(sql, employee.getName(), employee.getMobile(), employee.getCompany(), employee.getId());
		System.out.println("1 Record Updated..");
		
	}

	@Override
	public void delete(int id) {
		
		String sql = "DELETE FROM employees WHERE Id=?";
		jdbcTemplate.update(sql, id);
		
	}

}
