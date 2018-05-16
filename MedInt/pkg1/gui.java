package pkg1;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

//Tomal
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
//

import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Container;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import java.lang.NullPointerException;

import mi.medicineInfo;
import db.DBData;
import EventHandler.EventHandler;


//imageBackground
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class gui 
{
	public JButton exit_b; 
	public JButton clear_b = new JButton();
	public JButton insert_b;
	public JFrame insertFrame;
	public JButton Delete_b;
	public JButton update_b;
	public JButton addUser_b;
	public JButton deleteUser_b;
	public JFrame frame;
	public JLabel label_search;
	public JTextField textbox_search;
	public JTable table;
	public JTextField txt_ProductId;
	public JTextField txt_Name;
	public JTextField txt_Quantity;
	public JTextField txt_Price;
	public JTextField txt_ProductId_update;
	public JTextField txt_Name_update;
	public JTextField txt_Quantity_update;
	public JTextField txt_Price_update;
	
	public JButton insertData;
	public JScrollPane scrollPane;
	public JComboBox <medicineInfo> medicineInfoCombo;
	
	public gui()
	{
		//Add Main Frame
		frame=new JFrame();
		frame.setTitle("Medicine Inventory System");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(800,700);
		frame.setLocationRelativeTo(null);
		mainGui();
		updatTable();
	}
	public void mainGui()
	{
		
		
       	//addimage
		
		 try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E://Samrat//MedInt//resources//test7.jpg")))));
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
		//Creating EventHandler
		EventHandler eh=new EventHandler(this);
		
		//delete user button
		deleteUser_b = new JButton("DELETE USER");
		frame.add(deleteUser_b);
		deleteUser_b.setBounds(220,600,115,30);
		deleteUser_b.addActionListener(eh);
		
		
		//add user button
		addUser_b = new JButton("ADD USER");
		frame.add(addUser_b);
		addUser_b.setBounds(80,600,100,30);
		addUser_b.addActionListener(eh);
				
		
		//EXIT BUTTON
		exit_b = new JButton("EXIT");
		frame.add(exit_b);
		exit_b.setBounds(860,600,115,30);
		exit_b.addActionListener(eh);
		
		
		//CLEAR BUTTON
		clear_b = new JButton("CLEAR");
		frame.add(clear_b);
		clear_b.setBounds(860,310,100,30);
		clear_b.addActionListener(eh);
		
		
		
		
	
		//Label
		
		
		JLabel update_label1=new JLabel();
		frame.add(update_label1);
		update_label1.setBounds(750,100,100,65);
		update_label1.setText("Product ID");
		update_label1.setForeground(Color.white);
		
		JLabel update_label_1=new JLabel();
		frame.add(update_label_1);
		update_label_1.setBounds(750,150,100,65);
		update_label_1.setText("Name");
		update_label_1.setForeground(Color.white);
		
		JLabel update_label_2=new JLabel();
		frame.add(update_label_2);
		update_label_2.setBounds(750,200,100,65);
		update_label_2.setText("Quantity");
		update_label_2.setForeground(Color.white);
		
		JLabel update_label_3=new JLabel();
		frame.add(update_label_3);
		update_label_3.setBounds(750,250,100,65);
		update_label_3.setText("Price");
		update_label_3.setForeground(Color.white);
		
		//TextField
		txt_ProductId_update = new JTextField();
		txt_ProductId_update.setBounds(830,120,130,25);
		frame.add(txt_ProductId_update);
						
		txt_Name_update = new JTextField();
		txt_Name_update.setBounds(830,170,130,25);
		frame.add(txt_Name_update);
		
		txt_Quantity_update = new JTextField();
		txt_Quantity_update.setBounds(830,220,130,25);
		frame.add(txt_Quantity_update);
				
		txt_Price_update = new JTextField();
		txt_Price_update.setBounds(830,270,130,25);
		frame.add(txt_Price_update);
				
		//ADD Button
		insert_b = new JButton("INSERT DATA");
		frame.add(insert_b);
		insert_b.setBounds(540,600,115,30);
		//insert_b.addActionListener(eh);
		insert_b.addActionListener(new ActionListener() 
				{
			//Override
									
			public void actionPerformed(ActionEvent arg0) 
				{
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/medicine_info?useSSL=true", "root", "root");
						Statement stmt=(Statement) con.createStatement();
						String query="insert into medint (name,quantity,price) values ('"+txt_ProductId_update.getText()+"','"+txt_Name_update.getText()+"','"+txt_Quantity_update.getText()+"',"+txt_Price_update.getText()+")";
						stmt.executeUpdate(query);
						
						JOptionPane.showMessageDialog(null,"Data Inserted");
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null,"Data Not Inserted");
					}
					updatTable();		
				}
			});
			
		
		
		
		//Update Button
		update_b = new JButton("UPDATE DATA");
		frame.add(update_b);
		update_b.setBounds(380,600,115,30);
		update_b.addActionListener(new ActionListener() 
		{
			//Override
			public void actionPerformed(ActionEvent arg0) 
			{
				try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/medicine_info?useSSL=true", "root", "root");
						Statement stmt=(Statement) con.createStatement();
						System.out.println("\n---> Update Button Pressed\n");
						String query="UPDATE medint SET ID ='"+txt_ProductId_update.getText()+"', NAME='"+txt_Name_update.getText()+"',QUANTITY='"+txt_Quantity_update.getText()+"', PRICE="+txt_Price_update.getText()+" where ID="+txt_ProductId_update.getText();
						stmt.executeUpdate(query);
						//fireTableDataChanged();
						JOptionPane.showMessageDialog(null,"Data Updated");
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null,"Data Not Updated");
					}
					updatTable();
				
			}
		});	
		
		
		
		//search button
		JButton search=new JButton();
		search = new JButton("SEARCH NAME");
		frame.add(search);
		search.setBounds(690,50,120,30);
		//search.addActionListener(eh);
				
	    search.addActionListener(new ActionListener() 
		{
			//Override
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("printing from search button");
				System.out.println("Name = "+textbox_search.getText());
                 try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/medicine_info?useSSL=true", "root", "root");
					 
				Statement stmt=(Statement) con.createStatement();
				String query=("SELECT * FROM medint WHERE name='"+textbox_search.getText()+ "'");
				ResultSet rs=stmt.executeQuery(query);
					if(rs.next())
				{
					txt_ProductId_update.setText(rs.getString("id"));
					txt_Name_update.setText(rs.getString("name"));
					txt_Quantity_update.setText(rs.getString("quantity"));
					txt_Price_update.setText(rs.getString("price"));
					JOptionPane.showMessageDialog(null,"Data Found");
				}
				
				else
				{
					JOptionPane.showMessageDialog(null," No Data Found");
				}
				}
				
				catch(Exception ex)
				{
					
									
				}			
			}
		});
		
		
		//Search Text Box
		this.textbox_search = new JTextField();
		this.textbox_search.setBounds(830,50,130,25);
		this.frame.add(textbox_search);
		
		
		//Delete Button
		Delete_b = new JButton("DELETE DATA");
		frame.add(Delete_b);
		Delete_b.setBounds(700,600,115,30);
			
			Delete_b.addActionListener(new ActionListener() 
			{
			//Override
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/medicine_info?useSSL=true", "root", "root");
					Statement stmt=(Statement) con.createStatement();
					System.out.println("\n---> DELETE Button Pressed\n");
					String query= "DELETE FROM medint WHERE ID ="+txt_ProductId_update.getText();						
					//fireTableDataChanged();
					stmt.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Data Deleted");
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Data Not Deleted");
				}
				updatTable();
			}
			});
		
		
		
		
		
		frame.pack();
		frame.setBounds(0,0,1000,700);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
	}
	
	public void updatTable()
	{
		//Add medicineInfoList to gui
		ArrayList<medicineInfo> medicineInfoList = DBData.getmedicineInfoList();
		
		// ScrollPane for Table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100,100,600, 400);
		frame.add(scrollPane);
		
		
		// Creating Table
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		
		// Model for Table
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
				
		// Model for Table
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Price");
		model.addColumn("Quantity");
			
		model.setRowCount(0);
		for(int i=0;i<medicineInfoList.size();i++)
		{
			model.addRow(new Object[0]);
			model.setValueAt(medicineInfoList.get(i).getID(), i, 0);
			model.setValueAt(medicineInfoList.get(i).getName(), i, 1);
			model.setValueAt(medicineInfoList.get(i).getPrice(), i, 2);
			model.setValueAt(medicineInfoList.get(i).getQuantity(), i, 3);
		}
		
		table.setModel(model);
		model.fireTableDataChanged();
	}
	
}




   	




















	
