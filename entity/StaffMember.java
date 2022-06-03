package entity;

import java.lang.*;

public class StaffMember
{
	private String sId;
	private String sName;
	private String sMobileNo;
	private double sSalary;
	private String jobTitle;
	
	public StaffMember(){}
	public StaffMember(String sId, String sName, String sMobileNo, double sSalary, String jobTitle)
	{
		this.sId = sId;
		this.sName = sName;
		this.sMobileNo = sMobileNo;
		this.sSalary = sSalary;
		this.jobTitle = jobTitle;
	}

	public void setSId(String sId)
	{
		this.sId = sId;
	}
	public void setSName(String sName)
	{
	   this.sName = sName;
	}
	public void setSMobileNo(String sMobileNo)
	{
		this.sMobileNo = sMobileNo;
	}
	public void setSSalary(double sSalary)
	{
		this.sSalary = sSalary;
	}
	public void setJobTitle(String jobTitle)
	{
		this.jobTitle = jobTitle;
	}
	
	public String getSId(){return sId;}
	public String getSName() {return sName;}
	public String getSMobileNo(){return sMobileNo;}
	public double getSSalary(){return sSalary;}
	public String getJobTitle(){return jobTitle;}
}




