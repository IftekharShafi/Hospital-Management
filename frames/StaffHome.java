package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class StaffHome extends JFrame implements ActionListener
{
    JButton vdBtn,msmBtn,mpBtn,cpBtn,logoutBtn,maBtn;
	JPanel panel;
	Color color;
	User user;

	
	public StaffHome(User user)
	{
		super("StaffHome");
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
		
		msmBtn = new JButton("Manage Staff Member");
		msmBtn.setBounds(200, 40,160 ,30);
		msmBtn.addActionListener(this);
		panel.add(msmBtn);
		msmBtn.setOpaque(true);
		
		mpBtn = new JButton("Manage Patient");
		mpBtn.setBounds(420, 40,130 ,30);
		mpBtn.addActionListener(this);
		panel.add(mpBtn);
		mpBtn.setOpaque(true);
		
		maBtn = new JButton("Manage Appointment");
		maBtn.setBounds(20, 80,180 ,30);
		panel.add(maBtn);
			maBtn.addActionListener(this);
		maBtn.setOpaque(true);
		
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
		else if(command.equals(vdBtn.getText()))
		{
			if(user.getStatus()==1)
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
		else if(command.equals(msmBtn.getText()))
		{
			if(user.getStatus()==1)
			{
				StaffFrame sf = new StaffFrame(user);
				sf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		else if(command.equals(mpBtn.getText()))
		{
			if(user.getStatus()==1)
			{
				PatientFrame pf = new PatientFrame(user);
				pf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		else if(command.equals(maBtn.getText()))
		{
			if(user.getStatus()==1)
			{
				AppointmentFrame af = new AppointmentFrame(user);
				af.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		else if(command.equals(cpBtn.getText()))
		{
			if(user.getStatus()==1)
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