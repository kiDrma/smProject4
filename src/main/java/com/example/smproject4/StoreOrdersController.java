package com.example.smproject4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
/**
 * Controller for StoreOrders screen.
 * @KimberlyDonnarumma
 * @DanielZhang
 */
public class StoreOrdersController implements Initializable{
    @FXML
    private ListView ordersList;
    @FXML
    private ListView pizzasList;
    @FXML
    private TextArea currentPizza;
    @FXML
    private TextField total;

    private SingletonStoreOrders s = SingletonStoreOrders.getInstance();

    /**
     * Initializes the store orders screen with event handlers.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String zero = new DecimalFormat("0.00").format(0);
        total.setText("$" + zero);
        ordersList.setItems(FXCollections.observableArrayList(s.getStoreOrders().getOrderNumbers()));
        ordersList.setOnMouseClicked(event -> {
            int index = ordersList.getSelectionModel().getSelectedIndex();
            if(index != -1) {
                Order selectedOrder = s.getStoreOrders().getOrders().get(index);
                ObservableList<String> listOfPizzas = FXCollections.observableArrayList(selectedOrder.getPizzaListBasicNames());
                currentPizza.clear();
                pizzasList.setItems(listOfPizzas);
                String theTotal = new DecimalFormat("0.00").format(selectedOrder.getOrderTotal());
                total.setText("$" + theTotal);
            }
        });
        pizzasList.setOnMouseClicked(event -> {
            int indexOrder = ordersList.getSelectionModel().getSelectedIndex();
            int indexPizza = pizzasList.getSelectionModel().getSelectedIndex();
            if(indexPizza != -1) {
                Order selectedOrder = s.getStoreOrders().getOrders().get(indexOrder);
                Pizza selectedPizza = selectedOrder.getPizzaList().get(indexPizza);
                currentPizza.clear();
                currentPizza.appendText(selectedPizza.toString());
            }
        });
    }

    /**
     * Exports the store orders.
     */
    @FXML
    public void export(){
        StoreOrders storeOrders = s.getStoreOrders();
        storeOrders.export();
        s.resetStoreOrders();
        resetAllScreens();
    }

    /**
     * Cancels an order.
     */
    @FXML
    protected void cancelOrder(){
        int index = ordersList.getSelectionModel().getSelectedIndex();
        if(index == -1){
            return;
        }
        Order orderBeingCancelled = s.getStoreOrders().getOrders().get(index);
        int orderNumberBeingCancelled = s.getStoreOrders().getOrderNumbers().get(index);
        s.getStoreOrders().removeOrder(orderBeingCancelled, orderNumberBeingCancelled);
        resetAllScreens();
    }

    /**
     * Resets all fields to default values.
     */
    private void resetAllScreens(){
        ordersList.setItems(FXCollections.observableArrayList(s.getStoreOrders().getOrderNumbers()));
        pizzasList.getItems().clear();
        currentPizza.clear();
        String zero = new DecimalFormat("0.00").format(0);
        total.setText("$" + zero);
    }
}
