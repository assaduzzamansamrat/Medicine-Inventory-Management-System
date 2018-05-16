package pkg1;
import pkg1.gui;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import db.DBConPro;



//imageBackground
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;





//Samrat

public class DeleteUserGui {
	public JFrame DeleteuserFrame;
	public JLabel userNameLabel;
	public JTextField userNameTextField;
	public JButton okButton;
	public JButton exitButton;
	
	
   public DeleteUserGui(){
		
		this.DeleteuserFrame = new JFrame("Medicine Inventory Management System");
		this.DeleteuserFrame.setBounds(250, 50, 40, 40);
		this.DeleteuserFrame.setVisible(true);
		this.DeleteuserFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.DeleteuserFrame.setLayout(null);
		


           	//addimage
		
		 try {
            DeleteuserFrame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E://Samrat//MedInt//resources//test.jpg")))));
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
					
        
	
		
	    //username label
		userNameLabel=new JLabel();
        userNameLabel.setBounds(250,250,100,20);
		userNameLabel.setText("USER NAME  ");
		this.DeleteuserFrame.add(userNameLabel);
		this.userNameLabel.setForeground(Color.white);
		
		//usernameTextField
        userNameTextField = new JTextField();
        userNameTextField.setBounds(330,250,160,30);
		this.DeleteuserFrame.add(userNameTextField);
	     
		
		
		//okButton
        okButton = new JButton("OK");
		DeleteuserFrame.add(okButton);
		okButton.setBounds(410,300,80,30);
        okButton.addActionListener(new ActionListener()
		{
			   
			
			//Override
			public void actionPerformed(ActionEvent arg0) {

			try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/medicine_info?useSSL=true", "root", "root");
						Statement stmt=(Statement) con.createStatement();
						String query= "DELETE  FROM medicine_info.admin WHERE username ='"+userNameTextField.getText()+"'";	
						stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(null,"User successfully deleted");
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null,"Failed to delete user");
					}
					
			}
			});	

		//Exit button
		exitButton = new JButton("EXIT");
		DeleteuserFrame.add(exitButton);
		exitButton.setBounds(680,500,80,30);
		exitButton.addActionListener(new ActionListener()
		{
			
			//Override

			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("Exit pressed");
				System.exit(0);
				
				
			    
				
			}

		});	
		
		
    
		
		
		this.DeleteuserFrame.pack();
		
	//	DeleteuserFrame.setLocationRelativeTo(null);
	//	DeleteuserFrame.setResizable(true);
		
	}

	
		
	

}


	
