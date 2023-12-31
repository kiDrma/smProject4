package com.example.smproject4;
/**
 * Define singleton for global StoreOrders variable.
 * @KimberlyDonnarumma
 * @DanielZhang
 */
public class SingletonStoreOrders {
    private static SingletonStoreOrders s;
    private static StoreOrders storeOrders;

    /**
     * Returns the global storeOrders object, if there isn't one, makes one.
     * @return store orders object.
     */
    public static synchronized SingletonStoreOrders getInstance(){
        if(s == null){
            s = new SingletonStoreOrders();
            storeOrders = new StoreOrders();
        }
        return s;
    }

    /**
     * Returns the store orders object.
     * @return store orders.
     */
    public StoreOrders getStoreOrders(){
        return storeOrders;
    }

    /**
     * Adds to the global store orders object.
     * @param order
     */
    public void addOrder(Order order){
        storeOrders.addOrder(order);
    }

    /**
     * Resets global store order.
     */
    public void resetStoreOrders(){
        storeOrders = new StoreOrders();
    }
}
