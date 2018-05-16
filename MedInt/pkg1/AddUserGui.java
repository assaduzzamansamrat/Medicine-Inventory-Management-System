package pkg1;
import pkg1.gui;
import pkg1.LoginGui;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import db.DBConPro;
import EventHandler.EventHandler;



//imageBackground
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;





//Samrat

public class AddUserGui {
	public JFrame AdduserFrame;
	public JLabel userNameLabel;
	public JLabel passwordLabel;
	public JLabel userIdLabel;
	public JTextField userNameTextField;
	public JPasswordField userPasswordTextField;
	public JTextField userIdTextField;
	public JButton okButton;
	public JButton exitButton;
	
	
   public AddUserGui(){
		
		this.AdduserFrame = new JFrame("Medicine Inventory Management System");
		this.AdduserFrame.setBounds(250, 50, 700, 500);
		this.AdduserFrame.setVisible(true);
		this.AdduserFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.AdduserFrame.setLayout(null);


           	//addimage
		
		 try {
            AdduserFrame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E://Samrat//MedInt//resources//test.jpg")))));
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
					
        
		
		//userIDLabel
        userIdLabel=new JLabel();
        userIdLabel.setBounds(250,200,100,20);
		userIdLabel.setText("USER ID  ");
		this.AdduserFrame.add(userIdLabel);
		this.userIdLabel.setForeground(Color.white);
		
		//useridTextField
		userIdTextField = new JTextField();
		userIdTextField.setBounds(340,200,160,30);
		this.AdduserFrame.add(userIdTextField);
		
	    //username label
		userNameLabel=new JLabel();
        userNameLabel.setBounds(250,250,100,20);
		userNameLabel.setText("USER NAME  ");
		this.AdduserFrame.add(userNameLabel);
		this.userNameLabel.setForeground(Color.white);
		
		//usernameTextField
        userNameTextField = new JTextField();
        userNameTextField.setBounds(340,250,160,30);
		this.AdduserFrame.add(userNameTextField);
		
		//password label
		passwordLabel=new JLabel();
        passwordLabel.setBounds(250,300,100,20);
		passwordLabel.setText("PASSWORD  ");
		this.AdduserFrame.add(passwordLabel);
		this.passwordLabel.setForeground(Color.white);
		
		//userpasswordTextField
        userPasswordTextField = new JPasswordField();
        userPasswordTextField.setBounds(340,300,160,30);
		this.AdduserFrame.add(userPasswordTextField);
	     
		
		
		//okButton
        okButton = new JButton("OK");
		AdduserFrame.add(okButton);
		okButton.setBounds(420,340,80,30);
		okButton.addActionListener(new ActionListener()
		{
			   
			
			//Override
			public void actionPerformed(ActionEvent arg0) {
				 char [] password=userPasswordTextField.getPassword();
				String Pass= String.valueOf(password);
				System.out.println("pass :"+Pass);

			try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/medicine_info?useSSL=true", "root", "root");
						Statement stmt=(Statement) con.createStatement();
						String query="insert into admin(adminid,username,password) values ('"+userIdTextField.getText()+"','"+userNameTextField.getText()+"','"+Pass+"')";
						stmt.executeUpdate(query);
						
						JOptionPane.showMessageDialog(null,"User successfully added");
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null,"Failed to user");
					}
					
			}
			         
			}
			
			);	

		//Exit button
		exitButton = new JButton("EXIT");
		AdduserFrame.add(exitButton);
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
		
						
    
		
	
		
		
		this.AdduserFrame.pack();
		
	}

	
		
	

}


	
