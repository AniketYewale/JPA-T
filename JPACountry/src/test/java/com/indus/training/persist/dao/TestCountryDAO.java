package com.indus.training.persist.dao;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.indus.training.persist.config.AppConfig;
import com.indus.training.persist.entity.Country;

import com.indus.training.persist.exception.CountryPersistException;

public class TestCountryDAO 
{
	private ICountryDAO iCountryDAO = null;
	private AnnotationConfigApplicationContext context = null;

	@Before
	public void setUp() throws Exception 
	{
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		iCountryDAO = context.getBean(ICountryDAO.class);
	}

	@After
	public void tearDown() throws Exception 
	{
		iCountryDAO = null;
		context = null;
	}

	
	@Test
	public void findCountryByIDTest1() 
	{
		String countryId = "US";
		
		Country countryExpObj = new Country();
		countryExpObj.setCountryId("US");
		countryExpObj.setCountryName("United States of America");
		countryExpObj.setRegionId(2);

		
		
		Country countryActObj = null;
		
		try {
			countryActObj = iCountryDAO.findCountryByID(countryId);
			System.out.println("Test Output : " +countryActObj);
		} catch (CountryPersistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(countryExpObj,countryActObj);
	}
	
	@Test
	public void findCountryByIDTest2() 
	{
		String countryId = "IN";
		
		Country countryExpObj = new Country();
		countryExpObj.setCountryId("IN");
		countryExpObj.setCountryName("India");
		countryExpObj.setRegionId(3);

		
		
		Country countryActObj = null;
		
		try {
			countryActObj = iCountryDAO.findCountryByID(countryId);
			System.out.println("Test Output : " +countryActObj);
		} catch (CountryPersistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(countryExpObj,countryActObj);
	}

}
