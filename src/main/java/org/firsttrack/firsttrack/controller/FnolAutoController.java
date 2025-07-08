package org.firsttrack.firsttrack.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FnolAutoController {

    @FXML private TextField spokeWithField;
    @FXML private RadioButton phoneRadio;
    @FXML private RadioButton emailRadio;
    @FXML private RadioButton otherContactRadio;
    @FXML private TextField otherContactText;
    @FXML private TextArea factsOfLossArea;
    @FXML private RadioButton personalRadio;
    @FXML private RadioButton businessRadio;
    @FXML private RadioButton otherRadio;
    @FXML private TextField otherReasonText;
    @FXML private RadioButton textYes;
    @FXML private RadioButton textNo;
    @FXML private CheckBox collisionCheck;
    @FXML private CheckBox comprehensiveCheck;
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
    @FXML private TextArea nextStepsArea;
    @FXML private TextArea callerAdvisedArea;

    @FXML
    public void initialize() {
        // Disable text fields unless corresponding radio buttons are selected
        otherContactText.disableProperty().bind(otherContactRadio.selectedProperty().not());
        otherReasonText.disableProperty().bind(otherRadio.selectedProperty().not());
        noServicesReason.disableProperty().bind(noServicesCheck.selectedProperty().not());
        acNaReason.disableProperty().bind(acNa.selectedProperty().not());
    }

    public String generateFormattedNote() {
        StringBuilder note = new StringBuilder();

        note.append("************************ FNOL AUTO ************************\n\n").append(spokeWithField.getText());

        note.append("Spoke with: ").append(spokeWithField.getText().trim()).append("\n");
        note.append("Preferred method of contact: ");
        if (phoneRadio.isSelected()) {
            note.append("Phone");
        } else if (emailRadio.isSelected()) {
            note.append("Email");
        } else if (otherContactRadio.isSelected()) {
            note.append(otherContactText.getText().trim());
        }
        note.append("\n");

        note.append("Facts of Loss: ").append(factsOfLossArea.getText().trim()).append("\n");

        note.append("Reason of use at time of loss/incident: ");
        if (personalRadio.isSelected()) {
            note.append("Personal");
        } else if (businessRadio.isSelected()) {
            note.append("Business");
        } else if (otherRadio.isSelected()) {
            note.append(otherReasonText.getText().trim());
        }
        note.append("\n");

        note.append("Permission granted to text: ");
        note.append(textYes.isSelected() ? "Yes" : "No").append("\n");

        note.append("System Determined Coverage(s) Advised: ");
        StringBuilder coverages = new StringBuilder();
        if (collisionCheck.isSelected()) coverages.append("Collision - deductible: ");
        if (comprehensiveCheck.isSelected()) coverages.append("Comprehensive - deductible: ");
        if (rrCheck.isSelected()) coverages.append("RR: ");
        if (teCheck.isSelected()) coverages.append("TE: ");
        note.append(coverages.length() > 0 ? coverages.substring(0, coverages.length() - 2) : "None").append("\n");

        note.append("Advised of Service Expectations: ");
        StringBuilder services = new StringBuilder();
        if (drpCheck.isSelected()) services.append("DRP - CTC W/in 1 business day, lifetime warranty, ded. pay to shop, set up inspection and repair.");
        if (driveInCheck.isSelected()) services.append("Drive In - Confirm appointment, 30 min will inspect and provide est to member and USAA; member can repair with drive in or go to SOC; provide estimate to SOC to follow approved repairs and supplemental process. ");
        if (photoCheck.isSelected()) services.append("Photo estimate - Link will be sent via text, access link and upload photos - appraiser will review and create estimate; will be sent to adjuster - adjuster to provide to member; member to provide the estimate to their preferred shop. ");
        if (appraiserCheck.isSelected()) services.append("Appraiser - Contact within 5 business days; may be virtual - not guaranteed an in-person inspection = appraiser will contact member after inspection completed to provide estimate and go over estimate and next steps.");
        if (tleCheck.isSelected()) services.append("TLE - Move vehhicle to inspection station for appraisal, provider will contact to coordinate tow, ensure the vehicle is release from facility (attempt 3-way call) approximately 7-10 days for the inspection to be completed and follow up with the member.");
        if (socCheck.isSelected()) services.append("SOC - Provide USAA est to shop; SOC not to start repairs until the USAA estimate is completed. USAA will pay initial payment to member. Shop to follow directions on estimate for supplements. USAA does not gurantee work from shops outside of network.");
        if (rentalCheck.isSelected()) services.append("Rental - No GMI/T, RTO, follow up with shop to confirm rental being extended. Enterprise will contact to confirm reservation and time needed. Deposit may be required, returned when vehilce returned, inspect for prior damage(\"... take photos, it's what I do\").");
        if (noServicesCheck.isSelected()) {
            services.append("No services set");
            if (!noServicesReason.getText().trim().isEmpty()) {
                services.append(" (").append(noServicesReason.getText().trim()).append(")");
            }
        }
        note.append(services.length() > 0 ? services.substring(0, services.length() - 2) : "None").append("\n");

        note.append("Permission to release information to AC: ");
        if (acYes.isSelected()) {
            note.append("Yes");
        } else if (acNo.isSelected()) {
            note.append("No");
        } else if (acNa.isSelected()) {
            note.append("N/A");
            if (!acNaReason.getText().trim().isEmpty()) {
                note.append(" (").append(acNaReason.getText().trim()).append(")");
            }
        }
        note.append("\n");

        note.append("Advised Caller of Next Steps: ").append(nextStepsArea.getText().trim()).append("\n");
        note.append("Caller Advised: ").append(callerAdvisedArea.getText().trim()).append("\n");

        return note.toString();
    }

    public void resetForm() {
        spokeWithField.clear();
        phoneRadio.setSelected(false);
        emailRadio.setSelected(false);
        otherContactRadio.setSelected(false);
        otherContactText.clear();
        factsOfLossArea.clear();
        personalRadio.setSelected(false);
        businessRadio.setSelected(false);
        otherRadio.setSelected(false);
        otherReasonText.clear();
        textYes.setSelected(false);
        textNo.setSelected(false);
        collisionCheck.setSelected(false);
        comprehensiveCheck.setSelected(false);
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