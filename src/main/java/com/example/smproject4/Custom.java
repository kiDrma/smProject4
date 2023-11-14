package com.example.smproject4;

public class Custom extends Pizza{
    private final double BASE_PRICE = 8.99;
    private final double TOPPING_PRICE = 1.49;

    private int numberOfToppings = 0;

    /**
     * Constructor using given toppings, given sauce, given size,
     * extra cheese, and extra sauce.
     * @param toppings
     * @param sauce
     * @param size
     * @param extraCheese
     * @param extraSauce
     */
    public Custom(Topping[] toppings, Sauce sauce, Size size,
                  boolean extraCheese, boolean extraSauce){
        initializeToppings(toppings);
        this.sauce = sauce;
        this.size = size;
        this.extraCheese = extraCheese;
        this.extraSauce = extraSauce;
    }

    /**
     * Initializes the arraylist of toppings for a Custom pizza.
     */
    private void initializeToppings(Topping[] toppings){
        for (Topping topping : toppings) {
            numberOfToppings++;
            this.toppings.add(topping);
        }
    }

    /**
     * Determines the price of the Custom pizza.
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
        price += numberOfToppings * TOPPING_PRICE;
        return price;
    }
}
