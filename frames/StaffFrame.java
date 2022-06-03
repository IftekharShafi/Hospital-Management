package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class StaffFrame extends JFrame implements ActionListener
{
	JLabel idLabel,nameLabel,mobilenoLabel,salaryLabel,jobtitleLabel;
	JTextField idTF,nameTF,mobilenoTF, salaryTF,jobtitleTF;
	JButton loadBtn,insertBtn,updateBtn,deleteBtn,refreshBtn,getAllBtn,backBtn,logoutBtn;
	JPanel panel;
	JTable sTable;
	JScrollPane sTableSP;
	Color color;
	
	User user;
	StaffMemberRepo sr;
	UserRepo ur;
	
	
	public StaffFrame(User user)
	{
		super("StaffMemeberFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		sr = new StaffMemberRepo();
		ur = new UserRepo();

		color = new Color(255,255,255);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(color);
		
		String data[][] = {{"", "", "", ""," "}};
		
		String head[] = {"Staff ID", "Staff Name", "Mobile No.", "Job Title"};
		
		sTable = new JTable(data,head);
		sTableSP = new JScrollPane(sTable);
		sTableSP.setBounds(350, 100, 400, 150);
		sTable.setEnabled(false);
		panel.add(sTableSP);
		
		 
		idLabel = new JLabel("ID :");
		idLabel.setBounds(50, 40,300 ,50);
		idLabel.setBackground(Color.WHITE);
		panel.add(idLabel);
		idLabel.setOpaque(true);
		
		idTF = new JTextField();
		idTF.setBounds(90,50,100,30);
		panel.add(idTF);
		
		nameLabel = new JLabel("Name :");
		nameLabel.setBounds(30, 80,300 ,50);
		nameLabel.setBackground(Color.WHITE);
		panel.add(nameLabel);
		nameLabel.setOpaque(true);
		
		nameTF = new JTextField();
		nameTF.setBounds(90,90,100,30);
		panel.add(nameTF);
		
		mobilenoLabel = new JLabel("Mobile No :");
		mobilenoLabel.setBounds(8, 120,300 ,50);
		mobilenoLabel.setBackground(Color.WHITE);
		panel.add(mobilenoLabel);
		mobilenoLabel.setOpaque(true);
		
		mobilenoTF = new JTextField();
		mobilenoTF.setBounds(90,130,100,30);
		panel.add(mobilenoTF);
		
		salaryLabel = new JLabel("Salary :");
		salaryLabel.setBounds(25, 160,300 ,50);
		salaryLabel.setBackground(Color.WHITE);
		panel.add(salaryLabel);
		salaryLabel.setOpaque(true);
		
		salaryTF = new JTextField();
		salaryTF.setBounds(90,170,100,30);
		panel.add(salaryTF);
		
		jobtitleLabel = new JLabel("Job Title :");
		jobtitleLabel.setBounds(15, 200,300 ,50);
		jobtitleLabel.setBackground(Color.WHITE);
		panel.add(jobtitleLabel);
		jobtitleLabel.setOpaque(true);
		
		jobtitleTF = new JTextField();
		jobtitleTF.setBounds(90,210,100,30);
		panel.add(jobtitleTF);
		
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
			if(!idTF.getText().equals("") || !idTF.getText().equals(null))
			{
				StaffMember s = sr.searchStaffMember(idTF.getText());
				if(s!= null)
				{
					nameTF.setText(s.getSName());
					jobtitleTF.setText(s.getJobTitle());
					salaryTF.setText(s.getSSalary()+"");
					mobilenoTF.setText(s.getSMobileNo());
					
					idTF.setEnabled(false);
					nameTF.setEnabled(true);
					jobtitleTF.setEnabled(true);
					salaryTF.setEnabled(true);
					mobilenoTF.setEnabled(true);

					if(this.user.getStatus()==0||this.user.getStatus()==1)
					{
						updateBtn.setEnabled(true);
						deleteBtn.setEnabled(true);
						refreshBtn.setEnabled(true);
						insertBtn.setEnabled(false);
						loadBtn.setEnabled(false);
					}
					else
					{
						updateBtn.setEnabled(false);
						deleteBtn.setEnabled(false);
						refreshBtn.setEnabled(true);
						insertBtn.setEnabled(false);
						loadBtn.setEnabled(false);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			StaffMember s = new StaffMember();
			User u = new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			s.setSId(idTF.getText());
			s.setSName(nameTF.getText());
			s.setJobTitle(jobtitleTF.getText());
			s.setSSalary(Double.parseDouble(salaryTF.getText()));
			s.setSMobileNo(mobilenoTF.getText());
			
			u.setUserId(idTF.getText());
			u.setPassword(x+"");
			u.setStatus(1);
			
			sr.insertInDB(s);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+idTF.getText()+"and Password: "+x);
			
			nameTF.setText("");
			mobilenoTF.setText("");
			salaryTF.setText("");
			jobtitleTF.setText("");

			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			idTF.setText("");
			nameTF.setText("");
			mobilenoTF.setText("");
			salaryTF.setText("");
			jobtitleTF.setText("");
			
			idTF.setEnabled(true);
			
			if(this.user.getStatus()==0||this.user.getStatus()==1)
			{
				loadBtn.setEnabled(true);
				insertBtn.setEnabled(true);
				updateBtn.setEnabled(false);
				deleteBtn.setEnabled(false);
				refreshBtn.setEnabled(false);

			}
			else
			{
				updateBtn.setEnabled(false);
				deleteBtn.setEnabled(false);
				refreshBtn.setEnabled(true);
				insertBtn.setEnabled(false);
				loadBtn.setEnabled(true);
			}
		}
		else if(command.equals(updateBtn.getText()))
		{
			StaffMember s = new StaffMember();
			
			s.setSId(idTF.getText());
			s.setSName(nameTF.getText());
			s.setSMobileNo(mobilenoTF.getText());
			s.setSSalary(Double.parseDouble(salaryTF.getText()));
			s.setJobTitle(jobtitleTF.getText());
			
			sr.updateInDB(s);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			idTF.setText("");
			nameTF.setText("");
			mobilenoTF.setText("");
			salaryTF.setText("");
			jobtitleTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);

			idTF.setEnabled(true);
			nameTF.setEnabled(true);
			mobilenoTF.setEnabled(true);
			salaryTF.setEnabled(true);
			jobtitleTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			sr.deleteFromDB(idTF.getText());
			ur.deleteUser(idTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			idTF.setText("");
			nameTF.setText("");
			mobilenoTF.setText("");
			salaryTF.setText("");
			jobtitleTF.setText("");
			
			idTF.setEnabled(true);
			nameTF.setEnabled(true);
			mobilenoTF.setEnabled(true);
			salaryTF.setEnabled(true);
			jobtitleTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = sr.getAllStaffMember();
			String head[] = {"Staff ID", "Staff Name", "Mobile No.","StaffMember Salary", "Job Title"};
			
			panel.remove(sTableSP);
			
			sTable = new JTable(data,head);
			sTable.setEnabled(false);
			sTableSP = new JScrollPane(sTable);
			sTableSP.setBounds(350, 100, 400, 150);
			panel.add(sTableSP);
			
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
			else if(user.getStatus()==1)
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