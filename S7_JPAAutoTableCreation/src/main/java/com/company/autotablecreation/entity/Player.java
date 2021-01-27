package com.company.autotablecreation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player 
{
    
    @Id
    @GeneratedValue
    @Column(name = "player_id")
    private String playerid;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "email_address")
    private String emailAddress;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(String playerID, String name, String emailAddress) {
		super();
		this.playerid = playerID;
		this.name = name;
		this.emailAddress = emailAddress;
	}

	public String getPlayerID() {
		return playerid;
	}

	public void setPlayerID(String playerID) {
		this.playerid = playerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
    
}
