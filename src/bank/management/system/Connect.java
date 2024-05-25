package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect 
{
	Connection con;
	Statement stm;
	
   public Connect()
   {
	   try
	   {
		   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","RootPassword");
		   stm=con.createStatement();
	   }catch(Exception e)
	   {
		   System.out.println(e);
	   }
   }
}
