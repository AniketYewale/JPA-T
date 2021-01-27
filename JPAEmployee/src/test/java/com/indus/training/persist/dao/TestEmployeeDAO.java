package com.indus.training.persist.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.indus.training.persist.config.AppConfig;
import com.indus.training.persist.entity.Employee;
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

//	@Test
	public void createEmployeeTest() 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateinString = "2019-05-08";
		Date ConvDate;
		
		Employee employeeAddObj = new Employee();

		try {
			ConvDate = sdf.parse(dateinString);
			
			employeeAddObj.setEmployee_id(77);
			employeeAddObj.setfName("Aniket");
			employeeAddObj.setlName("Yewale");
			employeeAddObj.setEmail("aniketyewale29@gmail.com");
			employeeAddObj.setPhoneNumber("725.266.1350");
			employeeAddObj.setHireDate(ConvDate);
			employeeAddObj.setJobID(7);
			employeeAddObj.setSalary(60000.00);
			employeeAddObj.setManagerID(154);
			employeeAddObj.setDepartmentID(4);		
			
			iEmployeeDAO.addEmployee(employeeAddObj);

		 }catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (EmployeePersistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Employee employeeFoundObj = new Employee();
		try {
			employeeFoundObj = iEmployeeDAO.findEmployeeByID(employeeAddObj.getEmployee_id());
		} catch (EmployeePersistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(employeeAddObj, employeeFoundObj);

	}
	
	

	@Test
	public void findEmployeeByIDTest1() {
		int employeeId = 100;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateinString = "1987-06-17";
		Date ConvDate;
		
		Employee employeeExpObj = new Employee();
		Employee employeeActObj = null;
		

		try {
			ConvDate = sdf.parse(dateinString);
			
			employeeExpObj.setEmployee_id(100);
			employeeExpObj.setfName("Steven");
			employeeExpObj.setlName("King");
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
		Employee employeeActObj = null;
		

		try {
			ConvDate = sdf.parse(dateinString);
			
			employeeExpObj.setEmployee_id(101);
			employeeExpObj.setfName("Neena");
			employeeExpObj.setlName("Kochhar");
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
	
	
//	@Test
	public void findAllEmployeesTest() 
	{
		Collection<Employee> allEmployees;
		
		try {
			allEmployees = iEmployeeDAO.findAllEmployees();
			for(Employee nextEmployee : allEmployees)
			{
				System.out.println(nextEmployee);
			}
		} catch (EmployeePersistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
//	@Test
	public void getAllEmployeesByPageTest()
	{
		List<Employee> employeeList;
		employeeList = iEmployeeDAO.getAllEmployeesByPage(10);
		System.out.println(employeeList);
	}

}
