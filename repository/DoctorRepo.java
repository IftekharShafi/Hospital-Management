package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class DoctorRepo implements IDoctorRepo
{
	DatabaseConnection dbc;
	public DoctorRepo()
	{
		dbc = new DatabaseConnection();
	}
	public void insertInDB(Doctor d)
	{
		String query = "INSERT INTO doctors VALUES ('"+d.getDId()+"','"+d.getDName()+"','"+d.getDMobileNo()+"',"+d.getDSalary()+",'"+d.getSpecialization()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String dId)
	{
		String query = "DELETE from doctors WHERE dId='"+dId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void updateInDB(Doctor d)
	{
		String query = "UPDATE doctors SET dName='"+d.getDName()+"', dMobileNo = '"+d.getDMobileNo()+"', dSalary = "+d.getDSalary()+", specialization = '"+d.getSpecialization()+"' WHERE dId='"+d.getDId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}

	public Doctor searchDoctor(String dId)
	{
		Doctor d = null;
		String query = "SELECT `dName`, `dMobileNo`, `dSalary`, `specialization` FROM `doctors` WHERE `dId`='"+dId+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String dName = dbc.result.getString("dName");
				String dMobileNo = dbc.result.getString("dMobileNo");
				double dSalary = dbc.result.getDouble("dSalary");
				String specialization = dbc.result.getString("specialization");
				
				d = new Doctor();
				d.setDId(dId);
				d.setDName(dName);
				d.setDMobileNo(dMobileNo);
				d.setDSalary(dSalary);
				d.setSpecialization(specialization);

			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return d;
	}
	public String[][] getAllDoctor()
	{
		ArrayList<Doctor> ar = new ArrayList<Doctor>();
		String query = "SELECT * FROM doctors;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String dId = dbc.result.getString("dId");
				String dName = dbc.result.getString("dName");
				String dMobileNo = dbc.result.getString("dMobileNo");
				double dSalary = dbc.result.getDouble("dSalary");
				String specialization = dbc.result.getString("specialization");
				
				Doctor d = new Doctor(dId,dName,dMobileNo,dSalary,specialization);
				ar.add(d);
			}
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Doctor)obj[i]).getDId();
			data[i][1] = ((Doctor)obj[i]).getDName();
			data[i][2] = ((Doctor)obj[i]).getDMobileNo();
			data[i][3] = (((Doctor)obj[i]).getDSalary())+"";
			data[i][4] = ((Doctor)obj[i]).getSpecialization();
		}
		return data;
	}
}