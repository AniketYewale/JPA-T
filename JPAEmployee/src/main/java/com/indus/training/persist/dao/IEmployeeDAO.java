package com.indus.training.persist.dao;

import java.util.Collection;
import java.util.List;

import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.exception.EmployeePersistException;


public interface IEmployeeDAO 
{

	public void addEmployee(Employee employee) throws EmployeePersistException;
	
	public Employee findEmployeeByID(int employeeId) throws EmployeePersistException;
	
	public Boolean updateEmployee(Employee employee) throws EmployeePersistException;
	
	public Boolean deleteEmployeeByID(int employeeId) throws EmployeePersistException;
	
	public Collection<Employee> findAllEmployees() throws EmployeePersistException;

	public List<Employee> getAllEmployeesByPage(int pageid);

}
