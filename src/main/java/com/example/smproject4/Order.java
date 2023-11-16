package com.example.smproject4;

import java.util.ArrayList;

public class Order {
    private static int orderNumber = 1;
    private static ArrayList<Pizza> pizzaList;

    public Order(){
        if(pizzaList == null){
            pizzaList = new ArrayList<>();
        }
    }

    public void addPizzaToOrder(Pizza pizza){
        pizzaList.add(pizza);
    }

    public ArrayList<Pizza> getPizzaList(){
        return pizzaList;
    }

    public ArrayList<String> getPizzaListToString(){
        ArrayList<String> listOfPizzas = new ArrayList();
        for(Pizza pizza : pizzaList){
            String order = "";
            order += "Type: " +
                    pizza.getClass().getSimpleName() +
                    " Size: " + pizza.getSize().toString();
            if(pizza.extraCheese){
                order += " Extra Cheese";
            }
            if(pizza.extraSauce){
                order += " Extra Sauce";
            }
            listOfPizzas.add(order);
        }
        return listOfPizzas;
    }

    public ArrayList<String> getPizzaListBasicNames(){
        ArrayList<String> list = new ArrayList<>();
        for(Pizza pizza : pizzaList){
            list.add(pizza.getClass().getSimpleName());
        }
        return list;
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
