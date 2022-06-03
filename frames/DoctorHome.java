package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class DoctorHome extends JFrame implements ActionListener
{
    JButton mdBtn,msmBtn,mpBtn,maBtn,cpBtn,logoutBtn;
	JPanel panel;
	Color color;
	User user;
	
	public DoctorHome(User user)
	{
		super("DoctorHome");
		this.setSize(850,500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.user=user;
		
		
		color = new Color(150,250,204);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(color);
		 
		mdBtn = new JButton("Manage Doctor");
		mdBtn.setBounds(20, 40,130 ,30);
		mdBtn.addActionListener(this);
		panel.add(mdBtn);
		mdBtn.setOpaque(true);
		
		msmBtn = new JButton("Manage Staff Member");
		msmBtn.setBounds(170, 40,160 ,30);
		msmBtn.addActionListener(this);
		panel.add(msmBtn);
		msmBtn.setOpaque(true);
		
		mpBtn = new JButton("Manage Patient");
		mpBtn.setBounds(350, 40,130 ,30);
		mpBtn.addActionListener(this);
		panel.add(mpBtn);
		mpBtn.setOpaque(true);
		
		maBtn = new JButton("Appointment");
		maBtn.setBounds(500, 40,130 ,30);
		maBtn.addActionListener(this);
		panel.add(maBtn);
		maBtn.setOpaque(true);
		
		cpBtn = new JButton("Change Password");
		cpBtn.setBounds(650, 40,160 ,30);
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
		else if(command.equals(mdBtn.getText()))
		{
			if(user.getStatus()==0)
			{
				DoctorFrame df = new DoctorFrame(user);
				df.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		else if(command.equals(msmBtn.getText()))
		{
			if(user.getStatus()==0)
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
			if(user.getStatus()==0)
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
			if(user.getStatus()==0)
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
			if(user.getStatus()==0)
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	