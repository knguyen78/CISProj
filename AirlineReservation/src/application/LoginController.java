package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			
			setAccountView(event);
		}

		
	}
			
	
	void setAccountView(ActionEvent event) {
		Parent loader;
		Scene newScene;
		
        try {
			loader = FXMLLoader.load(getClass().getResource("AccountInfo.fxml"));
			newScene = new Scene(loader);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(newScene);
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
