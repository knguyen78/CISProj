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
import java.sql.ResultSetMetaData;



public class DisplayDB {
	
	private ObservableList<ObservableList> data;
	
	public ObservableList<ObservableList> getData() {
		
		return data;
		
	}
	
	
	public void buildTable(TableView tableview,String stm) {
		
	
	       if (!tableview.getColumns().isEmpty())
	    	   
	       tableview.getColumns().clear();
	       
	       Connection c; 
	       
	       data = FXCollections.observableArrayList();
	       
	       try {
	    	   // Connect to database
	    	   c = (Connection) DBConnect.connect();
	    	  
	    	   
	    	   ResultSet rs = c.createStatement().executeQuery(stm);
	    	   ResultSetMetaData rsMetaData = rs.getMetaData();
	    	   
	    	 for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
	    		 
	    		 int j = i;
	    		 
	    		 // create tableColumn instance column and get the column name
	    		 TableColumn column = new TableColumn(rsMetaData.getColumnName(i+1));
	    		 
	    		 // populate the column's individual cells with values 
	    		 column.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
	    			 
	    			 public ObservableValue<String> call(CellDataFeatures<ObservableList, String> p) {                                                 
	    	             return new SimpleStringProperty(p.getValue().get(j).toString());
	    			 }
	    		 });
	    		 
	    		 // Add the columns to table view
	    		 tableview.getColumns().addAll(column);
	    		 
	    		 
	    	 }
	    	 
	    	 // add data to Observable list
	    	 
	    	 while (rs.next()) {
	    		 
	    		 // iterate row
	    		 ObservableList<String> r = FXCollections.observableArrayList();
	    		 
	    		 for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
	    			 // iterate column
	    			 r.add(rs.getString(i));
	    		 }
	    		 
	    		 data.add(r); 
	    		 
	    	 }
	    	 
	    	 // add to table view
	    	 tableview.setItems(data);
	    	 
	       }  
	       		catch(Exception ex) {
	    	   
	       			System.out.println("Error with building table");
	       		
	       		}   
	}

}
