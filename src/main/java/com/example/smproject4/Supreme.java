package com.example.smproject4;

public class Supreme extends Pizza{
    private final double BASE_PRICE = 15.99;

    /**
     * Constructor using given size, extra cheese, and extra sauce.
     * @param size
     * @param extraCheese
     * @param extraSauce
     */
    public Supreme(Size size, boolean extraCheese, boolean extraSauce){
        initializeToppings();
        this.sauce = Sauce.TOMATO;
        this.size = size;
        this.extraCheese = extraCheese;
        this.extraSauce = extraSauce;
    }

    /**
     * Initializes the arraylist of toppings for a Supreme pizza.
     */
    private void initializeToppings(){
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.HAM);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.ONION);
        toppings.add(Topping.BLACK_OLIVE);
        toppings.add(Topping.MUSHROOM);
    }

    /**
     * Determines the price of the Supreme pizza.
     * @return price of the pizza.
     */    public double price(){
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
