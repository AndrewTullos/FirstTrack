package org.firsttrack.firsttrack.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FnolPropertyController implements NoteFormController {

    @FXML private TextField spokeWithField;
    @FXML private RadioButton phoneRadio;
    @FXML private RadioButton emailRadio;
    @FXML private RadioButton otherContactRadio;
    @FXML private TextField otherContactText;
    @FXML private RadioButton yesSubro;
    @FXML private RadioButton noSubro;
    @FXML private RadioButton otherSubro;
    @FXML private TextField otherSubroText;
    @FXML private TextArea factsOfLossArea;
    @FXML private TextField vendorName;
    @FXML private TextField advised;
    @FXML private TextField subrogation;
    @FXML private TextField mortgagee;
    @FXML private RadioButton checkRadio;
    @FXML private RadioButton eftRadio;



    @FXML
    public void initialize() {
        otherContactText.disableProperty().bind(otherContactRadio.selectedProperty().not());
    }


    @Override
    public String generateFormattedNote() {
        StringBuilder note = new StringBuilder();

        note.append("************************ FNOL PROPERTY ************************\n\n");

        note.append("Spoke with: ").append(spokeWithField.getText().trim()).append("\n");
        note.append("\n");

        note.append("Preferred method of contact: ");
        if (phoneRadio.isSelected()) {
            note.append("Phone");
        } else if (emailRadio.isSelected()) {
            note.append("Email");
        } else if (otherContactRadio.isSelected()) {
            note.append(otherContactText.getText().trim());
        }
        note.append("\n");
        note.append("\n");


        note.append("Facts of Loss: ").append(factsOfLossArea.getText().trim()).append("\n");
        note.append("\n");

        note.append("Vendor Name: ").append(vendorName.getText().trim()).append("\n");
        note.append("\n");


        note.append("Advised: ").append(advised.getText().trim()).append("\n");
        note.append("\n");


        note.append("Subrogation: ");
        if (yesSubro.isSelected()) {
            note.append("Yes");
        } else if (noSubro.isSelected()) {
            note.append("No");
        } else if (otherSubro.isSelected()) {
            note.append(otherSubroText.getText().trim());
        }
        note.append("\n");
        note.append("\n");
        
        

        note.append("Who is the current Mortgagee: ").append(mortgagee.getText().trim()).append("\n");
        note.append("\n");

        note.append("Payment Preference: ");
        if (checkRadio.isSelected()) {
            note.append("Check");
        } else if (eftRadio.isSelected()) {
            note.append("EFT");
        }
        note.append("\n");
        note.append("\n");


        return note.toString();
    }


    @Override
    public void resetForm() {
        spokeWithField.clear();
        phoneRadio.setSelected(false);
        emailRadio.setSelected(false);
        otherContactRadio.setSelected(false);
        otherContactText.clear();
        factsOfLossArea.clear();
        yesSubro.setSelected(false);
        noSubro.setSelected(false);
        otherSubro.setSelected(false);
        otherSubroText.clear();
        vendorName.clear();
        advised.clear();
        mortgagee.clear();
        checkRadio.setSelected(false);
        eftRadio.setSelected(false);
    }

}