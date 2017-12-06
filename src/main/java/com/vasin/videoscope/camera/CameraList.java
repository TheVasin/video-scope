package com.vasin.videoscope.camera;

import com.github.sarxos.webcam.Webcam;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CameraList {
    private static volatile ObservableList<Webcam> list;

    public static ObservableList<Webcam> getList() {
        if (null == list) {
            init();
        }
        return list;
    }

    public static void init() {
        if (list != null) {
            return;
        }
        list = FXCollections.observableArrayList();
        new Thread(() -> {
            findCameras();
        }).start();
    }

    private static void findCameras() {
        for (Webcam camera : Webcam.getWebcams()) {
            String name = camera.getName();
            if (list.contains(camera)) {
                continue;
            }
            list.add(camera);
        }
    }
}