package pkg1;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.*;


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

public class LoginGui {
	public JFrame loginFrame;
	public JLabel userNameLabel;
	public JLabel passwordLabel;
	public JTextField userNameTextField;
	public JPasswordField passwordTextField;
	public JButton loginButton;
	
	
   public LoginGui(){
		
		this.loginFrame = new JFrame("Medicine Inventory Management System");
		this.loginFrame.setBounds(250, 50, 700, 500);
		this.loginFrame.setVisible(true);
		this.loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.loginFrame.setLayout(null);


           	//addimage
		
		 try {
            loginFrame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E://Samrat//MedInt//resources//test.jpg")))));
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
					
        
		
		//userNameLabel
        userNameLabel=new JLabel();
        userNameLabel.setBounds(250,200,100,20);
		userNameLabel.setText("Username : ");
		this.loginFrame.add(userNameLabel);
		this.userNameLabel.setForeground(Color.white);
		
		//userNameTextField
		userNameTextField = new JTextField();
		userNameTextField.setBounds(320,200,160,30);
		this.loginFrame.add(userNameTextField);
		
		//passwordLabel
		passwordLabel=new JLabel();
        passwordLabel.setBounds(250,250,100,20);
		passwordLabel.setText("Password : ");
		this.loginFrame.add(passwordLabel);
		this.passwordLabel.setForeground(Color.white);
		
		//passwordTextField
        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(320,250,160,30);
		this.loginFrame.add(passwordTextField);
	
		
		
		
		
		
		//loginButton
        loginButton = new JButton("Login");
		loginFrame.add(loginButton);
		loginButton.setBounds(400,300,80,30);
		loginButton.addActionListener(new ActionListener()
		{
			
			//Override

			public void actionPerformed(ActionEvent arg0) 
			{
				//Textfield_data_read
			    String userName=userNameTextField.getText();
		        char [] password=passwordTextField.getPassword();
				String str = String.valueOf(password);
				String databasePassword="";
				String databaseUsername="";
				
				System.out.println("printing from login button");
                 try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/medicine_info?useSSL=true", "root", "root");
					 
				Statement stmt=(Statement) con.createStatement();
				String query=("SELECT * FROM medicine_info.admin WHERE username='"+userNameTextField.getText()+ "'&& password='"+passwordTextField.getText()+"'");
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next())
				{
					databaseUsername = rs.getString("username");
                    databasePassword = rs.getString("password");
				}
				
				if (userName.equals(databaseUsername) && str.equals(databasePassword)) {
                  System.out.println("Successful Login!\n----");
				  gui g1 = new gui();
			//	 JOptionPane.showMessageDialog(null, "Welcome !");
				
				  loginFrame.setVisible(false);
				  g1.frame.setVisible(true);
             }
			 else {
                  System.out.println("Incorrect Password\n----");
				  JOptionPane.showMessageDialog(null, "Incorrect Username or password please try again");
				  userNameTextField.setText("");
		          passwordTextField.setText("");
             }
		}
				
	catch(Exception ex){
					
									
		  }			
	   }

});	

    
		
	
		
		
		this.loginFrame.pack();
		
	}
	
	
	

}
