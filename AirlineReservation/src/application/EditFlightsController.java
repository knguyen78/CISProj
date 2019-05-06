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
import javafx.stage.Stage;

public class EditFlightsController implements Initializable {
	
    @FXML
    private TextField searchByField;
	
	@FXML
    private Button depCity_btn;

    @FXML
    private Button arrCity_btn;

    @FXML
    private Button deptTime_btn;

    @FXML
    private Button arrTime_btn;
    
    @FXML
    private Button mainMenu_btn;
	
    @FXML
    private TableView<Flight> flightTable; 
	
	@FXML
    private TableColumn<Flight, String> col_flightID;

    @FXML
    private TableColumn<Flight, String> col_DepCity;

    @FXML
    private TableColumn<Flight, String> col_ArrCity;

    @FXML
    private TableColumn<Flight, Time> col_DepTime;

    @FXML
    private TableColumn<Flight, Time> col_ArrTime;
    
    ObservableList<Flight> flightList = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		try {
			Connection c = DBConnect.connect();
			
			ResultSet rs = c.createStatement().executeQuery("SELECT * from AirwaysData.flight");
			
			while (rs.next()) {
				flightList.add(new Flight(rs.getInt("flightID"), 
						rs.getString("departureCity"), rs.getString("arrivalCity"), 
						rs.getTime("departureTime"), rs.getTime("arrivalTime")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		col_flightID.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_DepCity.setCellValueFactory(new PropertyValueFactory<>("depCity"));
		col_ArrCity.setCellValueFactory(new PropertyValueFactory<>("arrCity"));
		col_DepTime.setCellValueFactory(new PropertyValueFactory<>("depTime"));
		col_ArrTime.setCellValueFactory(new PropertyValueFactory<>("arrTime"));
		
		flightTable.setItems(flightList);
		
		
		
		
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
	
	@FXML
	void searchByDepartureCity(ActionEvent event) {
		String search = searchByField.getText();
		flightTable.getItems().clear();
		
		try {
			Connection c = DBConnect.connect();
			
			ResultSet rs = c.createStatement().executeQuery("SELECT * from AirwaysData.flight WHERE departureCity LIKE '"+ search+"%'");
			
			while (rs.next()) {
				flightList.add(new Flight(rs.getInt("flightID"), 
						rs.getString("departureCity"), rs.getString("arrivalCity"), 
						rs.getTime("departureTime"), rs.getTime("arrivalTime")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		col_flightID.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_DepCity.setCellValueFactory(new PropertyValueFactory<>("depCity"));
		col_ArrCity.setCellValueFactory(new PropertyValueFactory<>("arrCity"));
		col_DepTime.setCellValueFactory(new PropertyValueFactory<>("depTime"));
		col_ArrTime.setCellValueFactory(new PropertyValueFactory<>("arrTime"));
		
		flightTable.setItems(flightList);
		
	}
	
	@FXML
	void searchByDepartureTime(ActionEvent event) {
		String search = searchByField.getText();
		flightTable.getItems().clear();
		
		try {
			Connection c = DBConnect.connect();
			
			ResultSet rs = c.createStatement().executeQuery("SELECT * from AirwaysData.flight WHERE departureTime LIKE '"+ search+"%'");
			
			while (rs.next()) {
				flightList.add(new Flight(rs.getInt("flightID"), 
						rs.getString("departureCity"), rs.getString("arrivalCity"), 
						rs.getTime("departureTime"), rs.getTime("arrivalTime")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		col_flightID.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_DepCity.setCellValueFactory(new PropertyValueFactory<>("depCity"));
		col_ArrCity.setCellValueFactory(new PropertyValueFactory<>("arrCity"));
		col_DepTime.setCellValueFactory(new PropertyValueFactory<>("depTime"));
		col_ArrTime.setCellValueFactory(new PropertyValueFactory<>("arrTime"));
		
		flightTable.setItems(flightList);
		
	}
	
	@FXML
	void searchByArrivalCity(ActionEvent event) {
		String search = searchByField.getText();
		flightTable.getItems().clear();
		
		try {
			Connection c = DBConnect.connect();
			
			ResultSet rs = c.createStatement().executeQuery("SELECT * from AirwaysData.flight WHERE arrivalCity LIKE '"+ search+"%'");
			
			while (rs.next()) {
				flightList.add(new Flight(rs.getInt("flightID"), 
						rs.getString("departureCity"), rs.getString("arrivalCity"), 
						rs.getTime("departureTime"), rs.getTime("arrivalTime")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		col_flightID.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_DepCity.setCellValueFactory(new PropertyValueFactory<>("depCity"));
		col_ArrCity.setCellValueFactory(new PropertyValueFactory<>("arrCity"));
		col_DepTime.setCellValueFactory(new PropertyValueFactory<>("depTime"));
		col_ArrTime.setCellValueFactory(new PropertyValueFactory<>("arrTime"));
		
		flightTable.setItems(flightList);
		
	}
	
	@FXML
	void searchByArrivalTime(ActionEvent event) {
		String search = searchByField.getText();
		flightTable.getItems().clear();
		
		try {
			Connection c = DBConnect.connect();
			
			ResultSet rs = c.createStatement().executeQuery("SELECT * from AirwaysData.flight WHERE arrivalTime LIKE '"+ search+"%'");
			
			while (rs.next()) {
				flightList.add(new Flight(rs.getInt("flightID"), 
						rs.getString("departureCity"), rs.getString("arrivalCity"), 
						rs.getTime("departureTime"), rs.getTime("arrivalTime")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		col_flightID.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_DepCity.setCellValueFactory(new PropertyValueFactory<>("depCity"));
		col_ArrCity.setCellValueFactory(new PropertyValueFactory<>("arrCity"));
		col_DepTime.setCellValueFactory(new PropertyValueFactory<>("depTime"));
		col_ArrTime.setCellValueFactory(new PropertyValueFactory<>("arrTime"));
		
		flightTable.setItems(flightList);
		
	}

}
