package com.example.smproject4;
import java.text.DecimalFormat;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class BuildYourOwnController {
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

    public void updateToppingsTextDisplay(){

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
    public void updatePrice(){

        if(selectedToppings().size() > 7) {
            priceDisplay.clear();
            priceDisplay.appendText("Error");
            return;
        }
        Custom tempPizza = buildPizza();
        priceDisplay.clear();

        DecimalFormat twoDecimals = new DecimalFormat("0.00");
        String formattedValue = twoDecimals.format(tempPizza.price());

        priceDisplay.appendText("$" + formattedValue);
    }
    @FXML
    private VBox toppingsVBox;
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


        //debug
        /*String debugString = "Selected toppings: \n";
        for (int i = 0; i < addedToppingsCount; i++) {
            debugString += toppingsAdded.get(i).toString() + "\n";
        }
        System.out.println(debugString);
        */


        return toppingsAdded;
    }

    @FXML
    private Custom buildPizza(){
        Sauce customSauce = null;
        if(alfredoButton.isSelected()){customSauce = Sauce.ALFREDO;}
        if(tomatoButton.isSelected()){customSauce = Sauce.TOMATO;}

        Size customSize = null;
        if(largeButton.isSelected()){customSize = Size.LARGE;}
        if(mediumButton.isSelected()){customSize = Size.MEDIUM;}
        if(smallButton.isSelected()){customSize = Size.SMALL;}

        boolean extraCheese = extraCheeseBox.isSelected();
        boolean extraSauce = extraSauceBox.isSelected();

        ArrayList<Topping> customToppings = selectedToppings();

        PizzaMaker newPizzaMaker = new PizzaMaker();
        Custom output = (Custom)newPizzaMaker.createPizza("custom");

        output.setExtraCheese(extraCheese);
        output.setExtraSauce(extraSauce);
        output.setSize(customSize);
        output.setSauceType(customSauce);
        output.setToppings(customToppings);

        return output;
    }
    @FXML
    private void addPizzaOrder() {
        if(selectedToppings().size() > 7){
            return;
        }
        Custom toAdd = buildPizza();
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
}
