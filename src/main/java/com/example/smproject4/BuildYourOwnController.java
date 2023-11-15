package com.example.smproject4;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BuildYourOwnController {
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
        /*
        public Custom(Topping[] toppings, Sauce sauce, Size size,
                      boolean extraCheese, boolean extraSauce){
            initializeToppings(toppings);
            this.sauce = sauce;
            this.size = size;
            this.extraCheese = extraCheese;
            this.extraSauce = extraSauce;
        }
        */

        ArrayList<Topping> customToppings = selectedToppings();
        Sauce customSauce = null;
        if(alfredoButton.isSelected()){customSauce = Sauce.ALFREDO;}
        if(tomatoButton.isSelected()){customSauce = Sauce.TOMATO;}

        Size customSize = null;
        if(largeButton.isSelected()){customSize = Size.LARGE;}
        if(mediumButton.isSelected()){customSize = Size.MEDIUM;}
        if(smallButton.isSelected()){customSize = Size.SMALL;}

        boolean extraCheese = extraCheeseBox.isSelected();
        boolean extraSauce = extraSauceBox.isSelected();

        if(customSauce == null || customSize == null){
            System.out.println("DID NOT SELECT SAUCE AND/OR SIZE");
            return null;
        }

        Custom output = new Custom(customToppings, customSauce, customSize, extraCheese, extraSauce);
        System.out.println(output.toString());
        return output;
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
}
