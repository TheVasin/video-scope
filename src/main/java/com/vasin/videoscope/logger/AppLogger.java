package com.vasin.videoscope.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLogger {
    private volatile static Logger logger;

    private AppLogger() {
        String name = "Main";
        this.initLogger(name);
    }

    private synchronized void initLogger(String n) {
        logger = LoggerFactory.getLogger(n);
    }

    public static Logger getLogger() {
        if (null == logger) {
            new AppLogger();
        }
        return logger;
    }

    public static void info(String s) {
        getLogger().info(s);
    }

    public static void debug(String s) {
        getLogger().debug(s);
    }

    public static void error(String s) {
        getLogger().error(s);
    }
}
