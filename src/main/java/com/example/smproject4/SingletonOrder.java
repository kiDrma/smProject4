package com.example.smproject4;
/**
 * Define singleton for global Order variable.
 * @KimberlyDonnarumma
 * @DanielZhang
 */
public class SingletonOrder {
    private static SingletonOrder s;
    private static Order order;

    public Order getOrder(){
        return order;
    }

    public void setOrder(Order o){
        order = o;
    }

    public static synchronized SingletonOrder getInstance(){
        if(s == null){
            s = new SingletonOrder();
            order = new Order();
        }
        return s;
    }
}
