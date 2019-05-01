package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class Controller{
	
	@FXML
    private Button logIn_btn;

    @FXML
    private Button register_btn;

    
   public void onButtonClick() {
	   System.out.println("Button has been clicked");

	   
    }

}