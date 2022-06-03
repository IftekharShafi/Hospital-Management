package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

import entity.*;
import repository.*;


public class LoginFrame extends JFrame implements ActionListener, MouseListener
{
	JLabel idLabel,passLabel,titleLabel;
	JTextField idTF;
	JPasswordField passPF;
	JButton regBtn,loginBtn,exitBtn,showPassBtn;
	JPanel panel;
	Color color;
	
	
	public LoginFrame()
	{
		super("Hospital Managment System");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		color = new Color(255,255,255);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(color);
		
		titleLabel = new JLabel("Hospital Managment System");
		titleLabel.setBounds(300,30,250,50);
		panel.add(titleLabel);
		 
		idLabel = new JLabel("ID :");
		idLabel.setBounds(300, 80,50 ,50);
		idLabel.setBackground(Color.WHITE);
		panel.add(idLabel);
		idLabel.setOpaque(true);
		
		idTF = new JTextField();
		idTF.setBounds(330,90,100,30);
		panel.add(idTF);
		
		passLabel = new JLabel("Password :");
		passLabel.setBounds(255, 140,100 ,50);
		passLabel.setBackground(Color.WHITE);
		panel.add(passLabel);
		passLabel.setOpaque(true);
		
		passPF = new JPasswordField();
		passPF.setBounds(330,150,100,30);
		passPF.setEchoChar('*');
		panel.add(passPF);
        
		
		showPassBtn = new JButton("Show");
		showPassBtn.setBounds(470,150,80,30);
		showPassBtn.addMouseListener(this);
		panel.add(showPassBtn);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(260,220,80,30);
		loginBtn.setBackground(Color.GREEN);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(400,220,80,30);
		exitBtn.setBackground(Color.RED);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		regBtn = new JButton("Registration Now");
		regBtn.setBounds(300,300,150,30);
		regBtn.setBackground(Color.GREEN);
		regBtn.addActionListener(this);
		panel.add(regBtn);
		
		
		
		this.add(panel);
	
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
			UserRepo ur = new UserRepo();
			User user = ur.getUser(idTF.getText(), passPF.getText());
				
			if(user != null)
			{
				if(user.getStatus() == 0 )
				{
					DoctorHome dh = new DoctorHome(user);
					dh.setVisible(true);
					this.setVisible(false);
				}
				else if(user.getStatus() == 1)
				{
					StaffHome sh = new StaffHome(user);
					sh.setVisible(true);
					this.setVisible(false);
				}
				else if(user.getStatus() == 2)
				{
					PatientHome ph = new PatientHome(user);
					ph.setVisible(true);
					this.setVisible(false);
				}
				else{}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invaild Id or Password");
			}
			
		}
		else if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		else if(command.equals(regBtn.getText()))
		{
			RegistrationFrame rf = new RegistrationFrame();
			rf.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me)
	{
		passPF.setEchoChar((char)0);
	}
	public void mouseReleased(MouseEvent me)
	{
		passPF.setEchoChar('*');
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
			
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	