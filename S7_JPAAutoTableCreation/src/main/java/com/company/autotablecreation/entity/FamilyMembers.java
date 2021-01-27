package com.company.autotablecreation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "familymembers")
public class FamilyMembers 
{

    @Id
    @GeneratedValue
    private String memberid;

    @Column(name = "name", nullable = false)
    private String MemName;

    @Column(name = "email_id", nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name ="player_id", nullable = false)
    private Player playerid;

	public FamilyMembers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FamilyMembers(String memberid, String memName, String email, Player playerid) {
		super();
		this.memberid = memberid;
		MemName = memName;
		this.email = email;
		this.playerid = playerid;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getMemName() {
		return MemName;
	}

	public void setMemName(String memName) {
		MemName = memName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Player getPlayerid() {
		return playerid;
	}

	public void setPlayerid(Player playerid) {
		this.playerid = playerid;
	}

    
}