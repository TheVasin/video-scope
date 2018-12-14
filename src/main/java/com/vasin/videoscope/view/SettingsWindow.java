package com.vasin.videoscope.view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SettingsWindow {
    private Stage stage;

    public SettingsWindow() {
        this.stage = new Stage();
        this.stage.setTitle("Settings");
        stage.initModality(Modality.APPLICATION_MODAL);
        AnchorPane rootPane = SharedTools.loadFromFXMLFile("SettingsWindow.fxml");
        Scene scene = new Scene(rootPane);
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }
}
