package com.example.smproject4;

public class SingletonStoreOrders {
    private static SingletonStoreOrders s;
    private static StoreOrders storeOrders;


    public static synchronized SingletonStoreOrders getInstance(){
        if(s == null){
            s = new SingletonStoreOrders();
            storeOrders = new StoreOrders();
        }
        return s;
    }

    public StoreOrders getStoreOrders(){
        return storeOrders;
    }

    public void addOrder(Order order){
        storeOrders.addOrder(order);
    }
}
