package com.example.smproject4;

import java.util.ArrayList;

public class StoreOrders {
    private static int orderNumber = 1;
    private ArrayList<Order> storeOrders = new ArrayList<>();
    private ArrayList<Integer> orderNumbers = new ArrayList<>();

    public void addOrder(Order order){
        storeOrders.add(order);
        System.out.println("Added " + order.displayOrder());
        orderNumbers.add(orderNumber);
        orderNumber++;
    }

    public ArrayList<Integer> getOrderNumbers(){
        return orderNumbers;
    }

    public ArrayList<Order> getOrders(){
        return storeOrders;
    }
}
