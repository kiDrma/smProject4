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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/**
 * Define the data type StoreOrders.
 * @KimberlyDonnarumma
 * @DanielZhang
 */
public class StoreOrders {
    private static int orderNumber = 1;
    private ArrayList<Order> storeOrders;
    private ArrayList<Integer> orderNumbers;

    public StoreOrders() {
        storeOrders = new ArrayList<>();
        orderNumbers = new ArrayList<>();
    }

    public void addOrder(Order order) {
        storeOrders.add(order);
        orderNumbers.add(orderNumber);
        orderNumber++;
    }

    public void removeOrder(Order order, int orderNumber) {
        storeOrders.remove(order);
        orderNumbers.remove((Integer) orderNumber);
    }

    public ArrayList<Integer> getOrderNumbers() {
        return orderNumbers;
    }

    public ArrayList<Order> getOrders() {
        return storeOrders;
    }

    private static int exportedFilesCount = 0;

    /**
    @FXML
    public void exportOld() {
        try {

            File file = new File("StoreOrders" + exportedFilesCount + ".txt");
            FileWriter fileWriter = new FileWriter(file);
            for (int i = 0; i < getOrders().size(); i++) {
                try {
                    fileWriter.write("Order #" + getOrderNumbers().get(i) + "\n");
                    fileWriter.write(getOrders().get(i).displayOrder());
                    String theTotal = new DecimalFormat("0.00").format(getOrders().get(i).getOrderTotal());
                    fileWriter.write("Total: $" + theTotal + "\n\n");
                } catch (IOException e) {
                    System.out.println("test");
                    return;
                }
                exportedFilesCount++;
            }
            fileWriter.close();
        } catch (IOException e) {
            return;
        }
    }
     */

    /**
     * Exports the store orders to a user-selected text file.
     */
    @FXML
    public void export() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Export Store Orders");
        Stage temp = new Stage();
        File selectedFile = fileChooser.showSaveDialog(temp);
        if (selectedFile != null) {
            try {
                FileWriter fileWriter = new FileWriter(selectedFile);
                for (int i = 0; i < getOrders().size(); i++) {
                    try {
                        fileWriter.write("Order #" + getOrderNumbers().get(i) + "\n");
                        fileWriter.write(getOrders().get(i).displayOrder());
                        String theTotal = new DecimalFormat("0.00").format(getOrders().get(i).getOrderTotal());
                        fileWriter.write("Total: $" + theTotal + "\n\n");
                    } catch (IOException e) {
                        System.out.println("test");
                        return;
                    }
                    exportedFilesCount++;
                }
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error saving file!");
            }
        }
        temp.close();
    }
}

