package com.example.smproject4;
/**
 * Define singleton for global Order variable.
 * @KimberlyDonnarumma
 * @DanielZhang
 */
public class SingletonOrder {
    private static SingletonOrder s;
    private static Order order;

    /**
     * Returns the global order object.
     * @return order.
     */
    public Order getOrder(){
        return order;
    }

    /**
     * Sets the global order object.
     * @param o
     */
    public void setOrder(Order o){
        order = o;
    }

    /**
     * Returns the global singleton order; if there isn't one, makes one.
     * @return singleton order.
     */
    public static synchronized SingletonOrder getInstance(){
        if(s == null){
            s = new SingletonOrder();
            order = new Order();
        }
        return s;
    }
}
