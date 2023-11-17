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
        ordersList.setItems(FXCollections.observableArrayList(s.getStoreOrders().getOrderNumbers()));
        ordersList.setOnMouseClicked(event -> {
            int index = ordersList.getSelectionModel().getSelectedIndex();
            if(index != -1){
                Order selectedOrder = s.getStoreOrders().getOrders().get(index);
                String listOfPizzas = selectedOrder.getPizzaListBasicNamesToString();
                System.out.println("List of Pizzas: " + listOfPizzas);
                System.out.println("Selected order: " + index);
                pizzasList.getItems().add(listOfPizzas);}
        });
    }
}
