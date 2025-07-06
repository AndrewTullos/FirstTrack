package org.firsttrack.firsttrack.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FnolAutoController {

    @FXML
    private TextField spokeWithField;

    @FXML
    private TextField preferredContactField;

    @FXML
    private TextArea factsOfLossArea;

    @FXML
    private ToggleGroup reasonGroup;

    @FXML
    private RadioButton personalRadio;

    @FXML
    private RadioButton businessRadio;

    @FXML
    private RadioButton otherRadio;

    @FXML
    private TextField otherReasonText;

    @FXML
    private ToggleGroup textPermissionGroup;

    @FXML
    private RadioButton textYes;

    @FXML
    private RadioButton textNo;

    @FXML
    private CheckBox collisionCheck;

    @FXML
    private CheckBox comprehensiveCheck;

    @FXML
    private CheckBox rrCheck;

    @FXML
    private CheckBox teCheck;

    @FXML
    private CheckBox drpCheck;

    @FXML
    private CheckBox driveInCheck;

    @FXML
    private CheckBox photoCheck;

    @FXML
    private CheckBox appraiserCheck;

    @FXML
    private CheckBox tleCheck;

    @FXML
    private CheckBox socCheck;

    @FXML
    private CheckBox rentalCheck;

    @FXML
    private CheckBox noServicesCheck;

    @FXML
    private TextField noServicesReason;

    @FXML
    private ToggleGroup acGroup;

    @FXML
    private RadioButton acYes;

    @FXML
    private RadioButton acNo;

    @FXML
    private RadioButton acNa;

    @FXML
    private TextField acNaReason;

    @FXML
    private TextArea nextStepsArea;

    @FXML
    private TextArea callerAdvisedArea;
}