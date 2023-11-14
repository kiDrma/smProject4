package com.example.smproject4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class SpecialtyPizzasController implements Initializable {
    private final double BLANK_PRICE = 0;
    @FXML
    private ComboBox comboBox = new ComboBox<>();
    @FXML
    private Text pizzaName;
    @FXML
    private ListView toppingsList;
    @FXML
    private RadioButton smallButton;
    @FXML
    private RadioButton mediumButton;
    @FXML
    private RadioButton LargeButton;
    @FXML
    private CheckBox extraCheese;
    @FXML
    private CheckBox extraSauce;
    @FXML
    private TextField total;
    @FXML
    private Button addToOrderButton;
    @FXML
    private ImageView pizzaImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> pizzaOptions = FXCollections.observableArrayList(
                "hi","kill me","work"
        );
        comboBox.setItems(pizzaOptions);

        String str = new DecimalFormat("0.00").format(BLANK_PRICE);
        total.setText("$" + str);
    }
}
