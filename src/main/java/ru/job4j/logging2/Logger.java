package ru.job4j.logging2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Logger {
    private String name;
    private LogLevel level;
    private Appender appender;

    public Logger(String name, LogLevel level) {
        this.name = name;
        this.level = level;
    }

    public Properties getConfig() {
        var properties = new Properties();
        try (InputStream input = Logger.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public boolean log(LogLevel level, String message) {
        String[] array = getConfig().getProperty("appenders").split(",");
        for (var el : array) {
            if (el.equals("ConsoleAppender")) {
                appender = new ConsoleAppender();
                appender.append(message);
            }
            if (el.equals("FileAppender")) {
                appender = new FileAppender(getConfig().getProperty("file"));
                appender.append(message);
            }
        }
        return true;
    }

    public boolean debug(String message) {
        log(LogLevel.DEBUG, message);
        return true;
    }

    public boolean info(String message) {
        log(LogLevel.INFO, message);
        return true;
    }

    public boolean warn(String message) {
        log(LogLevel.WARN, message);
        return true;
    }

    public boolean error(String message) {
        log(LogLevel.ERROR, message);
        return true;
    }

    public static void main(String[] args) {
        Logger logger = new Logger("TestLogger", LogLevel.DEBUG);
        logger.log(LogLevel.DEBUG, "This is a debug message 1");
    }
}
