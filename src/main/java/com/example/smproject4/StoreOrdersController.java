package com.example.smproject4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

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

    public void export(){

    }

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

    private void resetAllScreens(){
        ordersList.setItems(FXCollections.observableArrayList(s.getStoreOrders().getOrderNumbers()));
        pizzasList.getItems().clear();
        currentPizza.clear();
        String zero = new DecimalFormat("0.00").format(0);
        total.setText("$" + zero);
    }
}
