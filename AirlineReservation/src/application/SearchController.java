package application;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import bLogic.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class SearchController {

    @FXML
    private VBox Search;

    @FXML
    private Text SearchPar;

    @FXML
    private TextField Paramater;

    @FXML
    private Text SearchCat;

    @FXML
    private Button DepCity;

    @FXML
    private Button ArCity;

    @FXML
    private Button DepTime;

    @FXML
    private TableView<Flight> Table;

    @FXML
    private TableColumn<Flight, String> FlightID;

    @FXML
    private TableColumn<Flight, String> DCity;

    @FXML
    private TableColumn<Flight, String> ACity;

    @FXML
    private TableColumn<Flight, Time> Dtime;

    @FXML
    private TableColumn<Flight, Time> Atime;

    @FXML
    private Button back;

    @FXML
    private Button log;

    ObservableList<Flight> flightList = FXCollections.observableArrayList();
    
    String par = "*";
    
    void setMainMenu(ActionEvent event) {
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
    @FXML void getParamater(ActionEvent event) {
    	par = Paramater.getText();
    }
    @FXML void dTime(ActionEvent event) {
    	String where = "departureTime";
    	Table.getItems().clear();
    	Connection c;
		try {
			c = (Connection) DBConnect.connect();
			String query = "SELECT * from AirwaysData.Flights WHERE " + where + " = '" + par + "'";
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
		FlightID.setCellValueFactory(new PropertyValueFactory<>("id"));
		DepCity.setCellValueFactory(new PropertyValueFactory<>("depCity"));
		ACity.setCellValueFactory(new PropertyValueFactory<>("arrCity"));
		DepTime.setCellValueFactory(new PropertyValueFactory<>("depTime"));
		Atime.setCellValueFactory(new PropertyValueFactory<>("arrTime"));
    }
    @FXML void dCity(ActionEvent event) {
    	String where = "departureCity";
    	Connection c;
		try {
			c = (Connection) DBConnect.connect();
			String query = "SELECT * from AirwaysData.Flights WHERE " + where + " = '" + par + "'";
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
		FlightID.setCellValueFactory(new PropertyValueFactory<>("id"));
		DepCity.setCellValueFactory(new PropertyValueFactory<>("depCity"));
		ACity.setCellValueFactory(new PropertyValueFactory<>("arrCity"));
		DepTime.setCellValueFactory(new PropertyValueFactory<>("depTime"));
		Atime.setCellValueFactory(new PropertyValueFactory<>("arrTime"));
		
		Table.setItems(flightList);
    }
		
    @FXML void aCity(ActionEvent event) {
    	String where = "arrivalCity";
    	Connection c;
		try {
			c = (Connection) DBConnect.connect();
			String query = "SELECT * from AirwaysData.Flights WHERE " + where + " = '" + par + "'";
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
			FlightID.setCellValueFactory(new PropertyValueFactory<>("id"));
			DepCity.setCellValueFactory(new PropertyValueFactory<>("depCity"));
			ACity.setCellValueFactory(new PropertyValueFactory<>("arrCity"));
			DepTime.setCellValueFactory(new PropertyValueFactory<>("depTime"));
			Atime.setCellValueFactory(new PropertyValueFactory<>("arrTime"));
			
			Table.setItems(flightList);
    }
}
