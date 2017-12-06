package com.vasin.videoscope.view;

import com.vasin.videoscope.VideoScope;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class CameraFinderWindow {
    private BorderPane rootPane;
    private Stage stage;

    public CameraFinderWindow(String title) {
        this.stage = new Stage();
        this.stage.setTitle(title);
        stage.initModality(Modality.APPLICATION_MODAL);
        rootPane = (BorderPane) SharedTools.loadFromFXMLFile("CameraFinderWindow.fxml");
        Scene scene = new Scene(rootPane);
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }
}
