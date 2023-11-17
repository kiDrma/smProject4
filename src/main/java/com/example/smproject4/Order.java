package com.example.smproject4;

import java.util.ArrayList;

public class Order {
    private ArrayList<Pizza> pizzaList;
    private final double TAX_RATE = .0625;

    public Order(){
        pizzaList = new ArrayList<>();
    }

    public Order(Order order){
        this.pizzaList = new ArrayList<>(order.getPizzaList());
    }

    public double getOrderTotal(){
        double total = 0;
        for(Pizza pizza : pizzaList){
            total += pizza.getPrice();
        }
        total += total * TAX_RATE;
        return total;
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

    public String getPizzaListBasicNamesToString(){
        String pizzas = "";
        for(Pizza pizza : pizzaList){
            pizzas += pizza.getClass().getSimpleName() + "\n";
        }
        return pizzas;
    }

    public String displayOrder(){
        String order = "";
        for(Pizza pizza : pizzaList){
            order += "Type: " +
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
    }
}
