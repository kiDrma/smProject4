package com.example.smproject4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Application to run program.
 * @KimberlyDonnarumma
 * @DanielZhang
 */
public class MainMenuApplication extends Application {
    /**
     * Starts the program by setting the stage.
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("MainMenuView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 550, 450);
        stage.setTitle("RU Pizza");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Launches the program.
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}