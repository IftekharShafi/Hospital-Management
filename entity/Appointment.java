package entity;

import java.lang.*;

public class Appointment
 {
	 private String serialNo;
	 private String apptDate;
	 private String doctorName;
	 
	 public Appointment(){}
	 public Appointment(String serialNo,String apptDate,String doctorName)
	 {
		 this.apptDate = apptDate;
		 this.serialNo = serialNo;
		 this.doctorName = doctorName;
	 }
	 
	 public void setSerialNo(String serialNo)
	 {
		 this.serialNo = serialNo;
	 }
	 public void setApptDate(String apptDate)
	 {
		 this.apptDate = apptDate;
	 }
	 public void setDoctorName(String doctorName)
	 {
		 this.doctorName = doctorName;
	 }
	 public String getSerialNo(){return serialNo;}
	 public String getApptDate(){return apptDate;}
	 public String getDoctorName(){return doctorName;}
 }
	 
	 