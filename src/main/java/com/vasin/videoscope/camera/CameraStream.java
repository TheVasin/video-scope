package com.vasin.videoscope.camera;

import com.github.sarxos.webcam.Webcam;
import com.vasin.videoscope.logger.AppLogger;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;

public class CameraStream {
    private boolean stopStream = false;
    private BufferedImage grabbedImage;
    private ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();
    private boolean running = false;

    public void startCameraStream(Webcam camera, ImageView cameraView) {
        AppLogger.debug("Starting up camera stream");
        running = true;
        CameraList.openCamera(camera);
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                while (!stopStream) {
                    try {
                            grabbedImage = camera.getImage();
                            if (null != grabbedImage) {
                                final Image mainImage = SwingFXUtils.toFXImage(grabbedImage, null);
                                imageProperty.set(mainImage);
                            }
                                grabbedImage.flush();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                return null;
            }
        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
        cameraView.imageProperty().bindBidirectional(imageProperty);
    }

    public void stopStream() {
        AppLogger.debug("Shutting down camera stream");
        this.stopStream = true;
        running = false;
    }

    public boolean isRunning() {
        return running;
    }
}
