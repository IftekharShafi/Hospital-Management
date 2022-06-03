package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class PatientRepo implements IPatientRepo
{
	DatabaseConnection dbc;
	public PatientRepo()
	{
		dbc = new DatabaseConnection();
	}
	public void insertInDB(Patient p)
	{
		String query = "INSERT INTO patients VALUES ('"+p.getPId()+"','"+p.getPName()+"','"+p.getPAge()+"','"+p.getPGender()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String pId)
	{
		String query = "DELETE from patients WHERE pId='"+pId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void updateInDB(Patient p)
	{
		String query = "UPDATE patients SET pName='"+p.getPName()+"', pAge = '"+p.getPAge()+"', pGender = '"+p.getPGender()+"' WHERE pId='"+p.getPId()+"';";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Patient searchPatient(String pId)
	{
		Patient p = null;
		String query = "SELECT `pName`, `pAge`, `pGender` FROM `patients` WHERE `pId`='"+pId+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String pName = dbc.result.getString("pName");
				int pAge = dbc.result.getInt("pAge");
				String pGender = dbc.result.getString("pGender");
				
				p = new Patient();
				p.setPId(pId);
				p.setPName(pName);
				p.setPAge(pAge);
				p.setPGender(pGender);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return p;
	}
	public String[][] getAllPatient()
	{
		ArrayList<Patient> ar = new ArrayList<Patient>();
		String query = "SELECT * FROM patients;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
			while(dbc.result.next())
			{
				String pId = dbc.result.getString("pId");
				String name = dbc.result.getString("pName");
				int pAge = dbc.result.getInt("pAge");
				String pGender = dbc.result.getString("pGender");
				
				Patient p = new Patient(pId,name,pAge,pGender);
				ar.add(p);
			}
		}
		catch(Exception p){System.out.println(p.getMessage());}
		dbc.closeConnection();
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Patient)obj[i]).getPId();
			data[i][1] = ((Patient)obj[i]).getPName();
			data[i][2] = ((Patient)obj[i]).getPAge()+"";
			data[i][3] = (((Patient)obj[i]).getPGender());
		}
		return data;
	}
}
