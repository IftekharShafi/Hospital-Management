package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class PatientHome extends JFrame implements ActionListener
{
    JButton vdBtn,vsmBtn,cpBtn,logoutBtn,vappBtn; //,vpBtn
	JPanel panel;
	Color color;
	User user;
	
	public PatientHome(User user)
	{
		super("PatientHome");
		this.setSize(850,500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.user=user;
		
		
		color = new Color(150,250,204);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(color);
		 
		vdBtn = new JButton("View Doctor");
		vdBtn.setBounds(20, 40,130 ,30);
		vdBtn.addActionListener(this);
		panel.add(vdBtn);
		vdBtn.setOpaque(true);
		
		vsmBtn = new JButton("View Staff Member");
		vsmBtn.setBounds(200, 40,160 ,30);
		vsmBtn.addActionListener(this);
		panel.add(vsmBtn);
		vsmBtn.setOpaque(true);
		
		/*vpBtn = new JButton("View Patient");
		vpBtn.setBounds(420, 40,130 ,30);
		vpBtn.addActionListener(this);
		panel.add(vpBtn);
		vpBtn.setOpaque(true);*/
		
		vappBtn = new JButton("View Appointment");
		vappBtn.setBounds(20, 100,180 ,30);
		vappBtn.addActionListener(this);
		panel.add(vappBtn);
		vappBtn.setOpaque(true);
		
		cpBtn = new JButton("Change Password");
		cpBtn.setBounds(600, 40,180 ,30);
		cpBtn.addActionListener(this);
		panel.add(cpBtn);
		cpBtn.setOpaque(true);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(700,400,80,30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		this.add(panel);
		
		
	}  
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(vsmBtn.getText()))
		{
			if(user.getStatus()==2)
			{
				StaffFrame sf = new StaffFrame(user);
				sf.setVisible(true);
				this.setVisible(false);

				sf.updateBtn.setEnabled(false);
				sf.deleteBtn.setEnabled(false);
				sf.refreshBtn.setEnabled(true);
				sf.insertBtn.setEnabled(false);
				sf.loadBtn.setEnabled(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		else if(command.equals(vdBtn.getText()))
		{
			if(user.getStatus()==2)
			{
				DoctorFrame df = new DoctorFrame(user);
				df.setVisible(true);
				this.setVisible(false);

				df.updateBtn.setEnabled(false);
				df.deleteBtn.setEnabled(false);
				df.refreshBtn.setEnabled(true);
				df.insertBtn.setEnabled(false);
				df.loadBtn.setEnabled(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		/*lse if(command.equals(vpBtn.getText()))
		{
			if(user.getStatus()==2)
			{
				PatientFrame pf = new PatientFrame(user);
				pf.setVisible(true);
				this.setVisible(false);

				pf.updateBtn.setEnabled(false);
				pf.deleteBtn.setEnabled(false);
				pf.refreshBtn.setEnabled(true);
				pf.insertBtn.setEnabled(false);
				pf.loadBtn.setEnabled(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}*/
		else if(command.equals(vappBtn.getText()))
		{
			if(user.getStatus()==2)
			{
				AppointmentFrame af = new AppointmentFrame(user);
				af.setVisible(true);
				this.setVisible(false);

				af.updateBtn.setEnabled(false);
				af.deleteBtn.setEnabled(false);
				af.refreshBtn.setEnabled(true);
				af.insertBtn.setEnabled(false);
				af.loadBtn.setEnabled(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		else if(command.equals(cpBtn.getText()))
		{
			if(user.getStatus()==2)
			{
				ChangePassword cf = new ChangePassword(user);
				cf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		else{}
	}
	
}