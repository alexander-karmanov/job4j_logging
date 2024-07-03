package ru.job4j.logging2;

public class App {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLoggerFromConfig("app.properties");
        logger.info("This is an info message.");
    }
}
