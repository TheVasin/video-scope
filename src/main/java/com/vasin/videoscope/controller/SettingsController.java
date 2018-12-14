package com.vasin.videoscope.controller;

import com.github.sarxos.webcam.Webcam;
import com.vasin.videoscope.camera.CameraList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.awt.*;

public class SettingsController {
    private Webcam selectedCamera;

    @FXML
    private ChoiceBox<Webcam> cameraList;

    @FXML
    private ChoiceBox<Dimension> resolutionList;

    @FXML
    private void initialize() {
        cameraList.setItems(CameraList.getList());
    }

    @FXML
    public void onAction() {
        Webcam selectedCamera = cameraList.getSelectionModel().getSelectedItem();
        if (null != selectedCamera) {
            this.selectedCamera = selectedCamera;
            ObservableList<Dimension> dList = FXCollections.observableArrayList();
            dList.addAll(this.selectedCamera.getViewSizes());
            System.out.println(dList.size());
            resolutionList.setItems(dList);
            CameraList.setDefaultCamera(selectedCamera);
        }
    }
}
