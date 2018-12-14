package com.vasin.videoscope;

import com.vasin.videoscope.logger.AppLogger;
import com.vasin.videoscope.view.MainWindow;
import com.vasin.videoscope.view.SettingsWindow;
import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.Logger;

public class VideoScope extends Application {
    private Logger logger;
    @Override
    public void start(Stage primaryStage) {
        AppLogger.info("Starting application");
        MainWindow mainWindow = new MainWindow("Video Scope");
        SettingsWindow settingsWindow = new SettingsWindow();
        mainWindow.show();
        settingsWindow.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
