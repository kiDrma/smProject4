package com.example.smproject4;
import java.util.ArrayList;

public abstract class Pizza {
    protected ArrayList<Topping> toppings; //Topping is a enum class
    protected Size size; //Size is a enum class
    protected Sauce sauce; //Sauce is a enum class
    protected boolean extraSauce;
    protected boolean extraCheese;

    protected double MEDIUM_PRICE_INCREASE = 2;
    protected double LARGE_PRICE_INCREASE = 4;
    protected double EXTRA_PRICE_INCREASE = 1;

    public abstract double price(); //polymorphism
}
