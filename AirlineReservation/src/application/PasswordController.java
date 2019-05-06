package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import application.DBConnect;
import java.sql.*;


public class PasswordController {
	
	@FXML
    private TextField username;

    @FXML
    private Button getSecQ_btn;

    @FXML
    private Text secQuest;

    @FXML
    private TextField secAns;

    @FXML
    private Text secAns_warning;

    @FXML
    private Button getPw_btn;

    @FXML
    private Text password;

    @FXML
    private Button login_btn;

    @FXML
    private Button mainMenu_btn;
    
    
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
    
    @FXML void getSecQuestion(ActionEvent event) {
    	String un = username.getText();
    	
    	
		Connection c;
		try {
			c = (Connection) DBConnect.connect();
			String query = "SELECT securityQuestion from AirwaysData.registration WHERE username = '"+un+ "'";
			Statement st = c.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			if(rs.next()){
			String str = rs.getString(1);
			
			System.out.println(str);
			secQuest.setText(str);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    
    @FXML
    void retrievePw(ActionEvent event) {
    	String ans = secAns.getText();
    	String un = username.getText();
    	
    	
		Connection c;
		try {
			c = (Connection) DBConnect.connect();
			String query = "SELECT securityAnswer, pword from AirwaysData.registration WHERE username = '"+un+ "'";
			Statement st = c.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			if(rs.next()){
				String str1 = rs.getString(1);
				String str2 = rs.getString(2);
			
				System.out.println(str1);
				System.out.println(str2);
				System.out.println(ans);
			
				if (ans.equals(str1)) {
					System.out.println("pw retrieved");
					secAns_warning.setText("correct!");
			
					password.setText(str2);
				}
				else {
					secAns_warning.setText("Incorrect answer. Try again");
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
	void setLoginScene(ActionEvent event) {
		//changeScene("Login.fxml");
		System.out.println("Login button pressed");
		Parent loader;
		Scene newScene;
		
        try {
			loader = FXMLLoader.load(getClass().getResource("Login.fxml"));
			newScene = new Scene(loader);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        window.setScene(newScene);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
	}
    


}
