package com.example.smproject4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StoreOrders {
    private static int orderNumber = 1;
    private ArrayList<Order> storeOrders;
    private ArrayList<Integer> orderNumbers;

    public StoreOrders(){
        storeOrders = new ArrayList<>();
        orderNumbers = new ArrayList<>();
    }

    public void addOrder(Order order){
        storeOrders.add(order);
        orderNumbers.add(orderNumber);
        orderNumber++;
    }

    public void removeOrder(Order order, int orderNumber){
        storeOrders.remove(order);
        orderNumbers.remove((Integer)orderNumber);
    }

    public ArrayList<Integer> getOrderNumbers(){
        return orderNumbers;
    }

    public ArrayList<Order> getOrders(){
        return storeOrders;
    }
}
