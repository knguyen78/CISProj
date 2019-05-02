package application;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connection {
	private static Connection conn;  

	   public static Connection connect() throws SQLException{  
	     try{  
	       Class.forName("com.mysql.jdbc.Driver").newInstance();  
	     }catch(ClassNotFoundException cnfe){  
	       System.err.println("Error: "+cnfe.getMessage());  
	     }catch(InstantiationException ie){  
	       System.err.println("Error: "+ie.getMessage());  
	     }catch(IllegalAccessException iae){  
	       System.err.println("Error: "+iae.getMessage());  
	     }  
	     conn = (Connection) DriverManager.getConnection(url,user,"");  
	     return conn;  
	   }  
}
