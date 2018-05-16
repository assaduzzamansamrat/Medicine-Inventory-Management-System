package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mi.medicineInfo;


public class DBData
{
	public static ArrayList<medicineInfo> getmedicineInfoList()
		{
			ArrayList<medicineInfo> medicineInfoList = new ArrayList<medicineInfo>();
			try 
			{
				Connection conn = DBConPro.getDBConnection(); //Get the Dbconn from DBConnectionProvider
				Statement stmt = conn.createStatement(); //Create Statement to execute query 
				String query = "\nSELECT * FROM medint";
				//System.out.println(query);
				ResultSet rs = stmt.executeQuery(query);

				while(rs.next())
				{
					medicineInfo medicineInfo = new medicineInfo();
					medicineInfo.setID(rs.getString("ID"));
					medicineInfo.setName(rs.getString("Name"));
					medicineInfo.setPrice(rs.getString("Price"));
					medicineInfo.setQuantity(rs.getString("Quantity"));
					medicineInfoList.add(medicineInfo);  
				}
				
			}
			
			catch (Exception ex) 
			{
				System.out.println(ex.getMessage());
			}
			
			/*
			for(int i=0;i<medicineInfoList.size();i++)
			{
				System.out.println(medicineInfoList.get(i).getName());
			}
			*/
			
			return medicineInfoList;
		}

	/*
	public static void main(String arg[])
	{
		DBData.getmedicineInfoList();	
	}
	*/
}
