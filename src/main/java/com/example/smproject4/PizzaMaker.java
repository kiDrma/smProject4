package com.example.smproject4;

import java.util.ArrayList;

public class PizzaMaker {
    private static final String CUSTOM = "Custom";
    private static final String DELUXE = "Deluxe";
    private static final String MEATZZA = "Meatzza";
    private static final String PEPPERONI = "Pepperoni";
    private static final String SEAFOOD = "Seafood";
    private static final String SUPREME = "Supreme";


    /**
     * Creates a pizza given the pizzaType
     * @param pizzaType
     * @return the pizza type if exists, else return null
     */
    public static Pizza createPizza(String pizzaType) {
        switch (pizzaType) {
            default:
                return null;
            case DELUXE:
                return new Deluxe();
            case MEATZZA:
                return new Meatzza();
            case PEPPERONI:
                return new Pepperoni();
            case SEAFOOD:
                return new Seafood();
            case SUPREME:
                return new Supreme();
            case CUSTOM:
                ArrayList<Topping> tempToppings = new ArrayList<Topping>();
                return new BuildYourOwn(tempToppings, Sauce.TOMATO, Size.SMALL, false, false);
        }
    }
}
