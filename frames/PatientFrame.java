package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class PatientFrame extends JFrame implements ActionListener
{
	JLabel idLabel,nameLabel,ageLabel,genderLabel;
	JTextField idTF,nameTF,ageTF,genderTF;
	JButton loadBtn,insertBtn,updateBtn,deleteBtn,refreshBtn,getAllBtn,backBtn,logoutBtn;
	JPanel panel;
	JTable pTable;
	JScrollPane pTableSP;
	Color color;
	
	User user;
	PatientRepo pr;
	UserRepo ur;
	
	public PatientFrame(User user)
	{
		super("PatientFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		pr = new PatientRepo();
		ur = new UserRepo();

		color = new Color(255,255,255);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(color);
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"Patient ID", "Patient Name", "Patient Age","Patient Gender"};
		
		pTable = new JTable(data,head);
		pTableSP = new JScrollPane(pTable);
		pTableSP.setBounds(350, 100, 400, 150);
		pTable.setEnabled(false);
		panel.add(pTableSP);
		
		 
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
		
		ageLabel = new JLabel("Age :");
		ageLabel.setBounds(30, 120,300 ,50);
		ageLabel.setBackground(Color.WHITE);
		panel.add(ageLabel);
		ageLabel.setOpaque(true);
		
		ageTF = new JTextField();
		ageTF.setBounds(90,130,100,30);
		panel.add(ageTF);

		genderLabel = new JLabel("Gender:");
		genderLabel.setBounds(25,160,300,50);
		genderLabel.setBackground(Color.WHITE);
		panel.add(genderLabel);
		genderLabel.setOpaque(true);
		
		genderTF = new JTextField();
		genderTF.setBounds(90,170,100,30);
		panel.add(genderTF);
		
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
				Patient p = pr.searchPatient(idTF.getText());
				if(p!= null)
				{

					nameTF.setText(p.getPName());
					ageTF.setText(p.getPAge()+"");
					genderTF.setText(p.getPGender());
					
					idTF.setEnabled(false);
					nameTF.setEnabled(true);
					ageTF.setEnabled(true);
					genderTF.setEnabled(true);
					
					if(this.user.getStatus()==3)
					{
						updateBtn.setEnabled(false);
						deleteBtn.setEnabled(false);
						refreshBtn.setEnabled(true);
						insertBtn.setEnabled(false);
						loadBtn.setEnabled(false);

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
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Patient p = new Patient();
			User u = new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			p.setPId(idTF.getText());
			p.setPName(nameTF.getText());
			p.setPAge(Integer.parseInt(ageTF.getText()));
			p.setPGender(genderTF.getText());
			
			u.setUserId(idTF.getText());
			u.setPassword(x+"");
			u.setStatus(2);
			
			pr.insertInDB(p);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+idTF.getText()+"and Password: "+x);
			
			nameTF.setText("");
			ageTF.setText("");

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
			ageTF.setText("");
			genderTF.setText("");
			
			idTF.setEnabled(true);

			if(this.user.getStatus()==3)
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
			Patient p = new Patient();
			
			p.setPId(idTF.getText());
			p.setPName(nameTF.getText());
			p.setPAge(Integer.parseInt(ageTF.getText()));
			p.setPGender(genderTF.getText());
			
			pr.updateInDB(p);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			idTF.setText("");
			nameTF.setText("");
			ageTF.setText("");
			genderTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);

			idTF.setEnabled(true);
			nameTF.setEnabled(true);
			ageTF.setEnabled(true);
			genderTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			pr.deleteFromDB(idTF.getText());
			ur.deleteUser(idTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			idTF.setText("");
			nameTF.setText("");
			ageTF.setText("");
			genderTF.setText("");
			
			
			idTF.setEnabled(true);
			nameTF.setEnabled(true);
			ageTF.setEnabled(true);
			genderTF.setEnabled(true);
			
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = pr.getAllPatient();
			String head[] = {"Patient ID", "Patient Name", "Age","Gender"};
			
			panel.remove(pTableSP);
			
			pTable = new JTable(data,head);
			pTable.setEnabled(false);
			pTableSP = new JScrollPane(pTable);
			pTableSP.setBounds(350, 100, 400, 150);
			panel.add(pTableSP);
			
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