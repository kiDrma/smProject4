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
    private boolean orderInProgress = false;
    private Order order = new Order();
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
    private Button addToOrderButton;
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
        dynamicTotal = 0;
        if(pizza == null){
            return;
        }
        if(pizza.equals(MEATZZA)){
            Meatzza meatzza = new Meatzza(getSize(), extraCheese.isSelected(),
                    extraSauce.isSelected());
            dynamicTotal += meatzza.price();
        }
        else if(pizza.equals(SEAFOOD)){
            Seafood seafood = new Seafood(getSize(), extraCheese.isSelected(),
                    extraSauce.isSelected());
            dynamicTotal += seafood.price();
        }
        else if(pizza.equals(PEPPERONI)){
            Pepperoni pepperoni = new Pepperoni(getSize(), extraCheese.isSelected(),
                    extraSauce.isSelected());
            dynamicTotal += pepperoni.price();
        }
        else if(pizza.equals(SUPREME)){
            Supreme supreme = new Supreme(getSize(), extraCheese.isSelected(),
                    extraSauce.isSelected());
            dynamicTotal += supreme.price();
        }
        else if(pizza.equals(DELUXE)){
            Deluxe deluxe = new Deluxe(getSize(), extraCheese.isSelected(),
                    extraSauce.isSelected());
            dynamicTotal += deluxe.price();
        }
        String newTotal = new DecimalFormat("0.00").format(dynamicTotal);
        total.setText("$" + newTotal);
    }

    private void displayToppings(String pizza){
        if(pizza.equals(MEATZZA)){
            Meatzza meatzza = new Meatzza(Size.SMALL, false, false);
            toppingsList.setItems(meatzza.getToppings());
        }
        else if(pizza.equals(SEAFOOD)){
            Seafood seafood = new Seafood(Size.SMALL, false, false);
            toppingsList.setItems(seafood.getToppings());
        }
        else if(pizza.equals(PEPPERONI)){
            Pepperoni pepperoni = new Pepperoni(Size.SMALL, false, false);
            toppingsList.setItems(pepperoni.getToppings());
        }
        else if(pizza.equals(SUPREME)){
            Supreme supreme = new Supreme(Size.SMALL, false, false);
            toppingsList.setItems(supreme.getToppings());
        }
        else if(pizza.equals(DELUXE)){
            Deluxe deluxe = new Deluxe(Size.SMALL, false, false);
            toppingsList.setItems(deluxe.getToppings());
        }
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
        order.addPizzaToOrder(pizza);
        testOrderOutput.appendText(order.displayOrder());
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
        Pizza pizza = null;
        if(pizzaSelected.equals(MEATZZA)){
            pizza = PizzaMaker.createPizza(MEATZZA);
        }
        else if(pizzaSelected.equals(SEAFOOD)){
            pizza = PizzaMaker.createPizza(SEAFOOD);
        }
        else if(pizzaSelected.equals(PEPPERONI)){
            pizza = PizzaMaker.createPizza(PEPPERONI);
        }
        else if(pizzaSelected.equals(SUPREME)){
            pizza = PizzaMaker.createPizza(SUPREME);
        }
        else if(pizzaSelected.equals(DELUXE)){
            pizza = PizzaMaker.createPizza(DELUXE);
        }
        return pizza;
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
