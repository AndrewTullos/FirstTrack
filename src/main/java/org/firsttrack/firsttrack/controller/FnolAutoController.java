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
        // Disable text fields unless corresponding radio buttons are selected
        otherContactText.disableProperty().bind(otherContactRadio.selectedProperty().not());
        otherReasonText.disableProperty().bind(otherRadio.selectedProperty().not());
        collisionDeductibleField.disableProperty().bind(collisionCheck.selectedProperty().not());
        comprehensiveDeductibleField.disableProperty().bind(comprehensiveCheck.selectedProperty().not());
        noServicesReason.disableProperty().bind(noServicesCheck.selectedProperty().not());
        acNaReason.disableProperty().bind(acNa.selectedProperty().not());

        collisionCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
        comprehensiveCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
        rrCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
        teCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
        drpCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
        driveInCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
        photoCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
        appraiserCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
        tleCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
        socCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
        rentalCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
        noServicesCheck.selectedProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
        noServicesReason.textProperty().addListener((obs, oldV, newV) -> updateServiceExpectationsSummary());
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

    public String generateFormattedNote() {
        StringBuilder note = new StringBuilder();

        note.append("************************ FNOL AUTO ************************\n\n");

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

        note.append("Reason of use at time of loss/incident: ");
        if (personalRadio.isSelected()) {
            note.append("Personal");
        } else if (businessRadio.isSelected()) {
            note.append("Business");
        } else if (otherRadio.isSelected()) {
            note.append(otherReasonText.getText().trim());
        }
        note.append("\n");
        note.append("\n");


        note.append("Permission granted to text: ");
        note.append(textYes.isSelected() ? "Yes" : "No").append("\n");
        note.append("\n");


        note.append("System Determined Coverage(s) Advised: ");
        StringBuilder coverages = new StringBuilder();
        // To do add logic to give dedcitble boxes
        if (collisionCheck.isSelected()) {
            String deductible = collisionDeductibleField.getText().trim();
            coverages.append("Collision - deductible: ")
                    .append(deductible.isEmpty() ? "N/A" : deductible)
                    .append("; ");
        }
        if (comprehensiveCheck.isSelected()) {
            String deductible = comprehensiveDeductibleField.getText().trim();
            coverages.append("Comprehensive - deductible: ")
                    .append(deductible.isEmpty() ? "N/A" : deductible)
                    .append("; ");
        };
        if (rrCheck.isSelected()) coverages.append("RR: ");
        if (teCheck.isSelected()) coverages.append("TE: ");

        note.append(coverages.length() > 0 ? coverages.substring(0, coverages.length() - 2) : "None").append("\n");
        note.append("\n");


        note.append("Advised of Service Expectations: \n");
        StringBuilder services = new StringBuilder();
        if (drpCheck.isSelected()) services.append("- DRP - CTC W/in 1 business day, lifetime warranty, ded. pay to shop, set up inspection and repair.\n");
        if (driveInCheck.isSelected()) services.append("- Drive In - Confirm appointment, 30 min will inspect and provide est to member and USAA; member can repair with drive in or go to SOC; provide estimate to SOC to follow approved repairs and supplemental process. \n");
        if (photoCheck.isSelected()) services.append("- Photo estimate - Link will be sent via text, access link and upload photos - appraiser will review and create estimate; will be sent to adjuster - adjuster to provide to member; member to provide the estimate to their preferred shop. \n");
        if (appraiserCheck.isSelected()) services.append("- Appraiser - Contact within 5 business days; may be virtual - not guaranteed an in-person inspection; appraiser will contact member after inspection completed to provide an estimate and go over estimate and next steps. \n");
        if (tleCheck.isSelected()) services.append("- TLE - Move vehicle to inspection station for appraisal, provider will contact to coordinate tow, ensure the vehicle is release from facility (attempt 3-way call) approximately 7-10 days for the inspection to be completed and follow up with the member. \n");
        if (socCheck.isSelected()) services.append("- SOC - Provide USAA est to shop; SOC not to start repairs until the USAA estimate is completed. USAA will pay initial payment to members. Shop to follow directions on estimates for supplements. USAA does not guarantee work from shops outside of the network. \n");
        if (rentalCheck.isSelected()) services.append("- Rental - No GMI/T, RTO, follow up with the shop to confirm rental being extended. Enterprise will contact to confirm reservation and time needed. Deposit may be required, returned when vehicle returns, inspected for prior damage(\"... take photos, it's what I do\").\n");
        if (noServicesCheck.isSelected()) {
            services.append("- No services set. \n");
            if (!noServicesReason.getText().trim().isEmpty()) {
                services.append(" (").append(noServicesReason.getText().trim()).append(")");
            }
        }
        note.append(services.length() > 0 ? services.substring(0, services.length() - 2) : "None").append("\n");
        note.append("\n");


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
        note.append("\n");


        note.append("Advised Caller of Next Steps: ").append(nextStepsArea.getText().trim()).append("\n");
        note.append("\n");

        note.append("Caller Advised: ").append(callerAdvisedArea.getText().trim()).append("\n");
        note.append("\n");

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