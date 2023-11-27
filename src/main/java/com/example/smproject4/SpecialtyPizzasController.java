package com.example.smproject4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
/**
 * Controller for SpecialtyPizzas screen.
 * @KimberlyDonnarumma
 * @DanielZhang
 */
public class SpecialtyPizzasController implements Initializable {
    private final double BLANK_PRICE = 0;
    private final String MEATZZA = "Meatzza";
    private final String DELUXE = "Deluxe";
    private final String SEAFOOD = "Seafood";
    private final String PEPPERONI = "Pepperoni";
    private final String SUPREME = "Supreme";
    private double dynamicTotal = 0;
    private SingletonOrder s = SingletonOrder.getInstance();
    @FXML
    private ComboBox comboBox = new ComboBox<>();
    @FXML
    private Text pizzaName;
    @FXML
    private ListView toppingsList;
    @FXML
    private RadioButton smallButton;
    @FXML
    private RadioButton mediumButton;
    @FXML
    private RadioButton largeButton;
    @FXML
    private CheckBox extraCheese;
    @FXML
    private CheckBox extraSauce;
    @FXML
    private TextField total;
    @FXML
    private ImageView supremeImage;
    @FXML
    private ImageView emptyBox;
    @FXML
    private ImageView meatzzaImage;
    @FXML
    private ImageView seafoodImage;
    @FXML
    private ImageView deluxeImage;
    @FXML
    private ImageView pepperoniImage;
    @FXML
    private TextArea testOrderOutput;

    /**
     * Initializes the specialty pizzas screen with event handlers.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> pizzaOptions = FXCollections.observableArrayList(
                DELUXE, SUPREME, MEATZZA, SEAFOOD, PEPPERONI
        );
        comboBox.setItems(pizzaOptions);

        String str = new DecimalFormat("0.00").format(BLANK_PRICE);
        total.setText("$" + str);

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                String pizzaType = (String)comboBox.getValue();
                pizzaName.setText(pizzaType);
                displayPizzaImage(pizzaType);
                displayToppings(pizzaType);
                displayTotal();
            }
        };
        comboBox.setOnAction(event);
    }

    /**
     * Displays current running total.
     */
    @FXML
    protected void displayTotal(){
        String pizza = (String)comboBox.getValue();
        if(pizza == null){
            return;
        }
        if(getSize() == null){
            return;
        }
        Pizza tempPizza = makePizza(pizza);
        double totalPrice = tempPizza.price();
        String newTotal = new DecimalFormat("0.00").format(totalPrice);
        total.setText("$" + newTotal);
    }

    /**
     * Displays the toppings of the selected pizza.
     * @param pizza
     */
    private void displayToppings(String pizza){
        PizzaMaker pizzaMaker = new PizzaMaker();
        Pizza newPizza = pizzaMaker.createPizza(pizza);
        toppingsList.setItems(newPizza.getToppings());
    }

    /**
     * Displays image of the current selected pizza.
     * @param pizza
     */
    private void displayPizzaImage(String pizza){
        resetImages();
        if(pizza.equals(MEATZZA)){
            meatzzaImage.setVisible(true);
        }
        else if(pizza.equals(SEAFOOD)){
            seafoodImage.setVisible(true);
        }
        else if(pizza.equals(PEPPERONI)){
            pepperoniImage.setVisible(true);
        }
        else if(pizza.equals(SUPREME)){
            supremeImage.setVisible(true);
        }
        else if(pizza.equals(DELUXE)){
            deluxeImage.setVisible(true);
        }
    }

    /**
     * Resets all images.
     */
    private void resetImages(){
        emptyBox.setVisible(false);
        supremeImage.setVisible(false);
        seafoodImage.setVisible(false);
        pepperoniImage.setVisible(false);
        deluxeImage.setVisible(false);
        meatzzaImage.setVisible(false);
    }

    /**
     * Adds pizza to order when button selected.
     */
    @FXML
    protected void onAddToOrderClick(){
        if(!validInput()){
            return;
        }
        String pizzaSelected = (String)comboBox.getValue();
        Pizza pizza = makePizza(pizzaSelected);
        pizza.setSize(getSize());
        pizza.setExtraCheese(extraCheese.isSelected());
        pizza.setExtraSauce(extraSauce.isSelected());
        s.getOrder().addPizzaToOrder(pizza);
        testOrderOutput.appendText("Pizza added to order.\n");
    }

    /**
     * Checks if the user currently has a valid input for making a pizza.
     * @return
     */
    private boolean validInput(){
        if(getSize() == null){
            testOrderOutput.appendText("Please select a size.\n");
            return false;
        }
        if(comboBox.getValue() == null){
            testOrderOutput.appendText("Please select a pizza.\n");
            return false;
        }
        return true;
    }

    /**
     * Makes pizza using the selected inputs.
     * @param pizzaSelected
     * @return
     */
    private Pizza makePizza(String pizzaSelected){
        PizzaMaker pizzaMaker = new PizzaMaker();
        Pizza newPizza = pizzaMaker.createPizza(pizzaSelected);
        newPizza.setExtraCheese(extraCheese.isSelected());
        newPizza.setExtraSauce(extraSauce.isSelected());
        newPizza.setSize(getSize());
        return newPizza;
    }

    /**
     * Gets the size of the pizza based on what button the user has selected.
     * @return
     */
    private Size getSize(){
        Size size = null;
        if(smallButton.isSelected()){
            size = Size.SMALL;
        }
        else if(mediumButton.isSelected()){
            size = Size.MEDIUM;
        }
        else if(largeButton.isSelected()){
            size = Size.LARGE;
        }
        return size;
    }
}
