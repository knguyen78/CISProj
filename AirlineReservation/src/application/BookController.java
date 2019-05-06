package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import bLogic.Customer;
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

public class BookController {

    @FXML
    private TextField BFID;

    @FXML
    private Button MainMenu;
    
    @FXML void book(ActionEvent event) {
    	String SID = BFID.getText();
    	int FID = Integer.parseInt(SID);
    	try {
			Connection c = DBConnect.connect();
			int CID = Customer.getID();
			String query = "INSERT INTO AirwaysData.bookCheck(CustomerID, FlightID) VALUES('"+ CID + "','" + FID + "');";
			System.out.println(query);
			c.createStatement().execute(query);
			System.out.println("Successful query");
			c.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
