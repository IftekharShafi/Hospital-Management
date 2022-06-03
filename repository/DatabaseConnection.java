package repository;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseConnection
{
	Connection con;
	Statement st;
	ResultSet result;

	public DatabaseConnection(){}
	public void openConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system", "root", "");
			st = con.createStatement();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	
	public void closeConnection()
	{
		try
		{
			if(con!=null){con.close();}
			if(st!=null){st.close();}
			if(result!=null){result.close();}
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
}
