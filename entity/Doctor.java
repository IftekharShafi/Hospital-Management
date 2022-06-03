package entity;

import java.lang.*;

public class Doctor
{
	private String dId;
	private String dName;
	private String dMobileNo;
	private double dSalary;
	private String specialization;
	
	public Doctor(){}
	public Doctor (String dId, String dName, String dMobileNo, double dSalary, String specialization)
	{
		this.dId = dId;
		this.dName = dName;
		this.dMobileNo = dMobileNo;
		this.dSalary = dSalary;
		this.specialization = specialization;
	}

	public void setDId(String dId)
	{
		this.dId = dId;
	}
	public void setDName(String dName)
	{
	   this.dName = dName;
	}
	public void setDMobileNo(String dMobileNo)
	{
		this.dMobileNo = dMobileNo;
	}
	public void setDSalary(double dSalary)
	{
		this.dSalary = dSalary;
	}
	public void setSpecialization(String specialization)
	{
		this.specialization = specialization;
	}
	
	public String getDId(){return dId;}
	public String getDName() {return dName;}
	public String getDMobileNo(){return dMobileNo;}
	public double getDSalary(){return dSalary;}
	public String getSpecialization(){return specialization;}

}




