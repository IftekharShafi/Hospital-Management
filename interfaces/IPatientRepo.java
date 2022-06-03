package interfaces;

import java.lang.*;

import entity.*;

public interface IPatientRepo
{
	public void insertInDB(Patient p);
	public void deleteFromDB(String pId);
	public void updateInDB(Patient p);
	public Patient searchPatient(String pId);
	public String[][] getAllPatient();
}