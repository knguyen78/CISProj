package application;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import bLogic.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditFlightsController implements Initializable {
	
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

}
