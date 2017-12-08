package com.vasin.videoscope.view;

import com.vasin.videoscope.VideoScope;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;

class SharedTools {

    static <T> T loadFromFXMLFile(String filename) {
        T obj = null;
        URL FXMLFile = VideoScope.class.getClassLoader().getResource(filename);
        FXMLLoader loader = new FXMLLoader(FXMLFile);
        try {
            obj = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
