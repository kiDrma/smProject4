package com.example.smproject4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 * Define the abstract data type Pizza.
 * @KimberlyDonnarumma
 * @DanielZhang
 */
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


    public void setToppings(ArrayList<Topping> toppingsArg){
        toppings = toppingsArg;
    }

    public void setSauceType(Sauce newSauce){
        sauce = newSauce;
    }

    public void setExtraCheese(boolean extra){
        extraCheese = extra;
    }
    public void setExtraSauce(boolean extra){
        extraSauce = extra;
    }
    public void setSize(Size newSize){
        size = newSize;
    }

    public ObservableList<Topping> getToppings(){
        return FXCollections.observableArrayList(toppings);
    }

    public Size getSize(){
        return this.size;
    }

    public double getPrice(){
        return price();
    }

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
