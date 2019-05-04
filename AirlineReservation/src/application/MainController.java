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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainController implements Initializable{
	
	@FXML
	private BorderPane rootLayout;
	@FXML
    private Button logIn_btn;

    @FXML
    private Button register_btn;
    @FXML
    private Scene oldScene;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
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
	
	@FXML
	void setRegistrationScene(ActionEvent event) {
		//changeScene("Login.fxml");
		System.out.println("Register button pressed");
		Parent loader;
		Scene newScene;
		
        try {
			loader = FXMLLoader.load(getClass().getResource("Register.fxml"));
			newScene = new Scene(loader);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(newScene);
        } catch (IOException e) {
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
