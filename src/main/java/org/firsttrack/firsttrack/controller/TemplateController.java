package org.firsttrack.firsttrack.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class TemplateController {

    @FXML
    private ListView<String> sidebarList;

    @FXML
    private Button resetButton;

    @FXML
    private Button copyButton;

    @FXML
    private CheckBox noServicesSetCheck;

    @FXML
    private TextField spokeWithField;
    @FXML
    private TextField preferredContactField;
    @FXML
    private TextArea factsOfLossArea;
    @FXML
    private TextArea nextStepsArea;
    @FXML
    private TextArea callerAdvisedArea;

    // Add more @FXML fields as needed for the rest of the form

    @FXML
    public void initialize() {
        sidebarList.getItems().addAll("Tab 1", "Tab 2", "Tab 3");
        sidebarList.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            // Logic to load or switch form sections
        });

        copyButton.setOnAction(e -> copyToClipboard());
        resetButton.setOnAction(e -> resetForm());
    }

    private void copyToClipboard() {
        StringBuilder builder = new StringBuilder();
        builder.append("Spoke With: ").append(spokeWithField.getText()).append("\n");
        builder.append("Preferred Contact: ").append(preferredContactField.getText()).append("\n");
        builder.append("Facts of Loss: ").append(factsOfLossArea.getText()).append("\n");
        builder.append("Next Steps: ").append(nextStepsArea.getText()).append("\n");
        builder.append("Caller Advised: ").append(callerAdvisedArea.getText()).append("\n");
        // Add more form values as needed

        ClipboardContent content = new ClipboardContent();
        content.putString(builder.toString());
        Clipboard.getSystemClipboard().setContent(content);
    }

    private void resetForm() {
        spokeWithField.clear();
        preferredContactField.clear();
        factsOfLossArea.clear();
        nextStepsArea.clear();
        callerAdvisedArea.clear();
    }
}
