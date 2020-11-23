package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea; 
import javafx.stage.Stage;

public class SecondStageController {

    @FXML
    private TextArea orderOutput;
    
    @FXML
    private Button clearOrderButton;

    @FXML
    private Button firstStageButton;
    
    private ArrayList<Pizza> pizzaList = new ArrayList();
    
    @FXML
    /**
     * Clear's the pizza list
     */
    public void clearOrder() {
    	if(pizzaList==null || pizzaList.size()<1) {
        	orderOutput.appendText("Order is already Empty!\n");
        	return;
    	}
		pizzaList.clear();
    	orderOutput.appendText("Order has been cleared!\n");
    }
    
    @FXML
    /**
     * Closes the 2nd stage window
     */
    public void toFirstStage() {
    	Stage stage = (Stage)firstStageButton.getScene().getWindow();
    	stage.close();
    }
    
    /**
     * return's an ArrayList of ordered pizza's
     */
    public void pizzaOrder(ArrayList<Pizza> list) {
    	pizzaList = list;
    	orderOutput.appendText("Your Order: \n\n");
    	if(pizzaList==null || pizzaList.size()<1) {
    		orderOutput.appendText("No orders have been made!\n");
    		return;
		}
    	
    	int finalPrice = 0;
    	for(Pizza p: pizzaList) {
    		orderOutput.appendText(p.toString()+"\n");//p.toString()
    		finalPrice+=p.pizzaPrice();
    	}
    	orderOutput.appendText("Final Price: $"+finalPrice+"\n\n");
    }
}
