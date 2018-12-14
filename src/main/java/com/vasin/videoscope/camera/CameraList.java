package com.vasin.videoscope.camera;

import com.github.sarxos.webcam.Webcam;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CameraList {
    private static volatile ObservableList<Webcam> list;

    private static volatile Webcam defaultCamera;

    public static ObservableList<Webcam> getList() {
        if (null == list) {
            init();
        }
        return list;
    }

    private static void init() {
        if (list != null) {
            return;
        }
        list = FXCollections.observableArrayList();
        new Thread(CameraList::findCameras).start();
    }

    public static void findCameras() {
        for (Webcam camera : Webcam.getWebcams()) {
            if (list.contains(camera)) {
                continue;
            }
            list.add(camera);
        }
    }

    public static Webcam getDefaultCamera() {
        return defaultCamera;
    }

    public static void setDefaultCamera(Webcam defaultCamera) {
        CameraList.defaultCamera = defaultCamera;
    }

    public static void openCamera(Webcam camera) {
        new Thread(camera::open).start();
    }
}
