package EventHandler;
import pkg1.AddUserGui;
import pkg1.DeleteUserGui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.lang.*;

import java.util.EventObject;

import pkg1.gui;

public class EventHandler implements ActionListener
		
{
	gui g;
										
	public EventHandler(gui g2)
	{
		g=g2;
		
		
	}
	
										
		
	public void actionPerformed(ActionEvent e) 
	{
        if(e.getSource() == g.clear_b)
		{
			System.out.println("\n---> CLEAR Button Pressed");
			g.textbox_search.setText("");
			g.txt_ProductId_update.setText("");
			g.txt_Name_update.setText("");
			g.txt_Price_update.setText("");
			g.txt_Quantity_update.setText("");
		}
			
		else if(e.getSource() == g.exit_b)
		{
			System.out.println("\n--->EXIT Button Pressed");
			System.exit(0);
		}
		else if(e.getSource() == g.addUser_b)
		{
			System.out.println("\n---> add user prassed");
			
			AddUserGui AUG=new AddUserGui();
		}
			
			
	    else if(e.getSource() == g.deleteUser_b)
		{
		   System.out.println("delete button pressed");
		   DeleteUserGui DUG=new DeleteUserGui();
		}
		else if(e.getSource() == g.insert_b)
		{
			System.out.println("\n---> INSERT Button Pressed");
			g.frame.setVisible(false);
			g.insertFrame.setVisible(true);
			g.insertFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			g.insertFrame.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.out.println("\n---> Close(X) button Pressed on InsertFrame");
					g.frame.setVisible(true);
					g.updatTable();
				}
			});
		}
		/*
		else if(e.getSource() == g.insertData)
		{
			try
					{
						String query="insert into medint (id,name,quantity,price) values ('"+txt_ProductId.getText()+"','"+txt_Name.getText()+"','"+txt_Quantity.getText()+"',"+txt_Price.getText()+")";
						executeSqlQuery(query,"Inserted");
						System.out.println("\n---> Inside try");
					}
					catch(Exception ex)
					{
						
					}
					System.out.println("\n---> After Inserting Value");
					updatTable();
		}
		*/
		/*
		
		System.out.println("Add Button pressed");
		
			
					try
					{
						executeSqlQuery("insert into medint (id,name,quantity,price) values ('"+txt_ProductId.getText()+"','"+txt_Name.getText()+"','"+txt_Quantity.getText()+"',"+txt_Price.getText()+")");
					}
					catch(Exception ex)
					{
						
					}
							
		}*/
		
			
	}
										
}