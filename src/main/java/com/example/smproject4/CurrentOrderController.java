package com.example.smproject4;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;

import java.util.ResourceBundle;

public class CurrentOrderController implements Initializable{
    private SingletonOrder order = SingletonOrder.getInstance();
    private SingletonStoreOrders storeOrders = SingletonStoreOrders.getInstance();
    private static final double TAX_RATE = .0625;
    @FXML
    private ListView listOfPizzas;
    @FXML
    private TextArea currentPizza;
    @FXML
    private TextField numberOfPizzas;
    @FXML
    private TextField netPrice;
    @FXML
    private TextField salesTax;
    @FXML
    private TextField total;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listOfPizzas.setItems(FXCollections.observableArrayList(order.getOrder().getPizzaListBasicNames()));
        String net = new DecimalFormat("0.00").format(calculateNetPrice());
        netPrice.setText("$" + net);
        String tax = new DecimalFormat("0.00").format(calculateTax());
        salesTax.setText("$" + tax);
        String totalPrice = new DecimalFormat("0.00").format(calculateTotal());
        total.setText("$" + totalPrice);
        numberOfPizzas.setText("" + order.getOrder().getPizzaList().size());
        listOfPizzas.setOnMouseClicked(event -> {
            int index = listOfPizzas.getSelectionModel().getSelectedIndex();
            if(index != -1){
                Pizza selectedPizza = order.getOrder().getPizzaList().get(index);
                String pizzaString = selectedPizza.toString();
                currentPizza.setText(pizzaString);
            }
        });
    }

    @FXML
    protected void onRemovePizzaClick(){
        int index = listOfPizzas.getSelectionModel().getSelectedIndex();
        if(index == -1){
            return;
        }
        order.getOrder().getPizzaList().remove(index);
        listOfPizzas.setItems(FXCollections.observableArrayList(order.getOrder().getPizzaListBasicNames()));
        resetAllFields();
    }

    private double calculateTotal(){
        double total = calculateNetPrice() + calculateTax();
        return total;
    }

    private double calculateNetPrice(){
        double net = 0;
        for(Pizza pizza : order.getOrder().getPizzaList()){
            net += pizza.getPrice();
        }
        return net;
    }

    private double calculateTax(){
        double tax = calculateNetPrice() * TAX_RATE;
        return tax;
    }

    @FXML
    protected void onPlaceOrderClick(){
        // Add implementation to place the order in a list before deleting.
        Order addedOrder = new Order(order.getOrder());
        storeOrders.addOrder(addedOrder);
        order.getOrder().resetOrder();
        listOfPizzas.getItems().clear();
        resetAllFields();
    }

    private void resetAllFields(){
        String net = new DecimalFormat("0.00").format(calculateNetPrice());
        String tax = new DecimalFormat("0.00").format(calculateTax());
        String theTotal = new DecimalFormat("0.00").format(calculateTotal());
        netPrice.setText("$" + net);
        salesTax.setText("$" + tax);
        total.setText("$" + theTotal);
        numberOfPizzas.setText("" + order.getOrder().getPizzaList().size());
        currentPizza.clear();
    }
}
