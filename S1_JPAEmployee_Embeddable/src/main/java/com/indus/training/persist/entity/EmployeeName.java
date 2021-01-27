package com.indus.training.persist.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmployeeName 
{

	@Column(name = "first_name")
	private String fName;

	@Column(name = "last_name")
	private String lName;

	public EmployeeName() 
	{
		
	}

	public EmployeeName(String fName, String lName) 
	{
		this.fName = fName;
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
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
		EmployeeName other = (EmployeeName) obj;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeName [fName=" + fName + ", lName=" + lName + "]";
	}

}