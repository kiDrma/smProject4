package com.example.smproject4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
/**
 * Controller for MainMenu screen.
 * @KimberlyDonnarumma
 * @DanielZhang
 */
public class MainMenuController {
    /**
     * Opens specialty pizza screen.
     * @throws IOException
     */
    @FXML
    protected void onOrderSpecialityClick() throws IOException{
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SpecialtyPizzasView.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Specialty Pizzas");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Opens build your own screen.
     * @throws IOException
     */
    @FXML
    protected void onBuildYourOwnClick() throws IOException{
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BuildYourOwnView.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Build Your Own Pizza");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Opens current order screen.
     * @throws IOException
     */
    @FXML
    protected void onCurrentOrderClick() throws IOException{
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CurrentOrderView.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Current Order");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Opens store orders screen.
     * @throws IOException
     */
    @FXML
    protected void onStoreOrdersClick() throws IOException{
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreOrdersView.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Store Orders");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}