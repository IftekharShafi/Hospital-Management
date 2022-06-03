package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class AppointmentFrame extends JFrame implements ActionListener
{
	JLabel serialLabel,appdateLabel,doctorLabel;
	JTextField serialTF,appdateTF,doctorTF;
	JButton loadBtn,insertBtn,updateBtn,deleteBtn,refreshBtn,getAllBtn,backBtn,logoutBtn;
	JPanel panel;
	JTable aTable;
	Color color;
	JScrollPane aTableSP;
	
	User user;
	AppointmentRepo ar;
	
	
	public AppointmentFrame(User user)
	{
		super("AppointmentFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.user = user;
		
		
		ar = new AppointmentRepo();
		
		
		color = new Color(255,255,255);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(color);
		
			
		String data[][] = {{"", "", ""}};
		
		String head[] = {"Serial No", "Appointment Date","Doctor Name"};
		
		aTable = new JTable(data,head);
		aTableSP = new JScrollPane(aTable);
		aTableSP.setBounds(350, 100, 400, 150);
		aTable.setEnabled(false);
		panel.add(aTableSP);
		 
		serialLabel = new JLabel("Serial No :");
		serialLabel.setBounds(60, 40,300 ,50);
		serialLabel.setBackground(Color.WHITE);
		panel.add(serialLabel);
		serialLabel.setOpaque(true);
		
		serialTF = new JTextField();
		serialTF.setBounds(130,50,100,30);
		panel.add(serialTF);
		
		appdateLabel = new JLabel("Appointment Date :");
		appdateLabel.setBounds(15, 80,300 ,50);
		appdateLabel.setBackground(Color.WHITE);
		panel.add(appdateLabel);
		appdateLabel.setOpaque(true);
		
		appdateTF = new JTextField();
		appdateTF.setBounds(130,90,100,30);
		panel.add(appdateTF);
		
		doctorLabel = new JLabel("Doctor Name:");
		doctorLabel.setBounds(45, 120,300 ,50);
		doctorLabel.setBackground(Color.WHITE);
		panel.add(doctorLabel);
		doctorLabel.setOpaque(true);
		
		doctorTF = new JTextField();
		doctorTF.setBounds(130,130,100,30);
		panel.add(doctorTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(40,280,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(40,320,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(140,280,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(140,320,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(240,280,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(240,320,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(580, 350, 80, 30);
		backBtn.setBackground(Color.CYAN);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(680,350,80,30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		this.add(panel);	
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		if(command.equals(loadBtn.getText()))
		{
			if(!serialTF.getText().equals("") || !serialTF.getText().equals(null))
			{
				Appointment appt = ar.searchAppointment(serialTF.getText());
				if(appt!= null)
				{

					appdateTF.setText(appt.getApptDate());
					doctorTF.setText(appt.getDoctorName());
					
					
					serialTF.setEnabled(false);
					appdateTF.setEnabled(true);
					doctorTF.setEnabled(true);
					
					if(this.user.getStatus()==2)
					{
						updateBtn.setEnabled(false);
						deleteBtn.setEnabled(false);
						refreshBtn.setEnabled(true);
						insertBtn.setEnabled(false);
						loadBtn.setEnabled(true);

					}
					else
					{
						loadBtn.setEnabled(false);
						insertBtn.setEnabled(false);
						updateBtn.setEnabled(true);
						deleteBtn.setEnabled(true);
						refreshBtn.setEnabled(true);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild Serial Number");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Appointment appt = new Appointment();
			//User u = new User();
			//Random rd = new Random();
			//int x = rd.nextInt(9999999)+10000000;
			
			appt.setSerialNo(serialTF.getText());
			appt.setApptDate(appdateTF.getText());
			appt.setDoctorName(doctorTF.getText());
			
			
			/*u.setUserId(idTF.getText());
			u.setPassword(x+"");
			u.setStatus(0);*/
			
			ar.insertInDB(appt);
			//ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Serial No: "+serialTF.getText()+" has been inserted");
			
			appdateTF.setText("");
			doctorTF.setText("");
			

			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			serialTF.setText("");
			appdateTF.setText("");
			doctorTF.setText("");
			
			serialTF.setEnabled(true);
			
			if(this.user.getStatus()==2)
			{
				updateBtn.setEnabled(false);
				deleteBtn.setEnabled(false);
				refreshBtn.setEnabled(false);
				insertBtn.setEnabled(false);
				loadBtn.setEnabled(true);

			}
			else
			{
				loadBtn.setEnabled(true);
				insertBtn.setEnabled(true);
				updateBtn.setEnabled(false);
				deleteBtn.setEnabled(false);
				refreshBtn.setEnabled(false);
			}
		}
		else if(command.equals(updateBtn.getText()))
		{
			Appointment appt = new Appointment();
			
			appt.setSerialNo(serialTF.getText());
			appt.setApptDate(appdateTF.getText());
			appt.setDoctorName(doctorTF.getText());
			
			ar.updateInDB(appt);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			serialTF.setText("");
			appdateTF.setText("");
			doctorTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);

			serialTF.setEnabled(true);
			appdateTF.setEnabled(true);
			doctorTF.setEnabled(true);
			
		}
		else if(command.equals(deleteBtn.getText()))
		{
			ar.deleteFromDB(serialTF.getText());
			//ur.deleteUser(idTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			serialTF.setText("");
			appdateTF.setText("");
			doctorTF.setText("");
			
			serialTF.setEnabled(true);
			appdateTF.setEnabled(true);
			doctorTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = ar.getAllAppointment();
			String head[] = {"Serial No", "Appointment Date","Doctor Name"};
			
			panel.remove(aTableSP);
			
			aTable = new JTable(data,head);
			aTable.setEnabled(false);
			aTableSP = new JScrollPane(aTable);
			aTableSP.setBounds(350, 100, 400, 150);
			panel.add(aTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(backBtn.getText()))
		{
			if(user.getStatus()==0)
			{
				DoctorHome dh = new DoctorHome(user);
				dh.setVisible(true);
				this.setVisible(false);
			}
			else if(user.getStatus()==0)
			{
				StaffHome sh = new StaffHome(user);
				sh.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				PatientHome ph = new PatientHome(user);
				ph.setVisible(true);
				this.setVisible(false);
			}
		}
		else if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
	
}