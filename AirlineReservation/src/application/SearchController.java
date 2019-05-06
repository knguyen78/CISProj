package application;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import bLogic.Flight;
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



public class SearchController implements Initializable{

	@FXML
    private TextField Keyword;

    @FXML
    private Button DepCityB;

    @FXML
    private Button ACityB;

    @FXML
    private Button DepTimeB;

    @FXML
    private Button ATimeB;

    @FXML
    private TableView<Flight> Table;
    
    @FXML
    private TableColumn<Flight, String> FID;

    @FXML
    private TableColumn<Flight, String> DepCityC;

    @FXML
    private TableColumn<Flight, String> ACityC;

    @FXML
    private TableColumn<Flight, Time> DepTimeC;

    @FXML
    private TableColumn<Flight, Time> ATimeC;
    
    @FXML
    private Button Book;

    @FXML
    private Button MainMenu;

    ObservableList<Flight> flightList = FXCollections.observableArrayList();
    
    String par = "*";
    
    public void initialize(URL arg0, ResourceBundle arg1) {
		// shows initial flights
		
		try {
			Connection c = DBConnect.connect();
			
			ResultSet rs = c.createStatement().executeQuery("SELECT * from AirwaysData.flight");
			
			while (rs.next()) {
				flightList.add(new Flight(rs.getInt("flightID"), 
						rs.getString("departureCity"), rs.getString("arrivalCity"), 
						rs.getTime("departureTime"), rs.getTime("arrivalTime")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		FID.setCellValueFactory(new PropertyValueFactory<>("id"));
		DepCityC.setCellValueFactory(new PropertyValueFactory<>("depCity"));
		ACityC.setCellValueFactory(new PropertyValueFactory<>("arrCity"));
		DepTimeC.setCellValueFactory(new PropertyValueFactory<>("depTime"));
		ATimeC.setCellValueFactory(new PropertyValueFactory<>("arrTime"));
		
		Table.setItems(flightList);
		
		
		
		
	}
    
    @FXML void setMainMenu(ActionEvent event) {
		//returns to main menu
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
    @FXML void aTime(ActionEvent event) {
    	//narrows results by inputed time
    	String where = Keyword.getText();
    	Table.getItems().clear();
    	Connection c;
		try {
			c = (Connection) DBConnect.connect();
			String query = "SELECT * from AirwaysData.flight WHERE arrivalTime Like '" + where + "%'";
			Statement st = c.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				flightList.add(new Flight(rs.getInt("flightID"), 
						rs.getString("departureCity"), rs.getString("arrivalCity"), 
						rs.getTime("departureTime"), rs.getTime("arrivalTime")));
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
    }
    @FXML void dTime(ActionEvent event) {
    	//narrows results by inputed time
    	String where = Keyword.getText();
    	Table.getItems().clear();
    	Connection c;
		try {
			c = (Connection) DBConnect.connect();
			String query = "SELECT * from AirwaysData.Flights WHERE departureTime Like '" + where + "%'";
			Statement st = c.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				flightList.add(new Flight(rs.getInt("flightID"), 
						rs.getString("departureCity"), rs.getString("arrivalCity"), 
						rs.getTime("departureTime"), rs.getTime("arrivalTime")));
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
    }
    @FXML void dCity(ActionEvent event) {
    	// narrows results by inputed city
    	String where = Keyword.getText();
    	Table.getItems().clear();
    	Connection c;
		try {
			c = (Connection) DBConnect.connect();
			String query = "SELECT * from AirwaysData.flight WHERE departureCity LIKE '"+ where+"%'";
			Statement st = c.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				flightList.add(new Flight(rs.getInt("flightID"), 
						rs.getString("departureCity"), rs.getString("arrivalCity"), 
						rs.getTime("departureTime"), rs.getTime("arrivalTime")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FID.setCellValueFactory(new PropertyValueFactory<>("id"));
		DepCityC.setCellValueFactory(new PropertyValueFactory<>("depCity"));
		ACityC.setCellValueFactory(new PropertyValueFactory<>("arrCity"));
		DepTimeC.setCellValueFactory(new PropertyValueFactory<>("depTime"));
		ATimeC.setCellValueFactory(new PropertyValueFactory<>("arrTime"));
		Table.setItems(flightList);
		
    }
		
    @FXML void aCity(ActionEvent event) {
    	//narrows results by inputed city
    	String where = Keyword.getText();
    	Table.getItems().clear();
    	Connection c;
		try {
			c = (Connection) DBConnect.connect();
			String query = "SELECT * from AirwaysData.flight WHERE arrivalCity LIKE '" + where + "%'";
			Statement st = c.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				flightList.add(new Flight(rs.getInt("flightID"), 
						rs.getString("departureCity"), rs.getString("arrivalCity"), 
						rs.getTime("departureTime"), rs.getTime("arrivalTime")));
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
    }
    @FXML void book(ActionEvent event) {
    	//allows user to book a flight
    	Parent loader;
		Scene newScene;
		System.out.println("Book button pressed");
		
        try {
			loader = FXMLLoader.load(getClass().getResource("Booking.fxml"));
			newScene = new Scene(loader);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(newScene);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
