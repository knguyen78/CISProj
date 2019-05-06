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

public class AdminController implements Initializable {
	
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
	
    @FXML
    private Button editFlights_btn;
	
	@FXML
    private TableView<?> upcomingTable;

	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	@FXML
	void setMainMenu(ActionEvent event) {
		//controls main menu button
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
	void setEditFlightScene(ActionEvent event) {
		//allows admin to edit the flights
		Parent loader;
		Scene newScene;
		System.out.println("Edit Flights button pressed");
		
        try {
			loader = FXMLLoader.load(getClass().getResource("EditFlights.fxml"));
			newScene = new Scene(loader);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(newScene);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setAdminInfo(String firstN, String lastN, String str, String ci, String st, String zipCode, String email) {
        //Allows Admin to change info
		fname.setText(firstN);
        lname.setText(lastN);
        street.setText(str);
        city.setText(ci+", ");
        state.setText(st);
        zip.setText(zipCode);
        this.email.setText(email);
    }
	

}