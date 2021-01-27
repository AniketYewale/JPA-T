package com.lyssn.useroperation.dao.impl;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lyssn.useroperation.dao.IUserDAO;
import com.lyssn.useroperation.entity.User;
import com.lyssn.useroperation.exception.UserException;

@Repository
public class UserDAO implements IUserDAO
{
	@PersistenceContext
	private EntityManager em;
	Scanner sc = new Scanner(System.in);
	
	public Collection<User> displayAllUsers() throws UserException 
	{
		Query query = em.createQuery("SELECT u FROM User u");
	    return query.getResultList(); 
	}
	
	
	public User findUserByID(BigInteger userid) throws UserException 
	{
		User userObj = null;

		try {
			userObj = em.find(User.class, userid);
		} catch (Exception ex) {
			throw new UserException(ex);
		} 
		return userObj;
	}


	@Transactional
	public User updateUserByID(BigInteger userid) throws UserException 
	{
		
		User userObj = null;
	//	em.getTransaction().begin();
		userObj = em.find(User.class, userid);
		
		userObj.setUserid(userid);
	 	System.out.println("\nEnter first name to update: ");
	 	String updatedfname = sc.next();
		userObj.setFname(updatedfname);
		System.out.println("\nEnter last name to update: ");
	 	String updatedlname = sc.next();
		userObj.setLname(updatedlname);
		userObj.setSignupdate(LocalDateTime.now());
		
	//  em.getTransaction().commit();
		em.close();
		return userObj;
	}


	@Transactional
	public User createUser() throws UserException 
	{
		User userObj = new User();
	//	em.getTransaction().begin();
		
		System.out.println("\nEnter User ID: ");
		BigInteger newUserid = sc.nextBigInteger();
	 	System.out.println("\nEnter first name: ");
	 	String newfname = sc.next();
		System.out.println("\nEnter last name: ");
	 	String updatedlname = sc.next();
	 	
	 	userObj.setUserid(newUserid);
		userObj.setFname(newfname);
		userObj.setLname(updatedlname);
		userObj.setSignupdate(LocalDateTime.now());
		
		em.persist(userObj);  
	//	em.getTransaction().commit();
		em.close();
		return userObj;
	}
	
	@Transactional
	public User deleteUser(BigInteger userid) throws UserException 
	{
		User userObj = new User();
		userObj = em.find(User.class, userid);
		
		em.remove(userObj);  
		em.close();
		return userObj;
	}
}
