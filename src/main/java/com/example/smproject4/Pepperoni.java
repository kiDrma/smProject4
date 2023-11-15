package com.example.smproject4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Pepperoni extends Pizza{
    private final double BASE_PRICE = 10.99;

    /**
     * Constructor using given size, extra cheese, and extra sauce.
     * @param size
     * @param extraCheese
     * @param extraSauce
     */
    public Pepperoni(Size size, boolean extraCheese, boolean extraSauce){
        this.toppings = new ArrayList<>();
        initializeToppings();
        this.sauce = Sauce.TOMATO;
        if(size == null){
            this.size = Size.SMALL;
        }
        else{
            this.size = size;
        }
        this.extraCheese = extraCheese;
        this.extraSauce = extraSauce;
    }

    /**
     * Initializes the arraylist of toppings for a Meatzza pizza.
     */
    private void initializeToppings(){
        toppings.add(Topping.PEPPERONI);
    }

    /**
     * Determines the price of the pepperoni pizza.
     * @return price of the pizza.
     */
    public double price(){
        double price = BASE_PRICE;
        if(this.size == Size.MEDIUM){
            price += MEDIUM_PRICE_INCREASE;
        }
        else if (this.size == Size.LARGE){
            price += LARGE_PRICE_INCREASE;
        }
        if(extraCheese == true){
            price += EXTRA_PRICE_INCREASE;
        }
        if(extraSauce == true){
            price += EXTRA_PRICE_INCREASE;
        }
        return price;
    }
}
