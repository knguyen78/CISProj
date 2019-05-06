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
    private TextField depCity_field;

    @FXML
    private TextField arrCity_field;

    @FXML
    private TextField depTime_field;

    @FXML
    private TextField arrTime_field;

    @FXML
    private Text addStatus;

    @FXML
    private Button addFlight_btn;

    @FXML
    private TextField flightID_field;

    @FXML
    private TextField depCityUpdate_field;

    @FXML
    private TextField arrCityUpdate_field;

    @FXML
    private TextField depTimeUpdate_field;

    @FXML
    private TextField arrTimeUpdate_field;

    @FXML
    private Button deleteFlight_btn;

    @FXML
    private Text updateStatus;

    @FXML
    private Button updateFlight_btn;

    @FXML
    private Button mainMenu_btn;
    
    ObservableList<Flight> flightList = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		// upon intializing scene/window, will populate tableView of flight from database
		try {
			Connection c = DBConnect.connect();
			
			ResultSet rs = c.createStatement().executeQuery("SELECT * from AirwaysData.flight");
			
			//creates a new flight for each row taken from database flight table
			while (rs.next()) {
				flightList.add(new Flight(rs.getInt("flightID"), 
						rs.getString("departureCity"), rs.getString("arrivalCity"), 
						rs.getTime("departureTime"), rs.getTime("arrivalTime")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// sets the cell values which tells where each item from database is populating
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
	
	@FXML
	void addNewFlight(ActionEvent event) {
		String dCity = depCity_field.getText();
	    String aCity = arrCity_field.getText();
	    String dTime = depTime_field.getText();
	    String aTime = arrTime_field.getText();
	    
	    
		try {
			Connection c = DBConnect.connect();
			
			String query = "INSERT INTO AirwaysData.flight(departureCity, arrivalCity, departureTime, arrivalTime, airplaneid) VALUES("+ "'" + dCity + "'," +
					"'" + aCity + "'," + "'" + dTime + "'," +"'" + aTime + "'," + "0);";
			System.out.println(query);
			c.createStatement().execute(query);
			System.out.println("Successful query");
			c.close();
			addStatus.setText("New flight added!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    addStatus.setText("no flights added, try again");
		}
	    
		refreshTable(event);
		
	}
	
	void refreshTable(ActionEvent event) {
		flightTable.getItems().clear();
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
	void deleteFlight(ActionEvent event) {
		int flightID = Integer.parseInt(flightID_field.getText());
		String depC = null, arrC=null;
		System.out.println("delete button pressed");
	    
		try {
			Connection c = DBConnect.connect();
			ResultSet rs = c.createStatement().executeQuery("SELECT * from AirwaysData.flight");
			while (rs.next()) {
				depC = rs.getString("departureCity");
				arrC = rs.getString("arrivalCity");
				updateStatus.setText("Flight "+flightID+" from "+depC+" to "+arrC+" has been deleted!");
			}
			String query1 = "DELETE FROM AirwaysData.flight WHERE flightID = "+flightID+";";
			System.out.println(query1);
			c.createStatement().execute(query1);
			System.out.println("Successful query");
			c.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    addStatus.setText("no flights deleted, try again");
		}
	    
		refreshTable(event);
		
	}
	
	@FXML
	void updateFlight(ActionEvent event) {
		int flightID = Integer.parseInt(flightID_field.getText());
		String dCity = depCityUpdate_field.getText();
	    String aCity = arrCityUpdate_field.getText();
	    String dTime = depTimeUpdate_field.getText();
	    String aTime = arrTimeUpdate_field.getText();
		String depC = null, arrC=null;
		System.out.println("delete button pressed");
	    
		try {
			Connection c = DBConnect.connect();
			ResultSet rs = c.createStatement().executeQuery("SELECT * from AirwaysData.flight");
			while (rs.next()) {
				depC = rs.getString("departureCity");
				arrC = rs.getString("arrivalCity");
				updateStatus.setText("Flight "+flightID+" from "+depC+" to "+arrC+" has been updated!");
			}
			String query1 = "UPDATE AirwaysData.flight SET departureCity = '"+dCity+"', arrivalCity = '"+aCity+"', departureTime = '"+dTime+"', arrivalTime = '"+aTime+"' WHERE flightID = "+flightID+";";
			System.out.println(query1);
			c.createStatement().execute(query1);
			System.out.println("Successful query");
			c.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    addStatus.setText("no flights updated, try again");
		}
	    
		refreshTable(event);
		
	}

}
