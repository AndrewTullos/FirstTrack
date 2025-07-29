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
    @FXML private TextArea factsOfLossArea;
    @FXML private TextField vendorName;
    @FXML private TextField advised;
    @FXML private TextField subrogation;
    @FXML private TextField mortgagee;
//    @FXML private RadioButton paymentPreference;
    @FXML private RadioButton checkRadio;
    @FXML private RadioButton eftRadio;
    @FXML private RadioButton otherRadio;
    @FXML private TextField otherReasonText;
    @FXML private Label coverageAdvisedText;
    @FXML private RadioButton textYes;
    @FXML private RadioButton textNo;
    @FXML private CheckBox collisionCheck;
    @FXML private TextField collisionDeductibleField;
    @FXML private CheckBox comprehensiveCheck;
    @FXML private TextField comprehensiveDeductibleField;
    @FXML private CheckBox rrCheck;
    @FXML private CheckBox teCheck;
    @FXML private CheckBox drpCheck;
    @FXML private CheckBox driveInCheck;
    @FXML private CheckBox photoCheck;
    @FXML private CheckBox appraiserCheck;
    @FXML private CheckBox tleCheck;
    @FXML private CheckBox socCheck;
    @FXML private CheckBox rentalCheck;
    @FXML private CheckBox noServicesCheck;
    @FXML private TextField noServicesReason;
    @FXML private RadioButton acYes;
    @FXML private RadioButton acNo;
    @FXML private RadioButton acNa;
    @FXML private TextField acNaReason;
    @FXML private TextArea serviceExpectationsArea;
    @FXML private TextArea nextStepsArea;
    @FXML private TextArea callerAdvisedArea;

    @FXML
    public void initialize() {
//         Disable text fields unless corresponding radio buttons are selected
        otherContactText.disableProperty().bind(otherContactRadio.selectedProperty().not());
//        otherReasonText.disableProperty().bind(otherRadio.selectedProperty().not());
//        collisionDeductibleField.disableProperty().bind(collisionCheck.selectedProperty().not());
//        comprehensiveDeductibleField.disableProperty().bind(comprehensiveCheck.selectedProperty().not());
//        noServicesReason.disableProperty().bind(noServicesCheck.selectedProperty().not());
//        acNaReason.disableProperty().bind(acNa.selectedProperty().not());
//
//        collisionCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
//        comprehensiveCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
//        rrCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
//        teCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
//        drpCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
//        driveInCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
//        photoCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
//        appraiserCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
//        tleCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
//        socCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
//        rentalCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
//        noServicesCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
//        noServicesReason.textProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
    }

    private void updateServiceExpectationsSummary() {
        StringBuilder summary = new StringBuilder();

        if (collisionCheck.isSelected()) {
            String collisionDeductible = collisionDeductibleField.getText().trim();
            summary.append("• Collision - deductible: ").append(collisionDeductible.isEmpty() ? "N/A" : collisionDeductible).append("\n");
        }
        if (comprehensiveCheck.isSelected()) {
            String comprehensiveDeductible = comprehensiveDeductibleField.getText().trim();
            summary.append("• Comprehensive - deductible: ").append(comprehensiveDeductible.isEmpty() ? "N/A" : comprehensiveDeductible).append("\n");
        }
        if (rrCheck.isSelected()) summary.append("• RR - Roadside Assistance available.\n");
        if (teCheck.isSelected()) summary.append("• TE - Towing and Emergency services available.\n");
        if (drpCheck.isSelected()) summary.append("• DRP - CTC within 1 business day; set up inspection and repair.\n");
        if (driveInCheck.isSelected()) summary.append("• Drive In - Confirm appointment; 30-min inspection and estimate.\n");
        if (photoCheck.isSelected()) summary.append("• Photo - Upload photos via text link for appraiser review.\n");
        if (appraiserCheck.isSelected()) summary.append("• Appraiser - May be virtual; estimate provided after inspection.\n");
        if (tleCheck.isSelected()) summary.append("• TLE - Vehicle moved for appraisal; allow 7–10 days.\n");
        if (socCheck.isSelected()) summary.append("• SOC - Shop follows USAA estimate; no work before estimate.\n");
        if (rentalCheck.isSelected()) summary.append("• Rental - Enterprise will contact; deposit may be required.\n");
        if (noServicesCheck.isSelected()) {
            summary.append("• No services set");
            String reason = noServicesReason.getText().trim();
            if (!reason.isEmpty()) {
                summary.append(" (").append(reason).append(")");
            }
            summary.append(".\n");
        }

        serviceExpectationsArea.setText(summary.toString());
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

        note.append("Subrogation: ").append(subrogation.getText().trim()).append("\n");
        note.append("\n");

        note.append("Who is the current Mortgagee: ").append(mortgagee.getText().trim()).append("\n");
        note.append("\n");

        note.append("Reason of use at time of loss/incident: ");
        if (checkRadio.isSelected()) {
            note.append("Check");
        } else if (eftRadio.isSelected()) {
            note.append("EFT");
        } else if (otherRadio.isSelected()) {
            note.append(otherReasonText.getText().trim());
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
        checkRadio.setSelected(false);
        eftRadio.setSelected(false);
        otherRadio.setSelected(false);
        otherReasonText.clear();
        textYes.setSelected(false);
        textNo.setSelected(false);
        collisionCheck.setSelected(false);
        comprehensiveCheck.setSelected(false);
        collisionDeductibleField.clear();
        comprehensiveDeductibleField.clear();
        rrCheck.setSelected(false);
        teCheck.setSelected(false);
        drpCheck.setSelected(false);
        driveInCheck.setSelected(false);
        photoCheck.setSelected(false);
        appraiserCheck.setSelected(false);
        tleCheck.setSelected(false);
        socCheck.setSelected(false);
        rentalCheck.setSelected(false);
        noServicesCheck.setSelected(false);
        noServicesReason.clear();
        acYes.setSelected(false);
        acNo.setSelected(false);
        acNa.setSelected(false);
        acNaReason.clear();
        nextStepsArea.clear();
        callerAdvisedArea.clear();
    }


}