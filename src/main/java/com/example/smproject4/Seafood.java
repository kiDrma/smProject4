package com.example.smproject4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Seafood extends Pizza{
    private final double BASE_PRICE = 17.99;

    /**
     * Constructor using given size, extra cheese, and extra sauce.
     * @param size
     * @param extraCheese
     * @param extraSauce
     */
    public Seafood(Size size, boolean extraCheese, boolean extraSauce){
        this.toppings = new ArrayList<>();
        initializeToppings();
        this.sauce = Sauce.ALFREDO;
        this.size = size;
        this.extraCheese = extraCheese;
        this.extraSauce = extraSauce;
    }

    /**
     * Initializes the arraylist of toppings for a Seafood pizza.
     */
    private void initializeToppings(){
        toppings.add(Topping.SHRIMP);
        toppings.add(Topping.SQUID);
        toppings.add(Topping.CRAB_MEATS);
    }

    /**
     * Determines the price of the Seafood pizza.
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
