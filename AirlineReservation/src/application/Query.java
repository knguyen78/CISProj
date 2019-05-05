package application;

import java.sql.Connection;

public class Query {
	public static void deleteRecord(int id,String tableName){
		//makes the connection
		Connection c; 
		try{  
			c = DBConnect.connect(); 
			//Select paramaters
			String query = "Delete from "+tableName+" where id='"+id+"';";
			c.createStatement().execute(query);
			c.close();  
		}
		catch(Exception e){  
			//catch errors
			System.out.println("Error on Building Data");        
		}  
	}
}
