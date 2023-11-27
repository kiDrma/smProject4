package com.example.smproject4;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * JUnit test class for testing BuildYourOwn's price() method.
 * @KimberlyDonnarumma
 * @DanielZhang
 */
public class BuildYourOwnTest {
    private ArrayList<Topping> NO_TOPPINGS = new ArrayList<>();
    private ArrayList<Topping> THREE_TOPPINGS =  new ArrayList<>(Arrays.asList(
            Topping.SAUSAGE, Topping.HAM, Topping.PEPPERONI));
    private ArrayList<Topping> FOUR_TOPPINGS = new ArrayList<>(Arrays.asList(
            Topping.SAUSAGE, Topping.HAM, Topping.PEPPERONI, Topping.GREEN_PEPPER));

    private final double EXTRA_PRICE_INCREASE = 1;
    private final double EXTRA_TOPPING_INCREASE = 1.49;

    private final double SMALL_PIZZA_BASE = 8.99;
    private final double MEDIUM_PIZZA_BASE = 10.99;
    private final double LARGE_PIZZA_BASE = 12.99;

    @Test
    public void testSmallPriceNoToppings(){
        PizzaMaker pizzaMaker = new PizzaMaker();
        BuildYourOwn output = (BuildYourOwn)pizzaMaker.createPizza("Custom");
        output.setExtraCheese(false);
        output.setExtraSauce(false);
        output.setSize(Size.SMALL);
        output.setSauceType(Sauce.TOMATO);
        output.setToppings(NO_TOPPINGS);

        assertEquals(SMALL_PIZZA_BASE, output.price(), Double.MIN_VALUE);

        output.setExtraCheese(true);

        assertEquals(SMALL_PIZZA_BASE + EXTRA_PRICE_INCREASE,
                output.price(), Double.MIN_VALUE);

        output.setExtraSauce(true);

        assertEquals(SMALL_PIZZA_BASE + (EXTRA_PRICE_INCREASE * 2),
                output.price(), Double.MIN_VALUE);
    }

    @Test
    public void testSmallPriceThreeToppings(){
        PizzaMaker pizzaMaker = new PizzaMaker();
        BuildYourOwn output = (BuildYourOwn)pizzaMaker.createPizza("Custom");
        output.setExtraCheese(false);
        output.setExtraSauce(false);
        output.setSize(Size.SMALL);
        output.setSauceType(Sauce.TOMATO);
        output.setToppings(THREE_TOPPINGS);

        assertEquals(SMALL_PIZZA_BASE, output.price(), Double.MIN_VALUE);

        output.setExtraCheese(true);

        assertEquals(SMALL_PIZZA_BASE + EXTRA_PRICE_INCREASE,
                output.price(), Double.MIN_VALUE);

        output.setExtraSauce(true);

        assertEquals(SMALL_PIZZA_BASE + (EXTRA_PRICE_INCREASE * 2),
                output.price(), Double.MIN_VALUE);
    }

    @Test
    public void testSmallPriceOverThreeToppings(){
        PizzaMaker pizzaMaker = new PizzaMaker();
        BuildYourOwn output = (BuildYourOwn)pizzaMaker.createPizza("Custom");
        output.setExtraCheese(false);
        output.setExtraSauce(false);
        output.setSize(Size.SMALL);
        output.setSauceType(Sauce.TOMATO);
        ArrayList<Topping> changingToppings = FOUR_TOPPINGS;
        output.setToppings(changingToppings);

        assertEquals(SMALL_PIZZA_BASE + EXTRA_TOPPING_INCREASE,
                output.price(), Double.MIN_VALUE);

        changingToppings.add(Topping.BEEF);
        output.setToppings(changingToppings);

        assertEquals(SMALL_PIZZA_BASE + (EXTRA_TOPPING_INCREASE * 2),
                output.price(), Double.MIN_VALUE);

        changingToppings.add(Topping.ONION);
        output.setToppings(changingToppings);

        assertEquals(SMALL_PIZZA_BASE + (EXTRA_TOPPING_INCREASE * 3),
                output.price(), Double.MIN_VALUE);

        changingToppings.add(Topping.MUSHROOM);
        output.setToppings(changingToppings);

        assertEquals(SMALL_PIZZA_BASE + (EXTRA_TOPPING_INCREASE * 4),
                output.price(), Double.MIN_VALUE);

        output.setExtraCheese(true);

        assertEquals(SMALL_PIZZA_BASE + (EXTRA_TOPPING_INCREASE * 4)
                + EXTRA_PRICE_INCREASE, output.price(), Double.MIN_VALUE);

        output.setExtraSauce(true);

        assertEquals(SMALL_PIZZA_BASE + (EXTRA_TOPPING_INCREASE * 4)
                + (EXTRA_PRICE_INCREASE * 2), output.price(), Double.MIN_VALUE);
    }

