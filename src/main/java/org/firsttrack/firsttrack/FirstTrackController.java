package org.firsttrack.firsttrack;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FirstTrackController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}