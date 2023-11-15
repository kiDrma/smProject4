package com.example.smproject4;

import com.almasb.fxgl.core.collection.Array;

import java.util.ArrayList;

public class PizzaMaker {
    public static Pizza createPizza(String pizzaType) {
        switch (pizzaType) {
            default:
                return null;
            case "custom":
                ArrayList<Topping> tempToppings = new ArrayList<Topping>();
                return new Custom(tempToppings, Sauce.TOMATO, Size.SMALL, false, false);
        }
    }
}
