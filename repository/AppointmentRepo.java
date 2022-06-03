package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class AppointmentRepo implements IAppointmentRepo
{
	DatabaseConnection dbc;
	public AppointmentRepo()
	{
		dbc = new DatabaseConnection();
	}
	public void insertInDB(Appointment appt)
	{
		String query = "INSERT INTO appointments VALUES ('"+appt.getSerialNo()+"','"+appt.getApptDate()+"','"+appt.getDoctorName()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String serialNo)
	{
		String query = "DELETE from appointments WHERE serialNo='"+serialNo+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void updateInDB(Appointment appt)
	{
		String query = "UPDATE appointments SET apptDate='"+appt.getApptDate()+"', doctorName = '"+appt.getDoctorName()+"' WHERE serialNo='"+appt.getSerialNo()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Appointment searchAppointment(String serialNo)
	{
		Appointment appt = null;
		String query = "SELECT `apptDate`,`doctorName` FROM `appointments` WHERE `serialNo`='"+serialNo+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String apptDate = dbc.result.getString("apptDate");
				String doctorName = dbc.result.getString("doctorName");
				
				appt = new Appointment();
				appt.setSerialNo(serialNo);
				appt.setApptDate(apptDate);
				appt.setDoctorName(doctorName);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return appt;
	}
	public String[][] getAllAppointment()
	{
		ArrayList<Appointment> ar = new ArrayList<Appointment>();
		String query = "SELECT * FROM appointments;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
			while(dbc.result.next())
			{
				String serialNo = dbc.result.getString("serialNo");
				String apptDate = dbc.result.getString("apptDate");
				String doctorName = dbc.result.getString("doctorName");
				
				Appointment appt = new Appointment(serialNo,apptDate,doctorName);
				ar.add(appt);
			}
		}
		catch(Exception appt){System.out.println(appt.getMessage());}
		dbc.closeConnection();
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][3];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Appointment)obj[i]).getSerialNo();
			data[i][1] = ((Appointment)obj[i]).getApptDate();
			data[i][2] = (((Appointment)obj[i]).getDoctorName())+"";
		}
		return data;
	}
}
