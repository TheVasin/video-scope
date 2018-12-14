package com.vasin.videoscope.controller;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.vasin.videoscope.camera.CameraList;
import com.vasin.videoscope.camera.CameraStream;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class MainController {
    @FXML
    private GridPane cameraGrid;

    @FXML
    private ImageView cameraView;

    private CameraStream stream;

    @FXML
    private void initialize() {
        stream = new CameraStream();
    }

    @FXML
    private void startStreamHandler() {
        startStream();
    }

    private void startStream() {
        if (stream.isRunning()) {
            return;
        }
        Webcam camera = CameraList.getDefaultCamera();
        camera.setViewSize(WebcamResolution.VGA.getSize());
        stream.startCameraStream(camera, cameraView);
        cameraView.getScene().getWindow().setOnCloseRequest(event -> stream.stopStream());
    }
}
