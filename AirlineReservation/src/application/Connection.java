package application;

import java.sql.*;  
public class Connection{  
public static void main(String args[]){  
try{  
Class.forName("com.mysql.jdbc.Driver");  
java.sql.Connection con= DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/Database");  
//creating a connection to the url of where the database is locally stored
//3306 is the default port
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from emp");  
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
con.close();  
}catch(Exception e){ System.out.println(e);}  
}  
}