package com.example.smproject4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.DecimalFormat;
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

    /**
     * Sets the toppings to the elements inside the ArrayList toppingsArg
     * @param toppingsArg
     */
    public void setToppings(ArrayList<Topping> toppingsArg){
        toppings = toppingsArg;
    }

    /**
     * Sets the sauce to newSauce
     * @param newSauce
     */
    public void setSauceType(Sauce newSauce){
        sauce = newSauce;
    }

    /**
     * Sets the extraCheese value to true or false
     * @param extra
     */
    public void setExtraCheese(boolean extra){
        extraCheese = extra;
    }

    /**
     * Sets the extraSauce value to true or false
     * @param extra
     */
    public void setExtraSauce(boolean extra){
        extraSauce = extra;
    }

    /**
     * Sets the size value to newSize
     * @param newSize
     */
    public void setSize(Size newSize){
        size = newSize;
    }

    /**
     * Returns the current toppings on the pizza
     * @return an ObservablList<Topping> of the current toppings on the pizza
     */
    public ObservableList<Topping> getToppings(){
        return FXCollections.observableArrayList(toppings);
    }

    /**
     * Gets the current size of the pizza
     * @return the pizza's Size variable
     */
    public Size getSize(){
        return this.size;
    }

    /**
     * Gets the current price of the pizza
     * @return the price as a double
     */
    public double getPrice(){
        return price();
    }

    /**
     * Gets information on this pizza as a formatted string
     * @return formatted human-readable information on the pizza as a string
     */
    @Override
    public String toString(){
        String s = "";
        s += "Type: " + this.getClass().getSimpleName() + " Size: "
            + this.size + " Sauce: " + this.sauce + "\nToppings: "
            + this.getToppings() + "\n";
        if(this.extraCheese){
            s += "Extra cheese \n";
        }
        if(this.extraSauce){
            s += "Extra sauce \n";
        }
        String price = new DecimalFormat("0.00").format(this.getPrice());
        s += "Price: $" + price;
        return s;
    }
}
