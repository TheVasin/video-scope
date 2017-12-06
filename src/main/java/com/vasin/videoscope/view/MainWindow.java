package com.vasin.videoscope.view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainWindow {
    private Stage stage;
    private AnchorPane rootPane;

    public MainWindow(String title) {
        this.stage = new Stage();
        this.stage.setTitle(title);
        rootPane = (AnchorPane) SharedTools.loadFromFXMLFile("MainWindow.fxml");
        Scene scene = new Scene(rootPane);
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }
}
