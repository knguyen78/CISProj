package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private TextField usern_field;

    @FXML
    private PasswordField passw_field;

    @FXML
    private Button signIn_btn;
	
	@FXML
    private Button mainMenu_btn;
	
	String un = "";
	String pw = "";
	
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
	
	@FXML
	void getLoginInfo(ActionEvent event) {
		String un = usern_field.getText();
		String pw = passw_field.getText();
		
		System.out.println(un+"\n"+pw);
		
		// add if statement if the user and pass is true
		
		
		if (checkUser(un) && checkPass(pw)) {
			
			if(checkAdmin(un,pw)) {
			setAdminView(event);
				
			} else {
				
				setAccountView(event);
			}
			
		}

		
	}
			
	void setAdminView(ActionEvent event) {
		String un = usern_field.getText();
		String pw = passw_field.getText();
		Scene newScene;
		Connection c;
		
		try {
			c = (Connection) DBConnect.connect();
			String query = "SELECT * from AirwaysData.registration WHERE username = '"+un+ "'AND pword='"+pw+ "'";
			Statement st = c.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			if(rs.next()){
				String firstN = rs.getString(2);
				String lastN = rs.getString(3);
				String str = rs.getString(5);
				String ci = rs.getString(4);
				String state = rs.getString(7);
				String zipCode = rs.getString(6);
				String email = rs.getString(10);
			
				// load new scene and populate with account information
				FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminInfo.fxml"));
				newScene = new Scene(loader.load());
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				AdminController controller = loader.getController();
				// set data in the controller
				controller.setAdminInfo(firstN, lastN, str, ci, state, zipCode, email);
		        
		        window.setScene(newScene);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	


	void setAccountView(ActionEvent event) {
		String un = usern_field.getText();
		String pw = passw_field.getText();
		Scene newScene;
		Connection c;
		
		try {
			c = (Connection) DBConnect.connect();
			String query = "SELECT * from AirwaysData.registration WHERE username = '"+un+ "'AND pword='"+pw+ "'";
			Statement st = c.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			if(rs.next()){
				String firstN = rs.getString(2);
				String lastN = rs.getString(3);
				String str = rs.getString(5);
				String ci = rs.getString(4);
				String state = rs.getString(7);
				String zipCode = rs.getString(6);
				String email = rs.getString(10);
			
				// load new scene and populate with account information
				FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountInfo.fxml"));
				newScene = new Scene(loader.load());
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				AccountController controller = loader.getController();
				// set data in the controller
				controller.setAccountInfo(firstN, lastN, str, ci, state, zipCode, email);
		        
		        window.setScene(newScene);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	Boolean checkAdmin(String un, String pw) {
		
		boolean admin = false;
		
		try {
			
			Connection c;
			c = (Connection) DBConnect.connect();
			String query = "SELECT isAdmin from AirwaysData.registration WHERE username = '"+un+ "'AND pword='"+pw+ "'";
			
			Statement st = c.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			if (rs.next()) {
				
				if (rs.getBoolean("isAdmin")) {
					admin = true;
				}
				
			}
			
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
				
		return admin;
	
	}

	@FXML
	void setForgotPwView(ActionEvent event) {
		Parent loader;
		Scene newScene;
	
    	try {
			loader = FXMLLoader.load(getClass().getResource("ForgotPw.fxml"));
			newScene = new Scene(loader);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        	window.setScene(newScene);
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
}
