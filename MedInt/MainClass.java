import pkg1.gui;
import pkg1.AddUserGui;
import pkg1.DeleteUserGui;
import pkg1.LoginGui;
import mi.medicineInfo;
import db.DBData;
import db.DBConPro;
import EventHandler.EventHandler;


public class MainClass {
    
    public static void main(String arg[])
	{
        System.out.println("\n---> Printing From MainClass\n");
		//gui g1 = new gui();
		LoginGui lg=new LoginGui();
		//AddUserGui AUG=new AddUserGui();
		//DeleteUserGui DUG=new DeleteUserGui();
	}
  
   
    
}

//java -cp "./lib/mysql.jar;" MainClass
//javac MainClass.java
//admin
//root
