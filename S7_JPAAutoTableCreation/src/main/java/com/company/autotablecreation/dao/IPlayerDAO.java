package com.company.autotablecreation.dao;

import java.util.Collection;

import com.company.autotablecreation.entity.FamilyMembers;
import com.company.autotablecreation.entity.Player;
import com.company.autotablecreation.exception.CustException;


public interface IPlayerDAO 
{
	public Collection<Player> displayAllPlayers() throws CustException;
	public Player findPlayerByID(String playerid) throws CustException;
	public Player updatePlayerByID(String playerid) throws CustException;
	public Player createPlayer() throws CustException;
	public Player deletePlayer(String playerid) throws CustException;
	public FamilyMembers createFamilyMember() throws CustException;
}
