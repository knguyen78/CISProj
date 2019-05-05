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
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AccountController implements Initializable {
	
    @FXML
    private Text fname;

    @FXML
    private Text lname;

    @FXML
    private Text street;

    @FXML
    private Text city;

    @FXML
    private Text state;

    @FXML
    private Text zip;

    @FXML
    private Text email;
	
	@FXML
    private Button mainMenu_btn;

	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		fname.setText("Bob");
		lname.setText("Jones");
		street.setText("123 Rainbow Road");
		city.setText("Boston, ");
		state.setText("MA");
		zip.setText("12345");
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
