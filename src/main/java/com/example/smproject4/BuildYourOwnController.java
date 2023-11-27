package com.example.smproject4;
import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;


import java.util.ArrayList;
/**
 * Controller for BuildYourOwn screen.
 * @KimberlyDonnarumma
 * @DanielZhang
 */
public class BuildYourOwnController {

    /**
     * Initializes object for GUI and database use
     */
    @FXML
    private void initialize() {
        // Add ChangeListeners to the checkboxes
        for (javafx.scene.Node node : toppingsVBox.getChildren()) {
            if (node instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) node;
                checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> updateToppingsTextDisplay());
            }
        }
        extraCheeseBox.selectedProperty().addListener((observable, oldValue, newValue) -> updatePrice());
        extraSauceBox.selectedProperty().addListener((observable, oldValue, newValue) -> updatePrice());

        largeButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                updatePrice();
            }
        });
        mediumButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                updatePrice();
            }
        });
        smallButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                updatePrice();
            }
        });
    }

    /**
     * Updates displayed selected toppings
     */
    private void updateToppingsTextDisplay(){

        toppingsList.getItems().clear();

        if(selectedToppings().size() > 7){
            toppingsList.getItems().clear();
            toppingsList.getItems().add("Error: >7 toppings!");
            updatePrice();
            return;
        }

        for (javafx.scene.Node node : toppingsVBox.getChildren()) {
            if (node instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) node;
                if(checkBox.isSelected()){
                    toppingsList.getItems().add(checkBox.getText());
                }
            }
        }
        updatePrice();
    }

    /**
     * Returns the price of the current pizza
     * @return the price as a double. If invalid choices, return 0
     */
    private double price(Pizza pizza){
        if(pizza == null){
            return 0.0;
        }
        return pizza.getPrice();
    }

    private final double TOPPING_PRICE = 1.49;
    /**
     * Updates displayed price
     */
    private void updatePrice(){

        if(selectedToppings().size() > 7) {
            priceDisplay.clear();
            priceDisplay.appendText("Invalid");
            return;
        }
        BuildYourOwn tempPizza = buildPizza();
        priceDisplay.clear();

        DecimalFormat twoDecimals = new DecimalFormat("0.00");
        double price = price(tempPizza);
        String formattedValue = twoDecimals.format(price);

        priceDisplay.appendText("$" + formattedValue);
    }
    @FXML
    private VBox toppingsVBox;

    /**
     * Returns ArrayList of all selected toppings
     * @return ArrayList\<Topping\> of all selected toppings
     */
    @FXML
    private ArrayList<Topping> selectedToppings(){

        // creates Topping array of all toppings selected
        ArrayList<Topping> toppingsAdded = new ArrayList<Topping>();
        int addedToppingsCount = 0;
        for (javafx.scene.Node node : toppingsVBox.getChildren()) {
            if (node instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) node;
                //System.out.println("Checkbox: " + checkBox.getText() + ", Selected: " + checkBox.isSelected());
                if(checkBox.isSelected()){
                    Topping newTopping = Topping.getToppingFromName(checkBox.getText());
                    toppingsAdded.add(newTopping);
                    addedToppingsCount++;
                }
            }
        }
        return toppingsAdded;
    }

    /**
     * Builds and returns current custom pizza
     * @return Custom with properly selected attributes
     */
    @FXML
    private BuildYourOwn buildPizza(){
        Sauce customSauce = getSauce();
        Size customSize = getSize();

        boolean extraCheese = extraCheeseBox.isSelected();
        boolean extraSauce = extraSauceBox.isSelected();

        ArrayList<Topping> customToppings = selectedToppings();

        PizzaMaker newPizzaMaker = new PizzaMaker();
        BuildYourOwn output = (BuildYourOwn)newPizzaMaker.createPizza("Custom");

        output.setExtraCheese(extraCheese);
        output.setExtraSauce(extraSauce);
        output.setSize(customSize);
        output.setSauceType(customSauce);
        output.setToppings(customToppings);

        return output;
    }

    /**
     * Creates a Custom and adds it to the current order
     */
    @FXML
    private void addPizzaToOrder() {
        if(selectedToppings().size() > 7){
            return;
        }
        if(!validInput()){
            return;
        }
        BuildYourOwn toAdd = buildPizza();
        SingletonOrder.getInstance().getOrder().addPizzaToOrder(toAdd);
        display.appendText("Pizza added to order.\n");
    }

    /**
     * Checks if input is valid
     * @return true if valid, false otherwise
     */
    private boolean validInput(){
        if(getSize() == null){
            display.appendText("Please select a size.\n");
            return false;
        }
        if(getSauce() == null){
            display.appendText("Please select a sauce.\n");
            return false;
        }
        return true;
    }

    /**
     * Gets selected size from GUI
     * @return Size
     */
    private Size getSize(){
        Size customSize = null;
        if(largeButton.isSelected()){customSize = Size.LARGE;}
        if(mediumButton.isSelected()){customSize = Size.MEDIUM;}
        if(smallButton.isSelected()){customSize = Size.SMALL;}
        return customSize;
    }

    /**
     * Gets selected sauce from GUI
     * @return Sauce
     */
    private Sauce getSauce(){
        Sauce customSauce = null;
        if(alfredoButton.isSelected()){customSauce = Sauce.ALFREDO;}
        if(tomatoButton.isSelected()){customSauce = Sauce.TOMATO;}
        return customSauce;
    }

    @FXML
    private RadioButton smallButton;
    @FXML
    private RadioButton mediumButton;
    @FXML
    private RadioButton largeButton;
    @FXML
    private RadioButton tomatoButton;
    @FXML
    private RadioButton alfredoButton;
    @FXML
    private CheckBox extraCheeseBox;
    @FXML
    private CheckBox extraSauceBox;
    @FXML
    private ListView toppingsList;
    @FXML
    private TextField priceDisplay;
    @FXML
    private TextArea display;
}
