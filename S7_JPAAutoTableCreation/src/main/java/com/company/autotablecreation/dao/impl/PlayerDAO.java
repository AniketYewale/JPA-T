package com.company.autotablecreation.dao.impl;

import java.util.Collection;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.company.autotablecreation.dao.IPlayerDAO;
import com.company.autotablecreation.entity.FamilyMembers;
import com.company.autotablecreation.entity.Player;
import com.company.autotablecreation.exception.CustException;

@Repository 
public class PlayerDAO implements IPlayerDAO
{
	@PersistenceContext
	private EntityManager em;
	Scanner sc = new Scanner(System.in);
	

	public Collection<Player> displayAllPlayers() throws CustException {
		Query query = em.createQuery("SELECT u FROM User u");
	    return query.getResultList(); 
	}

	public Player findPlayerByID(String playerid) throws CustException {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public Player updatePlayerByID(String playerid) throws CustException {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public Player createPlayer() throws CustException {
		Player playerObj = new Player();
		
		System.out.println("\nEnter Player ID: ");
		String newPlayerid = sc.next();
	 	System.out.println("\nEnter name: ");
	 	String newName = sc.next();
		System.out.println("\nEnter email: ");
	 	String newEmail = sc.next();
	 	
	 	playerObj.setPlayerID(newPlayerid);
	 	playerObj.setName(newName);
	 	playerObj.setEmailAddress(newEmail);
		
		em.persist(playerObj);  
		em.close();
		return playerObj;
	}

	@Transactional
	public Player deletePlayer(String playerid) throws CustException {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public FamilyMembers createFamilyMember() throws CustException {
		FamilyMembers fmObj = new FamilyMembers();
		Player playerObj = new Player();
		
		System.out.println("\nEnter Member ID: ");
		String newMemid = sc.next();
	 	System.out.println("\nEnter name: ");
	 	String newMemName = sc.next();
		System.out.println("\nEnter email: ");
	 	String newMemEmail = sc.next();
	 	System.out.println("\nEnter Player ID: ");
		String newPlayerid = sc.next();
		playerObj.setPlayerID(newPlayerid);
		
	 	fmObj.setMemberid(newMemid);
	 	fmObj.setMemName(newMemName);
	 	fmObj.setEmail(newMemEmail);
	 	fmObj.setPlayerid(playerObj);
		
		em.persist(fmObj);  
		em.close();
		return fmObj;
	}

}
