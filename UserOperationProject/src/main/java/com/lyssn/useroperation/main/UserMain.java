package com.lyssn.useroperation.main;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lyssn.useroperation.config.AppConfig;
import com.lyssn.useroperation.dao.IUserDAO;
import com.lyssn.useroperation.entity.User;
import com.lyssn.useroperation.exception.UserException;

public class UserMain 
{
	public static void main(String[] args) 
	{
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		IUserDAO iUserDAOObj = ctx.getBean(IUserDAO.class);
		User userObj = new User();
		Collection<User> allUsers;
		
	    Scanner sc = new Scanner(System.in);
		char ch;
			
		 try {
			do {
				 System.out.println("\nWhat would you like to do? ");
				 System.out.println("1. Display all users");
				 System.out.println("2. Update Record");
				 System.out.println("3. Find User by UserID");
				 System.out.println("4. Insert new record:");
				 System.out.println("5. Delete a record:");
				 System.out.println("\nEnter your choice: ");
				 int choice = sc.nextInt();

				 switch (choice) 
				 {
				 case 1:
					 	 System.out.println("\nDisplaying all Users: \n");
						 allUsers = iUserDAOObj.displayAllUsers();
						 for(User nextUser : allUsers)
						 {
							System.out.println(nextUser);
						 }
						 break;

				 case 2:

					 try {
						  System.out.println("\nEnter the User ID you want to update: ");
					 	  BigInteger updateUserid = sc.nextBigInteger();
					 	  userObj  = iUserDAOObj.updateUserByID(updateUserid);
					 	  System.out.println("User Updated : " + userObj);
						 } catch (Exception e) {
						  System.out.println("UserID doesn't exist");
						  System.out.println(e);
						 }
					 	 break;
					 	
			     case 3:
						  System.out.println("\nEnter the UserID you want to find: ");
					 	  BigInteger userid = sc.nextBigInteger();
					 	  userObj  = iUserDAOObj.findUserByID(userid);
					 	  if(userObj!=null)
					 	  {
					 		  System.out.println("User Found : " + userObj);
					 	  }
					 	  else
					 	  {
						    System.out.println("UserID doesn't exist");
						  }
					 	 break;
					 	 
			     case 4:
			    	 try {
					 	  userObj  = iUserDAOObj.createUser();
					 	  System.out.println("User record created : " + userObj);
						 } catch (Exception e) {
							 e.printStackTrace();
						  System.out.println("User record not created");
						 }
					 	 break;
					 	 
			     case 5:

					 try {
						  System.out.println("\nEnter the User ID you want to delete: ");
					 	  BigInteger updateUserid = sc.nextBigInteger();
					 	  userObj  = iUserDAOObj.deleteUser(updateUserid);
					 	  System.out.println("User Deleted : " + userObj);
						 } catch (Exception e) {
						  System.out.println(e);
						  System.out.println("UserID doesn't exist");
						 }
					 	 break;	 	 
						
			     default:
					 	System.out.println("\nWrong Choice \n ");
					 	break;
			    }

				System.out.println("\nDo you want to continue (Type Y or N) : ");
				ch = sc.next().charAt(0);
			 } while (ch == 'Y' || ch == 'y');

				//br.close();
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
		sc.close(); 
	}

}
