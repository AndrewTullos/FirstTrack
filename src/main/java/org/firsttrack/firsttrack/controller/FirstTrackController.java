package org.firsttrack.firsttrack.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class FirstTrackController {
//    @FXML
//    private Label welcomeText;

//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }

    @FXML private BorderPane mainPane;
    @FXML private ImageView logo;
    @FXML private Button resetButton;
    @FXML private Button copyButton;
    @FXML private Button fnolAutoButton;
    @FXML private Button fnolPropertyButton;
    @FXML private ScrollPane contentScrollPane;

    private FnolAutoController fnolAutoController;

    @FXML
    private void initialize() {
        Image image = new Image(getClass().getResource("/org/firsttrack/firsttrack/usaa-logo.png").toExternalForm());
        logo.setImage(image);
    }

    @FXML
    private void handleCopy() {
        if (fnolAutoController != null) {
            String note = fnolAutoController.generateFormattedNote();
            ClipboardContent content = new ClipboardContent();
            content.putString(note);
            Clipboard.getSystemClipboard().setContent(content);
            showAlert("Success", "Note copied to clipboard!");
        } else {
            showAlert("Error", "No form is loaded to copy.");
        }
    }

    @FXML
    private void handleReset() {
        if (fnolAutoController != null) {
            fnolAutoController.resetForm();
            showAlert("Success", "Form has been reset.");
        } else {
            showAlert("Error", "No form is loaded to reset.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    protected void loadFnolAuto() {
        System.out.println("FNOL AUTO button clicked");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/firsttrack/firsttrack/fxml/fnol_auto.fxml"));
            contentScrollPane.setContent(loader.load());
            fnolAutoController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load fnol_auto.fxml: " + e.getMessage());
        }
    }

    @FXML
    protected void loadFnolProperty(ActionEvent event) {
        System.out.println("FNOL PROPERTY button clicked");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/firsttrack/firsttrack/fxml/fnol_property.fxml"));
            contentScrollPane.setContent(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load fnol_auto.fxml: " + e.getMessage());
        }
    }
}