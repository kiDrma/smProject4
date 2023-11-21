package com.example.smproject4;

import javafx.fxml.FXML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class StoreOrders {
    private static int orderNumber = 1;
    private ArrayList<Order> storeOrders;
    private ArrayList<Integer> orderNumbers;

    public StoreOrders(){
        storeOrders = new ArrayList<>();
        orderNumbers = new ArrayList<>();
    }

    public void addOrder(Order order){
        storeOrders.add(order);
        orderNumbers.add(orderNumber);
        orderNumber++;
    }

    public void removeOrder(Order order, int orderNumber){
        storeOrders.remove(order);
        orderNumbers.remove((Integer)orderNumber);
    }

    public ArrayList<Integer> getOrderNumbers(){
        return orderNumbers;
    }

    public ArrayList<Order> getOrders(){
        return storeOrders;
    }
    private static int exportedFilesCount = 0;
    @FXML
    public void export(){
        try{
            File file = new File("StoreOrders" + exportedFilesCount + ".txt");
            FileWriter fileWriter = new FileWriter(file);
            for(int i = 0; i < getOrders().size(); i++){
                try{
                    fileWriter.write("Order #" + getOrderNumbers().get(i) + "\n");
                    fileWriter.write(getOrders().get(i).displayOrder());
                    String theTotal = new DecimalFormat("0.00").format(getOrders().get(i).getOrderTotal());
                    fileWriter.write("Total: $" + theTotal + "\n\n");
                }
                catch(IOException e){
                    System.out.println("test");
                    return;
                }
                exportedFilesCount++;
            }
            fileWriter.close();
        }
        catch(IOException e){
            return;
        }
    }
}
