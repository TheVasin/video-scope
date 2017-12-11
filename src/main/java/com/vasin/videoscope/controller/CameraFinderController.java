package com.vasin.videoscope.controller;

import com.github.sarxos.webcam.Webcam;
import com.vasin.videoscope.VideoScope;
import com.vasin.videoscope.camera.CameraList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class CameraFinderController {
    @FXML
    private ListView<Webcam> cameraList;

    @FXML
    private Button selectButton;

    @FXML
    private Button refreshButton;

    private VideoScope application;

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
}
