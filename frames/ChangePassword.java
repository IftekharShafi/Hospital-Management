package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class ChangePassword extends JFrame implements ActionListener
{
	private JLabel cpLabel,npLabel,rpLabel;
	private JPasswordField cpPF,npPF,rpPF;
	private JButton changeBtn,backBtn,showBtn1,showBtn2,showBtn3;
	private JPanel panel;
	private Color color;

	private User user;
	private UserRepo ur;
	
	
	public ChangePassword(User user) 
	{
		super("Change Password");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		ur = new UserRepo();
		
		color = new Color(255,255,255);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(color);
		 
		cpLabel = new JLabel("Enter Current Password :");
		cpLabel.setBounds(200, 80,150 ,50);
		cpLabel.setBackground(Color.WHITE);
		panel.add(cpLabel);
		cpLabel.setOpaque(true);
		
		showBtn1 = new JButton("Show");
		showBtn1.setBounds(520,90,80,30);
		showBtn1.setBackground(Color.WHITE);
		showBtn1.addActionListener(this);
		panel.add(showBtn1);
		
		cpPF = new JPasswordField();
		cpPF.setBounds(350,90,150,30);
		cpPF.setEchoChar('*');
		panel.add(cpPF);
		
		npLabel = new JLabel("Enter New Password :");
		npLabel.setBounds(220, 120,150 ,50);
		npLabel.setBackground(Color.WHITE);
		panel.add(npLabel);
		npLabel.setOpaque(true);
		
		showBtn2 = new JButton("Show");
		showBtn2.setBounds(520,130,80,30);
		showBtn2.setBackground(Color.WHITE);
		showBtn2.addActionListener(this);
		panel.add(showBtn2);
		
		npPF = new JPasswordField();
		npPF.setBounds(350,130,150,30);
		cpPF.setEchoChar('*');
		panel.add(npPF);
		
		rpLabel = new JLabel("Re-Enter New Password :");
		rpLabel.setBounds(230, 160,150 ,50);
		rpLabel.setBackground(Color.WHITE);
		panel.add(rpLabel);
		rpLabel.setOpaque(true);
		
		showBtn3 = new JButton("Show");
		showBtn3.setBounds(520,170,80,30);
		showBtn3.setBackground(Color.WHITE);
		showBtn3.addActionListener(this);
		panel.add(showBtn3);
		
		rpPF = new JPasswordField();
		rpPF.setBounds(350,170,150,30);
		cpPF.setEchoChar('*');
		panel.add(rpPF);
		
		changeBtn = new JButton("Change");
		changeBtn.setBounds(260,220,80,30);
		changeBtn.setBackground(Color.GREEN);
		changeBtn.addActionListener(this);
		panel.add(changeBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(400,220,80,30);
		backBtn.setBackground(Color.CYAN);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(changeBtn.getText()))
		{
			User u = ur.getUser(user.getUserId(),user.getPassword());

			if((cpPF.getText()).equals(user.getPassword())&&
				(npPF.getText()).equals(rpPF.getText()))
			{
				u.setUserId(user.getUserId());
				u.setPassword(npPF.getText());
				u.setStatus(user.getStatus());
				
				ur.updateUser(u);
				JOptionPane.showMessageDialog(this, "Password Changed");
			
				cpPF.setText("");
				npPF.setText("");
				rpPF.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Changing Denied");
			}
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
		else if(command.equals(showBtn1.getText()))
		{
			cpPF.setEchoChar((char)0);
		}
		else if(command.equals(showBtn2.getText()))
		{
			npPF.setEchoChar((char)0);
		}
		else if(command.equals(showBtn3.getText()))
		{
			rpPF.setEchoChar((char)0);
		}
		
	}
}