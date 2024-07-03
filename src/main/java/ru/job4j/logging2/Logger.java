package ru.job4j.logging2;

import java.util.*;

public class Logger {
    private String name;
    private LogLevel level;
    private List<Appender> appenders = new ArrayList<>();

    public Logger() {
    }

    public Logger(String name, LogLevel level) {
        this.name = name;
        this.level = level;
    }

    public void addAppender(Appender appender) {
        appenders.add(appender);
    }

    public boolean log(LogLevel level, String message) {
        for (Appender el: appenders) {
            el.append(message);
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
}
