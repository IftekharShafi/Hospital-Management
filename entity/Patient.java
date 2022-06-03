package entity;

import java.lang.*;

public class Patient
{
	private String pId;
	private String pName;
	private int pAge;
	private String pGender;
	
	public Patient() {}
	public Patient (String pId,String pName, int pAge, String pGender)
	{
		this.pId = pId;
		this.pName = pName;
		this.pAge = pAge;
		this.pGender = pGender;
	}
	
	public void setPId(String pId)
	{
		this.pId = pId;
	}
	public void setPName(String pName)
	{
		this.pName = pName;
	}
	public void  setPAge(int pAge)
	{
		this.pAge = pAge;
	}
	public void setPGender(String pGender)
	{
		this.pGender = pGender;
	}
	public String getPId(){return pId;}
	public String getPName(){return pName;}
	public int getPAge(){return pAge;}
	public String getPGender(){return pGender;}
}

		
	

		
	