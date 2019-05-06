package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import bLogic.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BookController {


    @FXML
    private Button book_btn;

	
    @FXML
    private TextField BFID;

    @FXML
    private Button MainMenu;
    
    @FXML
    private TextField username;

    @FXML
    private TextField pword;
    
    @FXML
    private TextField Authenticate;
    
    @FXML
    private Button mainMenu;
    
    
    boolean authenticate = false;
    
   @FXML void getLoginInfo(ActionEvent event) {
		String un = username.getText();
		String pw = pword.getText();
		
		System.out.println(un+"\n"+pw);
		
		// add if statement if the user and pass is true
		
		
		if (checkUser(un) && checkPass(pw)) {
			
			boolean authenticate = true;
			
		}

		
	}
	Boolean checkUser(String un) {
		
		boolean checkUser = false;
		
		try {
			
			
			Connection c;
			c = (Connection) DBConnect.connect();
			String query = "SELECT * from registration where username =?"; 
				
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, un);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				checkUser = true;
				
			}
			
		
		} 
			catch (SQLException ex) {
				
				System.out.println("Error with checkUser class");
			
			}
		
		return checkUser;
	
	}
	
Boolean checkPass(String pw) {
		
		boolean checkPass = false;
		
		try {
			
			
			Connection c;
			c = (Connection) DBConnect.connect();
			String query = "SELECT * from registration where pword =?"; 
				
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, pw);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				checkPass = true;
				
			}
			
		
		} 
			catch (SQLException ex) {
				
				System.out.println("Error with checkPass class");
			
			}
		
		return checkPass;
	
	}
    
    @FXML void book(ActionEvent event) {
    	
    	try {
    		
    		String SID = BFID.getText();
        	int FID = Integer.parseInt(SID);
			Connection c = DBConnect.connect();
			String CID = "Select CustomerID From registration where username = '" + username.getText() + "';";
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(CID);
//			String Alter = "ALTER AirwaysData.bookCheck BookedID AUTO_INCREMENT=1,";
//			Statement s = c.createStatement();
			while(rs.next()) {
			String query = "INSERT INTO AirwaysData.bookCheck(CustomerID, FlightID) VALUES('"+rs.getString("CustomerID") + "','" + FID + "');";
			
			System.out.println(query);
			c.createStatement().execute(query);
			System.out.println("Successful query");
			//c.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @FXML
    void setMainMenu(ActionEvent event) {
		Parent loader;
		Scene newScene;
		
        try {
			loader = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
			newScene = new Scene(loader);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(newScene);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
