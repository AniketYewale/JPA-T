package com.indus.training.persist.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.indus.training.persist.dao.IEmployeeDAO;
import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.exception.EmployeePersistException;

@Repository
public class EmployeeDAO implements IEmployeeDAO
{

	@PersistenceContext
	private EntityManager em;
	private JdbcTemplate template;
	
	
	@Transactional
	public void addEmployee(Employee newEmployee) throws EmployeePersistException 
	{
		em.persist(newEmployee);
		System.out.println(newEmployee);
	}
	
	
	public Employee findEmployeeByID(int employeeId) throws EmployeePersistException 
	{
		Employee employeeObj = null;

		try {
			employeeObj = em.find(Employee.class, employeeId);
		} catch (Exception ex) {
			throw new EmployeePersistException(ex);
		} 
		return employeeObj;
	}


	@Override
	public Boolean updateEmployee(Employee employee) throws EmployeePersistException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteEmployeeByID(int employeeId) throws EmployeePersistException 
	{
		Boolean isDeleted = false;
		em.remove(employeeId);
		return isDeleted;
	}


	@Override
	public Collection<Employee> findAllEmployees() throws EmployeePersistException 
	{
		Query query = em.createQuery("SELECT e FROM Employee e");
	    return query.getResultList(); 
	}

	@Override
	public List<Employee> getAllEmployeesByPage(int pageid)
	{    
		String sql = "SELECT * FROM HR.EMPLOYEES LIMIT "+(pageid);    
		return template.query(sql,new RowMapper<Employee>()
		{    
			public Employee mapRow(ResultSet rs, int row) throws SQLException 
			{    
				Employee employee=new Employee();   
				employee.setEmployee_id(rs.getInt(1));
				employee.setfName(rs.getString(2));
				employee.setlName(rs.getString(3));
				employee.setEmail(rs.getString(4));
				employee.setPhoneNumber(rs.getString(5));
				employee.setHireDate(rs.getDate(6));
				employee.setJobID(rs.getInt(7));
				employee.setSalary(rs.getDouble(8));
				employee.setManagerID(rs.getInt(9));
				employee.setDepartmentID(rs.getInt(10));
				return employee;    
			}    
		});    
	}    

	
}
