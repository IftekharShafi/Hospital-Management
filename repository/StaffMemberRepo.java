package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class StaffMemberRepo implements IStaffMemberRepo
{
	DatabaseConnection dbc;
	public StaffMemberRepo()
	{
		dbc = new DatabaseConnection();
	}
	public void insertInDB(StaffMember s)
	{
		String query = "INSERT INTO staffMembers VALUES ('"+s.getSId()+"','"+s.getSName()+"','"+s.getSMobileNo()+"','"+s.getSSalary()+"','"+s.getJobTitle()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String sId)
	{
		String query = "DELETE from staffMembers WHERE sId='"+sId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void updateInDB(StaffMember s)
	{
		String query = "UPDATE staffMembers SET sName='"+s.getSName()+"', sMobileNo = '"+s.getSMobileNo()+"', sSalary = '"+s.getSSalary()+"', jobTitle = '"+s.getJobTitle()+"' WHERE sId='"+s.getSId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}

	public StaffMember searchStaffMember(String sId)
	{
		StaffMember s = null;
		String query = "SELECT `sName`, `sMobileNo`, `sSalary`, `jobTitle` FROM `staffMembers` WHERE `sId`='"+sId+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String sName = dbc.result.getString("sName");
				String sMobileNo = dbc.result.getString("sMobileNo");
				double sSalary = dbc.result.getDouble("sSalary");
				String jobTitle = dbc.result.getString("jobTitle");
				
				s = new StaffMember();
				s.setSId(sId);
				s.setSName(sName);
				s.setSMobileNo(sMobileNo);
				s.setSSalary(sSalary);
				s.setJobTitle(jobTitle);

			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return s;
	}
	public String[][] getAllStaffMember()
	{
		ArrayList<StaffMember> ar = new ArrayList<StaffMember>();
		String query = "SELECT * FROM staffMembers;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String sId = dbc.result.getString("sId");
				String sName = dbc.result.getString("sName");
				String sMobileNo = dbc.result.getString("sMobileNo");
				double sSalary = dbc.result.getDouble("sSalary");
				String jobTitle = dbc.result.getString("jobTitle");
				
				StaffMember s = new StaffMember(sId,sName,sMobileNo,sSalary,jobTitle);
				ar.add(s);
			}
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((StaffMember)obj[i]).getSId();
			data[i][1] = ((StaffMember)obj[i]).getSName();
			data[i][2] = ((StaffMember)obj[i]).getSMobileNo();
			data[i][3] = (((StaffMember)obj[i]).getSSalary())+"";
			data[i][4] = ((StaffMember)obj[i]).getJobTitle();
		}
		return data;
	}
}