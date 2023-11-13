package com.example.smproject4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SpecialtyPizzasController implements Initializable {
    @FXML
    private ComboBox comboBox = new ComboBox<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> pizzaOptions = FXCollections.observableArrayList(
                "hi","kill me","work"
        );
        comboBox.setItems(pizzaOptions);
    }
}
