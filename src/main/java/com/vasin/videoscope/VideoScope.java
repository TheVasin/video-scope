package com.vasin.videoscope;

import com.vasin.videoscope.view.CameraFinderWindow;
import com.vasin.videoscope.view.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class VideoScope extends Application {
    @Override
    public void start(Stage primaryStage) {
        MainWindow mainWindow = new MainWindow("Video Scope");
        CameraFinderWindow finderWindow = new CameraFinderWindow("Please select a camera to use");
        mainWindow.show();
        finderWindow.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
