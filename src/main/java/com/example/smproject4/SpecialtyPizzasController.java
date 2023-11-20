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

    private void displayToppings(String pizza){
        PizzaMaker pizzaMaker = new PizzaMaker();
        Pizza newPizza = pizzaMaker.createPizza(pizza);
        toppingsList.setItems(newPizza.getToppings());
    }

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

    private void resetImages(){
        emptyBox.setVisible(false);
        supremeImage.setVisible(false);
        seafoodImage.setVisible(false);
        pepperoniImage.setVisible(false);
        deluxeImage.setVisible(false);
        meatzzaImage.setVisible(false);
    }

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

    private Pizza makePizza(String pizzaSelected){
        PizzaMaker pizzaMaker = new PizzaMaker();
        Pizza newPizza = pizzaMaker.createPizza(pizzaSelected);
        newPizza.setExtraCheese(extraCheese.isSelected());
        newPizza.setExtraSauce(extraSauce.isSelected());
        newPizza.setSize(getSize());
        return newPizza;
    }

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
