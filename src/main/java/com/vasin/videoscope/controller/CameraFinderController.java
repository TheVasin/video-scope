package com.vasin.videoscope.controller;

import com.github.sarxos.webcam.Webcam;
import com.vasin.videoscope.camera.CameraList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class CameraFinderController {
    private Webcam selectedCamera;

    @FXML
    private ListView<Webcam> cameraList;

    @FXML
    private Button selectButton;

    public CameraFinderController() {
    }

    @FXML
    private void initialize() {
        cameraList.setItems(CameraList.getList());
    }

    @FXML
    private void handleRefreshButton() {
        CameraList.findCameras();
    }

    @FXML
    private void handleCameraListSelection() {
        this.selectedCamera = cameraList.getSelectionModel().getSelectedItem();
        if (null != this.selectedCamera) {
            selectButton.setDisable(false);
        }
    }

    @FXML
    private void handleSelectButton() {
        CameraList.setDefaultCamera(selectedCamera);
        Stage stage = (Stage) selectButton.getScene().getWindow();
        stage.close();
    }
}
