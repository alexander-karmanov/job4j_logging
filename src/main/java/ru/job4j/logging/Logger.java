package main.java.ru.job4j.logging;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Logger {
    private String name;
    private LogLevel level;
    private Appender appender;

    public Logger(String name, LogLevel level) {
        this.name = name;
        this.level = level;
    }

    public String getConfig() {
        var properties = new Properties();
        try (InputStream input = Logger.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("appender");
    }

    public boolean log(LogLevel level, String message) {
        /* Реализация логгирования */
        appender = new ConsoleAppender();
        appender.append(message);
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
}
