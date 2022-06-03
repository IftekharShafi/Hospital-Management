package interfaces;

import java.lang.*;

import entity.*;

public interface IDoctorRepo
{
	public void insertInDB(Doctor d);
	public void deleteFromDB(String dId);
	public void updateInDB(Doctor d);
	public Doctor searchDoctor(String dId);
	public String[][] getAllDoctor();
}