    @Test
    public void testMediumPriceNoToppings(){
        PizzaMaker pizzaMaker = new PizzaMaker();
        BuildYourOwn output = (BuildYourOwn)pizzaMaker.createPizza("Custom");
        output.setExtraCheese(false);
        output.setExtraSauce(false);
        output.setSize(Size.MEDIUM);
        output.setSauceType(Sauce.TOMATO);
        output.setToppings(NO_TOPPINGS);

        assertEquals(MEDIUM_PIZZA_BASE, output.price(), Double.MIN_VALUE);

        output.setExtraCheese(true);

        assertEquals(MEDIUM_PIZZA_BASE + EXTRA_PRICE_INCREASE,
                output.price(), Double.MIN_VALUE);

        output.setExtraSauce(true);

        assertEquals(MEDIUM_PIZZA_BASE + (EXTRA_PRICE_INCREASE * 2),
                output.price(), Double.MIN_VALUE);
    }

    @Test
    public void testMediumPriceThreeToppings(){
        PizzaMaker pizzaMaker = new PizzaMaker();
        BuildYourOwn output = (BuildYourOwn)pizzaMaker.createPizza("Custom");
        output.setExtraCheese(false);
        output.setExtraSauce(false);
        output.setSize(Size.MEDIUM);
        output.setSauceType(Sauce.TOMATO);
        output.setToppings(THREE_TOPPINGS);

        assertEquals(MEDIUM_PIZZA_BASE, output.price(), Double.MIN_VALUE);

        output.setExtraCheese(true);

        assertEquals(MEDIUM_PIZZA_BASE + EXTRA_PRICE_INCREASE,
                output.price(), Double.MIN_VALUE);

        output.setExtraSauce(true);

        assertEquals(MEDIUM_PIZZA_BASE + (EXTRA_PRICE_INCREASE * 2),
                output.price(), Double.MIN_VALUE);
    }

    @Test
    public void testMediumPriceOverThreeToppings(){
        PizzaMaker pizzaMaker = new PizzaMaker();
        BuildYourOwn output = (BuildYourOwn)pizzaMaker.createPizza("Custom");
        output.setExtraCheese(false);
        output.setExtraSauce(false);
        output.setSize(Size.MEDIUM);
        output.setSauceType(Sauce.TOMATO);
        ArrayList<Topping> changingToppings = FOUR_TOPPINGS;
        output.setToppings(changingToppings);

        assertEquals(MEDIUM_PIZZA_BASE + EXTRA_TOPPING_INCREASE,
                output.price(), Double.MIN_VALUE);

        changingToppings.add(Topping.BEEF);
        output.setToppings(changingToppings);

        assertEquals(MEDIUM_PIZZA_BASE + (EXTRA_TOPPING_INCREASE * 2),
                output.price(), Double.MIN_VALUE);

        changingToppings.add(Topping.ONION);
        output.setToppings(changingToppings);

        assertEquals(MEDIUM_PIZZA_BASE + (EXTRA_TOPPING_INCREASE * 3),
                output.price(), Double.MIN_VALUE);

        changingToppings.add(Topping.MUSHROOM);
        output.setToppings(changingToppings);

        assertEquals(MEDIUM_PIZZA_BASE + (EXTRA_TOPPING_INCREASE * 4),
                output.price(), Double.MIN_VALUE);

        output.setExtraCheese(true);

        assertEquals(MEDIUM_PIZZA_BASE + (EXTRA_TOPPING_INCREASE * 4)
                + EXTRA_PRICE_INCREASE, output.price(), Double.MIN_VALUE);

        output.setExtraSauce(true);

        assertEquals(MEDIUM_PIZZA_BASE + (EXTRA_TOPPING_INCREASE * 4)
                + (EXTRA_PRICE_INCREASE * 2), output.price(), Double.MIN_VALUE);
    }

