package com.company.autotablecreation.main;

import java.util.Collection;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.company.autotablecreation.config.AppConfig;
import com.company.autotablecreation.dao.IPlayerDAO;
import com.company.autotablecreation.entity.FamilyMembers;
import com.company.autotablecreation.entity.Player;
import com.company.autotablecreation.exception.CustException;


public class MainClass 
{
	public static void main(String[] args) 
	{
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		IPlayerDAO iPlayerDAOObj = ctx.getBean(IPlayerDAO.class);
		Player playerObj = new Player();
		FamilyMembers fmObj = new FamilyMembers();
		Collection<Player> allPlayers;
		
	    Scanner sc = new Scanner(System.in);
		char ch;
			
		 try {
			do {
				 System.out.println("\nWhat would you like to do? ");
				 System.out.println("1. Display all players");
				 System.out.println("2. Update Record");
				 System.out.println("3. Find Player by ID");
				 System.out.println("4. Insert new Player record:");
				 System.out.println("5. Delete a record:");
				 System.out.println("6. Insert new Family member record:");
				 
				 System.out.println("\nEnter your choice: ");
				 int choice = sc.nextInt();

				 switch (choice) 
				 {
				 case 1:
					 	 System.out.println("\nDisplaying all Users: \n");
					 	 allPlayers = iPlayerDAOObj.displayAllPlayers();
						 for(Player nextPlayer : allPlayers)
						 {
							System.out.println(nextPlayer);
						 }
						 break;

				 case 2:

					 try {
						  System.out.println("\nEnter the Player ID you want to update: ");
						  String updatePlayerid = sc.nextLine();
						  playerObj  = iPlayerDAOObj.updatePlayerByID(updatePlayerid);
					 	  System.out.println("Player Updated : " + playerObj);
						 } catch (Exception e) {
						  System.out.println("PlayerID doesn't exist");
						  System.out.println(e);
						 }
					 	 break;
					 	
			     case 3:
						  System.out.println("\nEnter the UserID you want to find: ");
						  String userid = sc.nextLine();
						  playerObj  = iPlayerDAOObj.findPlayerByID(userid);
					 	  if(playerObj!=null)
					 	  {
					 		  System.out.println("Player Found : " + playerObj);
					 	  }
					 	  else
					 	  {
						    System.out.println("PlayerID doesn't exist");
						  }
					 	 break;
					 	 
			     case 4:
			    	 try {
			    		 playerObj  = iPlayerDAOObj.createPlayer();
					 	  System.out.println("Player record created : " + playerObj);
						 } catch (Exception e) {
							 e.printStackTrace();
						  System.out.println("Player record not created");
						 }
					 	 break;
					 	 
			     case 5:

					 try {
						  System.out.println("\nEnter the User ID you want to delete: ");
						  String updatePlayerid = sc.nextLine();
						  playerObj  = iPlayerDAOObj.deletePlayer(updatePlayerid);
					 	  System.out.println("Player Deleted : " + playerObj);
						 } catch (Exception e) {
						  System.out.println(e);
						  System.out.println("PlayerID doesn't exist");
						 }
					 	 break;	 	 
					 	 
			     case 6:
			    	 try {
			    		 fmObj  = iPlayerDAOObj.createFamilyMember();
					 	  System.out.println("Family Member record created : " + playerObj);
						 } catch (Exception e) {
							 e.printStackTrace();
						  System.out.println("Family Member record not created");
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
		} catch (CustException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
		sc.close(); 
	}

}

