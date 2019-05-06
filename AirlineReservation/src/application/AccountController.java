package application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import bLogic.Flight;
import bLogic.bookCheck;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
	
    @FXML
    private Button book;
	
	@FXML
    private TableView<bookCheck> upcomingTable;
    
    @FXML
    private TableColumn<bookCheck, String> BC;

    @FXML
    private TableColumn<bookCheck, String> CC;

    @FXML
    private TableColumn<bookCheck, String> FC;

    ObservableList<bookCheck> bookList = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	@FXML
	void setMainMenu(ActionEvent event) {
		//Controls main menu button
		Parent loader;
		Scene newScene;
		
        try {
			loader = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
			newScene = new Scene(loader);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(newScene);
        } catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML void refresh(ActionEvent event) {
    	//narrows results by inputed time
    	upcomingTable.getItems().clear();
    	Connection c;
		try {
			c = (Connection) DBConnect.connect();
			String query = "SELECT * from AirwaysData.bookCheck;";
			Statement st = c.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				bookList.add(new bookCheck(rs.getString("bookedID"), 
						rs.getString("CustomerID"), rs.getString("FlightID")));
			}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FID.setCellValueFactory(new PropertyValueFactory<>("id"));
		DepCityC.setCellValueFactory(new PropertyValueFactory<>("depCity"));
		ACityC.setCellValueFactory(new PropertyValueFactory<>("arrCity"));
		DepTimeC.setCellValueFactory(new PropertyValueFactory<>("depTime"));
		ATimeC.setCellValueFactory(new PropertyValueFactory<>("arrTime"));
		Table.setItems(flightList);
	
	@FXML
	void setSearchScene(ActionEvent event) {
		//allows user to view flights
		Parent loader;
		Scene newScene;
		System.out.println("Book button pressed");
		
        try {
			loader = FXMLLoader.load(getClass().getResource("Searcher.fxml"));
			newScene = new Scene(loader);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(newScene);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setAccountInfo(String firstN, String lastN, String str, String ci, String st, String zipCode, String email) {
        //Shows Account info at top of screen
		fname.setText(firstN);
        lname.setText(lastN);
        street.setText(str);
        city.setText(ci+", ");
        state.setText(st);
        zip.setText(zipCode);
        this.email.setText(email);
    }
	

}
