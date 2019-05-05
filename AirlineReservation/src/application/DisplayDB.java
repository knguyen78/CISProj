package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.sql.Connection;  
import java.sql.ResultSet;  
import javafx.beans.property.SimpleStringProperty;  
import javafx.beans.value.ObservableValue;  
import javafx.collections.FXCollections;  
import javafx.collections.ObservableList;  
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;  
import javafx.scene.control.TableColumn.CellDataFeatures;  
import javafx.scene.control.TableView;  
import javafx.util.Callback;  
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

public class DisplayDB {
	
	public ObservableList<ObservableList> getData() {
		
		return data;
		
	}
	
	private ObservableList<ObservableList> data;
	
	
	public void buildData(TableView tableview,String SQL) {
		
	
	       if (!tableview.getColumns().isEmpty())
	    	   
	       tableview.getColumns().clear();
	       
	       Connection stmt; 
	       
	       data = FXCollections.observableArrayList();
	       
	       try {
	    	   
	    	   stmt = (Connection) DBConnect.connect();
	    	  
	    	   ResultSet rs = stmt.createStatement().executeQuery(SQL);
	       }
	}

}
