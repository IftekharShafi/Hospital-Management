package interfaces;

import java.lang.*;

import entity.*;

public interface IStaffMemberRepo
{
	public void insertInDB(StaffMember s);
	public void deleteFromDB(String sId);
	public void updateInDB(StaffMember s);
	public StaffMember searchStaffMember(String sId);
	public String[][] getAllStaffMember();
}