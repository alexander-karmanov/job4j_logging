package ru.job4j;

import ru.job4j.logging2.LogLevel;
import ru.job4j.logging2.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoggerTest {
    private Logger logger;

    @BeforeEach
    public void setUp() {
        logger = new Logger("TestLogger", LogLevel.DEBUG);
    }

    @Test
    public void testDebugLogging() {
        /* testing debug logging */
        assertTrue(logger.debug("This is a debug message"));
    }

    @Test
    public void testInfoLogging() {
        /* testing info logging */
        assertTrue(logger.info("This is an info message"));
    }

    @Test
    public void testWarnLogging() {
        /* testing warn logging */
        assertTrue(logger.warn("This is a warn message"));
    }

    @Test
    public void testErrorLogging() {
        /* testing error logging */
        assertTrue(logger.error("This is an error message"));
    }
}
