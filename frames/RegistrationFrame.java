package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class RegistrationFrame extends JFrame implements ActionListener, MouseListener
{
	private JLabel idLabel,passLabel,statusLabel;
	private JTextField idTF,statusTF;
	private JPasswordField passPF;
	private JButton creatBtn,backBtn,showBtn;
	private JPanel panel;
	private Color color;
	
	private UserRepo ur;
	private User user;
	
	public RegistrationFrame()
	{
		super("Registration");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ur = new UserRepo();
		
		
		color = new Color(255,255,255);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(color);
		
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
		
		showBtn = new JButton("Show");
		showBtn.setBounds(440,150,80,30);
		showBtn.setBackground(Color.WHITE);
		showBtn.addMouseListener(this);
		panel.add(showBtn);
		
		passPF = new JPasswordField();
		passPF.setBounds(330,150,100,30);
		passPF.setEchoChar('*');
		panel.add(passPF);

		statusLabel = new JLabel("Status :");
		statusLabel.setBounds(255, 200,100 ,50);
		statusLabel.setBackground(Color.WHITE);
		panel.add(statusLabel);
		passLabel.setOpaque(true);
		
		statusTF = new JTextField();
		statusTF.setBounds(330,200,100,30);
		panel.add(statusTF);
		
		creatBtn = new JButton("Create");
		creatBtn.setBounds(260,270,80,30);
		creatBtn.setBackground(Color.GREEN);
		creatBtn.addActionListener(this);
		panel.add(creatBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(400,270,80,30);
		backBtn.setBackground(Color.CYAN);
		backBtn.addActionListener(this);
		panel.add(backBtn);
	
		this.add(panel);
	
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		if(command.equals(creatBtn.getText()))
		{
			this.user = new User(idTF.getText(),passPF.getText(),Integer.parseInt(statusTF.getText()));

			ur.insertUser(this.user);

			JOptionPane.showMessageDialog(this, "created, Id: "+idTF.getText()+" and Password: "+passPF.getText());

			idTF.setText("");
			passPF.setText("");
			statusTF.setText("");
		}
		else if(command.equals(backBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	