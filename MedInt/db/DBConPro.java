package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConPro 
{
    static Connection conn = null;
	
    public static Connection getDBConnection()
	{
		
		if (conn == null) 
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/medicine_info?useSSL=true", "root", "root");
				System.out.println("\n---> Connected to DataBase\n");
			} 
			
			catch (Exception e) 
			{
				e.printStackTrace();
				System.out.println("/n---> Failed to get DBConn:: "+e.getMessage());
			}
			return conn;
	
		}
		else
            return conn;
	
    }
	
}



