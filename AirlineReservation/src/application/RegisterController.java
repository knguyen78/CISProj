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
	private ChoiceBox<?> state;

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
