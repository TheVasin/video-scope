package com.vasin.videoscope.view;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CameraFinderWindow {
    private Stage stage;

    public CameraFinderWindow(String title) {
        this.stage = new Stage();
        this.stage.setTitle(title);
        stage.initModality(Modality.APPLICATION_MODAL);
        BorderPane rootPane = SharedTools.loadFromFXMLFile("CameraFinderWindow.fxml");
        Scene scene = new Scene(rootPane);
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }
}
