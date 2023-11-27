package com.example.smproject4;
import java.util.ArrayList;
/**
 * Define the data type BuildYourOwn.
 * @KimberlyDonnarumma
 * @DanielZhang
 */
public class BuildYourOwn extends Pizza{
    private final int TOPPINGS_INCLUDED = 3;
    private final double BASE_PRICE = 8.99;
    private final double TOPPING_PRICE = 1.49;

    private int numberOfToppings = 0;

    /**
     * Constructor using given toppings, given sauce, given size,
     * extra cheese, and extra sauce.
     * @param toppingsArg
     * @param sauce
     * @param size
     * @param extraCheese
     * @param extraSauce
     */
    public BuildYourOwn(ArrayList<Topping> toppingsArg, Sauce sauce, Size size,
                        boolean extraCheese, boolean extraSauce){
        toppings = toppingsArg;
        numberOfToppings = toppingsArg.size();

        this.sauce = sauce;
        this.size = size;
        this.extraCheese = extraCheese;
        this.extraSauce = extraSauce;
    }
/* temp comment out in case we actually can't use ArrayList
    /**
     * Initializes the arraylist of toppings for a Custom pizza.
     *\/
    private void initializeToppings(Topping[] toppings){
        for (Topping topping : toppings) {
            numberOfToppings++;
            this.toppings.add(topping);
        }
    }
*/

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
        if(toppings.size() <= TOPPINGS_INCLUDED){
            return price;
        }
        price += (toppings.size() - TOPPINGS_INCLUDED) * TOPPING_PRICE;
        return price;
    }

    /**
     * Converts the Custom pizza to string.
     * @return String of the pizza.
     */
    public String toString(){
        String output = "Type: Custom ";
        output += "Size: " + size.toString() + " ";
        output += "Sauce: " + sauce.toString();
        output += "\nToppings: " + this.getToppings();
        output += "\n";
        if(extraCheese){
            output += "Extra cheese\n";
        }
        if(extraSauce){
            output+= "Extra sauce\n";
        }
        output += "Price: $" + price();
        return output;
    }
}
