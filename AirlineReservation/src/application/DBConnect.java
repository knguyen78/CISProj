package application;

import java.sql.*;


public class DBConnect {
	
private static Connection con;
	
	public static Connection connect() throws SQLException {
		
		try {
			
			 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		}	
			catch(ClassNotFoundException cnfe) {  
				System.err.println("Error: "+cnfe.getMessage());
	       
	     }	catch(InstantiationException ie) {  
	    	 	System.err.println("Error: "+ie.getMessage());
	       
	     }	catch(IllegalAccessException iae) {  
	    	 	System.err.println("Error: "+iae.getMessage());  
	     }
		
		 con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/AirwaysData?serverTimezone=UTC");
		
		
		
		return con;
		
		}
		
}


