package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import bLogic.Admin;
import bLogic.bookCheck;
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
    private Button refresh_btn;
	
	@FXML
    private TableView<bookCheck> upcomingTable;
    
    @FXML
    private TableColumn<bookCheck, String> BC;

    @FXML
    private TableColumn<bookCheck, String> CC;

    @FXML
    private TableColumn<bookCheck, String> FC;

    ObservableList<bookCheck> bookList = FXCollections.observableArrayList();
	

    private int custID;
	
	

	
	
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
	
	public void setAdminInfo(String firstN, String lastN, String str, String ci, String st, String zipCode, String email, int cID) {
        // uses parameters passed from loginController to populate account information when scene is set
		fname.setText(firstN);
        lname.setText(lastN);
        street.setText(str);
        city.setText(ci+", ");
        state.setText(st);
        zip.setText(zipCode);
        this.email.setText(email);
        custID = cID;
    }
	
	@FXML 
	void refresh(ActionEvent event) {
    	//narrows results by inputed time
    	upcomingTable.getItems().clear();
    	Connection c;
		try {
			c = (Connection) DBConnect.connect();
			String query = "SELECT * from AirwaysData.bookCheck WHERE CustomerID = "+custID+";";
			Statement st = c.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				bookList.add(new bookCheck(Integer.parseInt(rs.getString("bookedID")), 
						Integer.parseInt(rs.getString("CustomerID")),Integer.parseInt(rs.getString("FlightID"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BC.setCellValueFactory(new PropertyValueFactory<>("BID"));
		CC.setCellValueFactory(new PropertyValueFactory<>("CID"));
		FC.setCellValueFactory(new PropertyValueFactory<>("FID"));
		//DepTimeC.setCellValueFactory(new PropertyValueFactory<>("depTime"));
		//ATimeC.setCellValueFactory(new PropertyValueFactory<>("arrTime"));
		upcomingTable.setItems(bookList);
	}
	
	
	

}