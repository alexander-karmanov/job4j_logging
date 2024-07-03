package ru.job4j;

import ru.job4j.logging2.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoggerTest {

    @Test
    public void testConsoleAppender() {
        TestAppender testAppender = new TestAppender();
        Logger logger = LoggerFactory.of(testAppender);
        logger.info("Test info message");
        assertTrue(testAppender.getMessages().get(0).contains("info"));
    }

    @Test
    public void testFileAppender() throws IOException {
        String testFilePath = "logs.txt";
        Logger logger = LoggerFactory.of(new FileAppender(testFilePath));
        logger.debug("Test debug message");
        List<String> lines = Files.readAllLines(Paths.get(testFilePath));
        assertTrue(lines.get(0).contains("debug"));
    }

    @Test
    public void testLoggerFromConfig() {
        Logger logger = LoggerFactory.getLoggerFromConfig("app.properties");
        TestAppender testAppender = new TestAppender();
        logger.addAppender(testAppender);
        logger.info("Test info message from config");
        assertTrue(testAppender.getMessages().get(0).contains("info"));
    }
}
