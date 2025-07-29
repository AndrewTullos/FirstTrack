package org.firsttrack.firsttrack.controller;

import javafx.scene.control.Alert;
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



public class OnTrackController {

    @FXML private BorderPane mainPane;
    @FXML private ImageView logo;
    @FXML private Button resetButton;
    @FXML private Button copyButton;
    @FXML private Button fnolAutoButton;
    @FXML private Button fnolPropertyButton;
    @FXML private ScrollPane contentScrollPane;

    private NoteFormController currentFormController;

    @FXML
    private void initialize() {
        Image image = new Image(getClass().getResource("/org/firsttrack/firsttrack/usaa-logo.png").toExternalForm());
        logo.setImage(image);
        loadStart();
    }

    @FXML
    private void handleCopy() {
        if (currentFormController != null) {
            String note = currentFormController.generateFormattedNote();
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
        if (currentFormController != null) {
            currentFormController.resetForm();
            showAlert("Success", "Form has been reset.");
        } else {
            showAlert("Error", "No form is loaded to reset.");
        }
    }


//    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to reset?", ButtonType.YES, ButtonType.NO);
//        confirm.showAndWait().ifPresent(response -> {
//        if (response == ButtonType.YES) fnolAutoController.resetForm();
//    });


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @FXML
    protected void loadStart() {
//        System.out.println("FNOL AUTO button clicked");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/firsttrack/firsttrack/fxml/loading.fxml"));
            contentScrollPane.setContent(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load fnol_auto.fxml: " + e.getMessage());
        }
    }

    @FXML
    protected void loadFnolAuto() {
//        System.out.println("FNOL AUTO button clicked");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/firsttrack/firsttrack/fxml/fnol_auto.fxml"));
            contentScrollPane.setContent(loader.load());
            currentFormController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load fnol_auto.fxml: " + e.getMessage());
        }
    }

    @FXML
    protected void loadFnolAutoStatus() {
//        System.out.println("FNOL AUTO button clicked");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/firsttrack/firsttrack/fxml/fnol_auto_status.fxml"));
            contentScrollPane.setContent(loader.load());
            currentFormController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load fnol_auto.fxml: " + e.getMessage());
        }
    }

    @FXML
    protected void loadFnolProperty(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/firsttrack/firsttrack/fxml/fnol_property.fxml"));
            contentScrollPane.setContent(loader.load());
            currentFormController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}