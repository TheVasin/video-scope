package com.vasin.videoscope;

import com.vasin.videoscope.logger.AppLogger;
import com.vasin.videoscope.view.CameraFinderWindow;
import com.vasin.videoscope.view.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.Logger;

public class VideoScope extends Application {
    private Logger logger;
    @Override
    public void start(Stage primaryStage) {
        AppLogger.info("Starting application");
        MainWindow mainWindow = new MainWindow("Video Scope");
        CameraFinderWindow finderWindow = new CameraFinderWindow("Please select a camera to use");
        mainWindow.show();
        finderWindow.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
