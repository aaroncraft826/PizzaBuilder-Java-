package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextArea; 
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

/**
 * OrderController Class that controls the outputs of each button on the CustomerGUI
 * @author Aaron Galang, Marko Elez
 */
public class OrderController {

    @FXML
    private ComboBox pizzaType;
    
    @FXML
    private ComboBox pizzaSize;
    
    @FXML
    private ListView toppingsList;
    
    @FXML
    private ListView selectedToppingsList;

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button addOrderButton;

    @FXML
    private Button showOrderButton;

    @FXML
    private ImageView pizzaImage;
    
    @FXML
    private TextArea outputDisplay;

    private ArrayList<Pizza> pizzaList = new ArrayList();
    
    @FXML
    /**
     * Add's Items to ComboBox's pizzaType and pizzaSize, as well as ListView toppingsList
     */
    public void initialize() {
        String[] temp;//temporarily holds list
        pizzaList = new ArrayList();
    	
    	//Adds pizzaType items
    	temp=ItemLists.typeList;
    	for(int i=0;i<temp.length;i++) {
    		pizzaType.getItems().add(temp[i]);
    	}
    	pizzaType.getSelectionModel().select(ItemLists.defaultType);
    	
    	//Adds pizzaSize items
    	temp=ItemLists.sizeList;
    	for(int i=0;i<temp.length;i++) {
    		pizzaSize.getItems().add(temp[i]);
    	}
    	pizzaSize.getSelectionModel().select(ItemLists.defaultSize);
    	
    	//Adds toppingsList Items
    	temp=ItemLists.toppingsList;
    	for(int i=0;i<temp.length;i++) {
    		toppingsList.getItems().add(temp[i]);
    	}
    }
    
    @FXML
    /**
     * Disables and re-enables toppings depending on if Build your own is selected, as well as setting toppings accordingly
     */
    void typeSelected(ActionEvent event) {
    	String selectedType = pizzaType.getSelectionModel().getSelectedItem().toString();
        if(selectedType.equals(Constants.pizzaTypeBuildYourOwn)) {
            toppingsList.getItems().addAll(selectedToppingsList.getItems());
            selectedToppingsList.getItems().removeAll(selectedToppingsList.getItems());
        	toppingsList.setDisable(false);
        	selectedToppingsList.setDisable(false);
        }
        else if(selectedType.equals(Constants.pizzaTypeDeluxe)) {
        	toppingsList.getItems().addAll(selectedToppingsList.getItems());
        	selectedToppingsList.getItems().removeAll(selectedToppingsList.getItems());
        	for(String tempTopping:ItemLists.deluxeToppings) {
            	selectedToppingsList.getItems().add(tempTopping);
            	toppingsList.getItems().remove(tempTopping);
        	}
        	toppingsList.setDisable(true);
    		selectedToppingsList.setDisable(true);
    	}
    	else if(selectedType.equals(Constants.pizzaTypeHawaiian)) {
        	toppingsList.getItems().addAll(selectedToppingsList.getItems());
        	selectedToppingsList.getItems().removeAll(selectedToppingsList.getItems());
        	for(String tempTopping:ItemLists.HawaiianToppings) {
            	selectedToppingsList.getItems().add(tempTopping);
            	toppingsList.getItems().remove(tempTopping);
        	}
        	toppingsList.setDisable(true);
    		selectedToppingsList.setDisable(true);
    	}
    }
    
    @FXML
    /**
     * Transfers selected topping from toppingsList to selectedToppingsList upon pressing the addButton
     */
    void add(ActionEvent event) {
    	if(toppingsList.getSelectionModel().getSelectedItem()==null) {
    		outputDisplay.appendText("Topping not selected to add!\n");
    		return;
    	}
    	String selectedTopping = toppingsList.getSelectionModel().getSelectedItem().toString();
    	selectedToppingsList.getItems().add(selectedTopping);
    	toppingsList.getItems().remove(selectedTopping);
    }
    
    @FXML
    /**
     * Transfers selected topping from selectedToppingsList to toppingsList upon pressing the addButton
     */
    void remove(ActionEvent event) {
    	if(selectedToppingsList.getSelectionModel().getSelectedItem()==null) {
    		outputDisplay.appendText("Topping not selected for removal!\n");
    		return;
    	}
    	String selectedTopping = selectedToppingsList.getSelectionModel().getSelectedItem().toString();
    	toppingsList.getItems().add(selectedTopping);
    	selectedToppingsList.getItems().remove(selectedTopping);
    }
    
    @FXML
    /**
     * Clears selectedToppingsList and returns items to toppingsList
     */
    void clear(ActionEvent event) {
    	if(selectedToppingsList.getItems().size()==0) {
    		outputDisplay.appendText("Selected toppings already cleared!\n");
    		return;
    	}
    	toppingsList.getItems().addAll(selectedToppingsList.getItems());
    	selectedToppingsList.getItems().removeAll(selectedToppingsList.getItems());
    }
    
    @FXML
    /**
     * Adds pizza to Order
     */
    void addToOrder(ActionEvent event) {
    	if(selectedToppingsList.getItems().size()<1) {
    		outputDisplay.appendText("Must have at least one topping in a \"Build your own\" pizza!\n");
    		return;
    	}
    	else if(selectedToppingsList.getItems().size()>6) {
    		outputDisplay.appendText("Only up to six toppings are allowed in a \"Build your own\" pizza!\n");
    		return;
    	} else {
            String style = pizzaType.getSelectionModel().getSelectedItem().toString();
            String size = pizzaSize.getSelectionModel().getSelectedItem().toString();
            ArrayList<String> toppings = new ArrayList();

            ObservableList<String> tmp = selectedToppingsList.getItems();
            for (String s : tmp) {
                toppings.add(s);
                //outputDisplay.appendText(s+"\n");
            }

            Pizza pizza;
            if (style == Constants.pizzaTypeBuildYourOwn) {
                pizzaList.add(new BuildYourOwn(style, size, toppings));
            } else if (style == Constants.pizzaTypeDeluxe) {
                if (tmp.size() > 0) {
                    pizzaList.add(new Deluxe(style, size, toppings));
                } else {
                    pizzaList.add(new Deluxe(style, size));
                }
            } else if (style == Constants.pizzaTypeHawaiian) {
                if (tmp.size() > 0) {
                    pizzaList.add(new Hawaiian(style, size, toppings));
                } else {
                    pizzaList.add(new Hawaiian(style, size, toppings));
                }
            }

        }
    }
    
    @FXML
    /**
     * Shows the Order
     */
    void showOrder(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SecondStageGUI.fxml"));
    		VBox root = loader.load();
    		//VBox root = (VBox)FXMLLoader.load(getClass().getResource("/SecondStageGUI.fxml"));
    		
    		SecondStageController secondController = loader.getController();
    		secondController.pizzaOrder(pizzaList);
    		
    		Stage secondaryStage = new Stage();
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			secondaryStage.setScene(scene);
			secondaryStage.setTitle("SecondStageOrder");
			secondaryStage.show();
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    
}
