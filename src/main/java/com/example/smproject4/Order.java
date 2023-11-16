package com.example.smproject4;

import java.util.ArrayList;

public class Order {
    private static int orderNumber = 1;
    private static ArrayList<Pizza> pizzaList;

    public Order(){
        pizzaList = new ArrayList<>();
    }

    public void addPizzaToOrder(Pizza pizza){
        pizzaList.add(pizza);
    }

    public String displayOrder(){
        String order = "";
        for(Pizza pizza : pizzaList){
            order += "Order #" + orderNumber + " Type: " +
                    pizza.getClass().getSimpleName() +
                    " Size: " + pizza.getSize().toString();
            if(pizza.extraCheese){
                order += " Extra Cheese";
            }
            if(pizza.extraSauce){
                order += " Extra Sauce";
            }
            order += "\n";
        }
        return order;
    }

    public void resetOrder(){
        pizzaList.clear();
        orderNumber++;
    }
}
