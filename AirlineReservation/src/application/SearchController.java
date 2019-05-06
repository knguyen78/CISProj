
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    private TableView<?> Table;

    @FXML
    private TableColumn<?, ?> FlightID;

    @FXML
    private TableColumn<?, ?> DCity;

    @FXML
    private TableColumn<?, ?> ACity;

    @FXML
    private TableColumn<?, ?> Dtime;

    @FXML
    private TableColumn<?, ?> Atime;

    @FXML
    private Button back;

    @FXML
    private Button log;
    
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
    	Connection c;
		try {
			c = (Connection) DBConnect.connect();
			String query = "SELECT * from AirwaysData.Flights WHERE " + where + " = '" + par + "'";
			Statement st = c.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			if(rs.next()){
			String str = rs.getString(1);
			
			System.out.println(str);
			secQuest.setText(str);
			}
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    @FXML void dCity(ActionEvent event) {
    	String where = "departureCity";
    	Connection c;
		try {
			c = (Connection) DBConnect.connect();
			String query = "SELECT * from AirwaysData.Flights WHERE " + where + " = '" + par + "'";
			Statement st = c.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			if(rs.next()){
			String str = rs.getString(1);
			
			System.out.println(str);
			secQuest.setText(str);
			}
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    @FXML void aCity(ActionEvent event) {
    	String where = "arrivalCity";
    	Connection c;
		try {
			c = (Connection) DBConnect.connect();
			String query = "SELECT * from AirwaysData.Flights WHERE " + where + " = '" + par + "'";
			Statement st = c.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			if(rs.next()){
			String str = rs.getString(1);
			
			System.out.println(str);
			secQuest.setText(str);
			}
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }

}
