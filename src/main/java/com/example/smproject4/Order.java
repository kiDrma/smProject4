package com.example.smproject4;

import java.text.DecimalFormat;
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

    /**
     * Gets the total price of the order
     * @return the total price of the order
     */
    public double getOrderTotal(){
        double total = 0;
        for(Pizza pizza : pizzaList){
            total += pizza.getPrice();
        }
        total += total * TAX_RATE;
        return total;
    }

    /**
     * Adds pizza to order
     * @param pizza is the pizza to add
     */
    public void addPizzaToOrder(Pizza pizza){
        pizzaList.add(pizza);
    }

    /**
     * Gets the pizzaList
     * @return the pizzaList
     */
    public ArrayList<Pizza> getPizzaList(){
        return pizzaList;
    }

    /**
     * Gets String of pizza list
     * @return list of pizzas as a string
     */
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

    /**
     * Gets String of pizza list with basic names
     * @return list of pizzas as a string, with basic names
     */
    public ArrayList<String> getPizzaListBasicNames(){
        ArrayList<String> list = new ArrayList<>();
        for(Pizza pizza : pizzaList){
            if(pizza instanceof BuildYourOwn){
                list.add("Custom");
            }
            else{
                list.add(pizza.getClass().getSimpleName());
            }
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

    /**
     * Gets string of order details
     * @return the order as a readable string
     */
    public String displayOrder(){
        String order = "";
        int i = 1;
        for(Pizza pizza : pizzaList){
            order += "Pizza #" + i + "\n";
            order += "Type: " +
                    pizza.getClass().getSimpleName() +
                    " Size: " + pizza.getSize().toString();
            if(pizza.extraCheese){
                order += " Extra Cheese";
            }
            if(pizza.extraSauce){
                order += " Extra Sauce";
            }
            order += "\nToppings: " + pizza.getToppings().toString() + "\n";
            String price = new DecimalFormat("0.00").format(pizza.getPrice());
            order += "Price: $" + price;
            order += "\n";
            i++;
        }
        return order;
    }


    /**
     * Clears pizzas in list
     */
    public void resetOrder(){
        pizzaList.clear();
    }
}
