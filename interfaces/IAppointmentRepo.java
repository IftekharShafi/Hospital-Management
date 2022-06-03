package interfaces;

import java.lang.*;

import entity.*;

public interface IAppointmentRepo
{
	public void insertInDB(Appointment a);
	public void deleteFromDB(String serialNo);
	public void updateInDB(Appointment a);
	public Appointment searchAppointment(String serialNo);
	public String[][] getAllAppointment();
}