    @Test
    public void testLargePriceNoToppings(){
        PizzaMaker pizzaMaker = new PizzaMaker();
        BuildYourOwn output = (BuildYourOwn)pizzaMaker.createPizza("Custom");
        output.setExtraCheese(false);
        output.setExtraSauce(false);
        output.setSize(Size.LARGE);
        output.setSauceType(Sauce.TOMATO);
        output.setToppings(NO_TOPPINGS);

        assertEquals(LARGE_PIZZA_BASE, output.price(), Double.MIN_VALUE);

        output.setExtraCheese(true);

        assertEquals(LARGE_PIZZA_BASE + EXTRA_PRICE_INCREASE,
                output.price(), Double.MIN_VALUE);

        output.setExtraSauce(true);

        assertEquals(LARGE_PIZZA_BASE + (EXTRA_PRICE_INCREASE * 2),
                output.price(), Double.MIN_VALUE);
    }

    @Test
    public void testLargePriceThreeToppings(){
        PizzaMaker pizzaMaker = new PizzaMaker();
        BuildYourOwn output = (BuildYourOwn)pizzaMaker.createPizza("Custom");
        output.setExtraCheese(false);
        output.setExtraSauce(false);
        output.setSize(Size.LARGE);
        output.setSauceType(Sauce.TOMATO);
        output.setToppings(THREE_TOPPINGS);

        assertEquals(LARGE_PIZZA_BASE, output.price(), Double.MIN_VALUE);

        output.setExtraCheese(true);

        assertEquals(LARGE_PIZZA_BASE + EXTRA_PRICE_INCREASE,
                output.price(), Double.MIN_VALUE);

        output.setExtraSauce(true);

        assertEquals(LARGE_PIZZA_BASE + (EXTRA_PRICE_INCREASE * 2),
                output.price(), Double.MIN_VALUE);
    }

    @Test
    public void testLargePriceOverThreeToppings(){
        PizzaMaker pizzaMaker = new PizzaMaker();
        BuildYourOwn output = (BuildYourOwn)pizzaMaker.createPizza("Custom");
        output.setExtraCheese(false);
        output.setExtraSauce(false);
        output.setSize(Size.LARGE);
        output.setSauceType(Sauce.TOMATO);
        ArrayList<Topping> changingToppings = FOUR_TOPPINGS;
        output.setToppings(changingToppings);

        assertEquals(LARGE_PIZZA_BASE + EXTRA_TOPPING_INCREASE,
                output.price(), Double.MIN_VALUE);

        changingToppings.add(Topping.BEEF);
        output.setToppings(changingToppings);

        assertEquals(LARGE_PIZZA_BASE + (EXTRA_TOPPING_INCREASE * 2),
                output.price(), Double.MIN_VALUE);

        changingToppings.add(Topping.ONION);
        output.setToppings(changingToppings);

        assertEquals(LARGE_PIZZA_BASE + (EXTRA_TOPPING_INCREASE * 3),
                output.price(), Double.MIN_VALUE);

        changingToppings.add(Topping.MUSHROOM);
        output.setToppings(changingToppings);

        assertEquals(LARGE_PIZZA_BASE + (EXTRA_TOPPING_INCREASE * 4),
                output.price(), Double.MIN_VALUE);

        output.setExtraCheese(true);

        assertEquals(LARGE_PIZZA_BASE + (EXTRA_TOPPING_INCREASE * 4)
                + EXTRA_PRICE_INCREASE, output.price(), Double.MIN_VALUE);

        output.setExtraSauce(true);

        assertEquals(LARGE_PIZZA_BASE + (EXTRA_TOPPING_INCREASE * 4)
                + (EXTRA_PRICE_INCREASE * 2), output.price(), Double.MIN_VALUE);
    }
}
