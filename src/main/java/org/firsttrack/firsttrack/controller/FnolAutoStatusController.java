package org.firsttrack.firsttrack.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class FnolAutoStatusController implements NoteFormController {

    @FXML private ComboBox<String> fnolStatusComboBox;

    @FXML private VBox defaultFields;
    @FXML private VBox attorneyFields;
    @FXML private VBox medicalFields;

//    Default VBOX
    @FXML private TextField spokeWithField;
    @FXML private TextArea generalNote;

//    Attorney VBOX
    @FXML private TextField attorneySpokeWithField;
    @FXML private TextField attorneyFirmNameField;
    @FXML private TextField attorneyContactField;
    @FXML private TextField attorneyAddressField;
    @FXML private TextField attorneyFaxNumberField;
    @FXML private TextField attorneyPhoneNumberField;
    @FXML private TextField attorneyEmailField;
    @FXML private TextField attorneyTaxIdField;
    @FXML private TextArea attorneyGeneralNoteField;

//    Medical Provider VBOX
    @FXML private TextField medicalCallerField;
    @FXML private TextField medicalReasonField;
    @FXML private TextField medicalInformationField;
    @FXML private TextField medicalProviderAdjusterField;
    @FXML private TextField medicalProviderActionsTakenField;
    @FXML private TextField medicalProviderNextStepsField;
    @FXML private TextArea medicalProviderGeneralNoteField;

    @FXML
    public void initialize() {
        fnolStatusComboBox.setItems(FXCollections.observableArrayList(
                "Claimant", "Attorney", "Medical Provider", "Adverse Carrier", "Repair Facility"
        ));
        fnolStatusComboBox.setValue("Claimant"); // default

        handleComboBoxSelection(null);
    }

    @FXML
    public void handleComboBoxSelection(ActionEvent event) {
        String selected = fnolStatusComboBox.getValue();

        // Hide all
        defaultFields.setVisible(false); defaultFields.setManaged(false);
        attorneyFields.setVisible(false); attorneyFields.setManaged(false);
        medicalFields.setVisible(false); medicalFields.setManaged(false);

        switch (selected) {
            case "Attorney":
                attorneyFields.setVisible(true); attorneyFields.setManaged(true);
                break;
            case "Medical Provider":
                medicalFields.setVisible(true); medicalFields.setManaged(true);
                break;
            default:
                defaultFields.setVisible(true); defaultFields.setManaged(true);
                break;
        }
    }

    public String generateFormattedNote() {
        StringBuilder note = new StringBuilder();

        note.append("************************ FNOL AUTO STATUS ************************\n\n");
        String fnolType = fnolStatusComboBox.getValue();

        if ("Attorney".equals(fnolType)) {
            note.append("Spoke With: ").append(attorneySpokeWithField.getText().trim()).append("\n");
            note.append("\n");

            note.append("Firm Name: ").append(attorneyFirmNameField.getText().trim()).append("\n");
            note.append("\n");

            note.append("Contact Person: ").append(attorneyContactField.getText().trim()).append("\n");
            note.append("\n");

            note.append("Address: ").append(attorneyAddressField.getText().trim()).append("\n");
            note.append("\n");

            note.append("Fax Number: ").append(attorneyFaxNumberField.getText().trim()).append("\n");
            note.append("\n");

            note.append("Telephone Number: ").append(attorneyPhoneNumberField.getText().trim()).append("\n");
            note.append("\n");

            note.append("Email: ").append(attorneyEmailField.getText().trim()).append("\n");
            note.append("\n");

            note.append("Tax ID: ").append(attorneyTaxIdField.getText().trim()).append("\n");
            note.append("\n");

            note.append("Notes: ").append(attorneyGeneralNoteField.getText().trim()).append("\n");
            note.append("\n");


        } else if ("Medical Provider".equals(fnolType)) {
            note.append("Spoke With: ").append(medicalCallerField.getText().trim()).append("\n");
            note.append("\n");

            note.append("Firm Name: ").append(medicalReasonField.getText().trim()).append("\n");
            note.append("\n");

            note.append("Contact Person: ").append(medicalInformationField.getText().trim()).append("\n");
            note.append("\n");

            note.append("Address: ").append(medicalProviderAdjusterField.getText().trim()).append("\n");
            note.append("\n");

            note.append("Fax Number: ").append(medicalProviderActionsTakenField.getText().trim()).append("\n");
            note.append("\n");

            note.append("Telephone Number: ").append(medicalProviderNextStepsField.getText().trim()).append("\n");
            note.append("\n");


            note.append("Notes: ").append(medicalProviderGeneralNoteField.getText().trim()).append("\n");
            note.append("\n");

        } else {
            note.append("************************ FNOL AUTO STATUS ************************\n\n");
            note.append("\n");

            note.append("Spoke with: ").append(spokeWithField.getText().trim()).append("\n");
            note.append("\n");

            note.append("Notes: ").append(generalNote.getText().trim()).append("\n");
        }

        return note.toString();
    }

    @Override
    public void resetForm() {
        generalNote.clear();
        spokeWithField.clear();
//        ATTORNEY CLEAR
        attorneySpokeWithField.clear();
        attorneyFirmNameField.clear();
        attorneyContactField.clear();
        attorneyAddressField.clear();
        attorneyFaxNumberField.clear();
        attorneyPhoneNumberField.clear();
        attorneyEmailField.clear();
        attorneyTaxIdField.clear();
        attorneyGeneralNoteField.clear();

//        MEDICAL CLEAR
        medicalCallerField.clear();
        medicalReasonField.clear();
        medicalInformationField.clear();
        medicalProviderAdjusterField.clear();
        medicalProviderActionsTakenField.clear();
        medicalProviderNextStepsField.clear();
        medicalProviderGeneralNoteField.clear();
    }
}