package com.indus.training.persist.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.indus.training.persist.dao.IEmployeeDAO;
import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.exception.EmployeePersistException;

@Repository
public class EmployeeDAO implements IEmployeeDAO
{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Employee findEmployeeByID(int employeeId) throws EmployeePersistException 
	{
		Employee employeeObj = null;

		try {
			employeeObj = em.find(Employee.class, employeeId);
		} catch (Exception ex) {
			throw new EmployeePersistException(ex);
		} finally {
			em.close();
		}

		return employeeObj;
	}

	@Override
	public Employee findEmployeeByContactNumber(String phoneNumber) throws EmployeePersistException 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
