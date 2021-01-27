package com.indus.training.persist.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.indus.training.persist.config.AppConfig;
import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.entity.EmployeeName;
import com.indus.training.persist.exception.EmployeePersistException;



public class TestEmployeeDAO {

	private IEmployeeDAO iEmployeeDAO = null;
	private AnnotationConfigApplicationContext ctx = null;

	@Before
	public void setUp() throws Exception {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		iEmployeeDAO = ctx.getBean(IEmployeeDAO.class);
	}

	@After
	public void tearDown() throws Exception {
		iEmployeeDAO = null;
		ctx = null;
	}


	@Test
	public void findEmployeeByIDTest1() {
		int employeeId = 100;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateinString = "1987-06-17";
		Date ConvDate;
		
		Employee employeeExpObj = new Employee();
		EmployeeName employeeNameExpObj = new EmployeeName();
		
		Employee employeeActObj = null;
		EmployeeName employeeNameActObj = null;

		try {
			ConvDate = sdf.parse(dateinString);
			
			employeeExpObj.setEmployee_id(100);
			employeeNameExpObj.setfName("Steven");
			employeeNameExpObj.setlName("King");
			employeeExpObj.setEmployeeName(employeeNameExpObj);
			employeeExpObj.setEmail("steven.king@sqltutorial.org");
			employeeExpObj.setPhoneNumber("515.123.4567");
			employeeExpObj.setHireDate(ConvDate);
			employeeExpObj.setJobID(4);
			employeeExpObj.setSalary(24000.00);
			employeeExpObj.setManagerID(null);
			employeeExpObj.setDepartmentID(9);		

			employeeActObj = iEmployeeDAO.findEmployeeByID(employeeId);
			System.out.println("Test Act Output : " + employeeActObj);
			System.out.println("Test Exp Output : " + employeeExpObj);

		 }catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (EmployeePersistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(employeeExpObj, employeeActObj);

	}
	
	
	@Test
	public void findEmployeeByIDTest2() {
		int employeeId = 101;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateinString = "1989-09-21";
		Date ConvDate;
		
		Employee employeeExpObj = new Employee();
		EmployeeName employeeNameExpObj = new EmployeeName();
		
		Employee employeeActObj = null;
		EmployeeName employeeNameActObj = null;
		

		try {
			ConvDate = sdf.parse(dateinString);
			
			employeeExpObj.setEmployee_id(101);
			employeeNameExpObj.setfName("Neena");
			employeeNameExpObj.setlName("Kochhar");
			employeeExpObj.setEmployeeName(employeeNameExpObj);
			employeeExpObj.setEmail("neena.kochhar@sqltutorial.org");
			employeeExpObj.setPhoneNumber("515.123.4568");
			employeeExpObj.setHireDate(ConvDate);
			employeeExpObj.setJobID(5);
			employeeExpObj.setSalary(17000.00);
			employeeExpObj.setManagerID(100);
			employeeExpObj.setDepartmentID(9);		

			employeeActObj = iEmployeeDAO.findEmployeeByID(employeeId);
			System.out.println("Test Act Output : " + employeeActObj);
			System.out.println("Test Exp Output : " + employeeExpObj);

		 }catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (EmployeePersistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(employeeExpObj, employeeActObj);

	}
	
	
}
