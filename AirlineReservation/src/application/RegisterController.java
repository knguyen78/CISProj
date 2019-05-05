package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import application.DisplayDB;
import application.DBConnect;
import application.Delete;
import bLogic.Customer;
import java.sql.Connection;
import java.sql.SQLException;

public class RegisterController {
	@FXML
	private TextField fname;

	@FXML
	private TextField lname;

	@FXML
	private TextField street;

	@FXML
	private TextField zip;

	@FXML
	private TextField state;

	@FXML
	private TextField email;

	@FXML
	private TextField ssn;

	@FXML
	private TextField usern;

	@FXML
	private PasswordField passw;

	@FXML
	private TextField secQuestion;

	@FXML
	private TextField secAnswer;
	
	@FXML
    private Button mainMenu_btn;
	
	@FXML
	private Button regi_btn;
	
	
	String firName = "";
	String lastName = "";
	String str = "";
	String zipcode = "";
	String sta = "";
	String emi = "";
	String social = "";
	String user = "";
	String pass = "";
	String securityQ = "";
	String securityA = "";
	
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
	private void regi_btn(ActionEvent event) {
		
		try {
			
			getRegisterFields();
			Connection c;
			c = (Connection) DBConnect.connect();
			String query = "INSERT INTO Database.registration (firstName, lastName, street, zip, state, email, "
							+ "ssn, username, password, securityQuestion, securityAnswer)VALUES("+ "'" + firName + "'," +
							"'" + lastName + "'," + "'" + str + "'," + "'" + zipcode + "'," +
							"'" + sta + "'," + "'" + emi + "'," + "'" + social + "'," + "'" + user + "'," +
							"'" + pass + "'," + "'" + securityQ + "'," + "'" + securityA + "',);"; 
					
			
			c.createStatement().execute(query);
			c.close();
			
		}
		catch (SQLException e){
			System.out.println("Error with register button");
		}
		
	}
	
	private void getRegisterFields() {
		
		firName = fname.getText();
		lastName = lname.getText();
		str = street.getText();
		zipcode = zip.getText();
		sta = state.getText();
		emi = email.getText();
		social = ssn.getText();
		user = usern.getText();
		pass = passw.getText();
		securityQ = secQuestion.getText();
		securityA = secAnswer.getText();		
		
	}
}
