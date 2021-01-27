package com.lyssn.useroperation.entity;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HR.USERS")
public class User 
{
	@Id
	private BigInteger userid;
	
	private String fname;
	private String lname;
	private LocalDateTime signupdate;
	
	
	public User() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(BigInteger userid, String fname, String lname, LocalDateTime signupdate) 
	{
		super();
		this.userid = userid;
		this.fname = fname;
		this.lname = lname;
		this.signupdate = signupdate;
	}

	
	public BigInteger getUserid() {
		return userid;
	}


	public void setUserid(BigInteger userid) {
		this.userid = userid;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}


	public LocalDateTime getSignupdate() {
		return signupdate;
	}


	public void setSignupdate(LocalDateTime signupdate) {
		this.signupdate = signupdate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + ((signupdate == null) ? 0 : signupdate.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (signupdate == null) {
			if (other.signupdate != null)
				return false;
		} else if (!signupdate.equals(other.signupdate))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [userid=" + userid + ", fname=" + fname + ", lname=" + lname + ", signupdate=" + signupdate + "]";
	}


}
