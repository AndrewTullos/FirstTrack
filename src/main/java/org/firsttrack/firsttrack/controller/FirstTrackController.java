package org.firsttrack.firsttrack.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FirstTrackController {
    @FXML
    private Label welcomeText;

    @FXML
    private ImageView logo;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void initialize() {
        Image image = new Image(getClass().getResource("/org/firsttrack/firsttrack/usaa-logo.png").toExternalForm());
        logo.setImage(image);
    }
}