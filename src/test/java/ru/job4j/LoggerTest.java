package test.java.ru.job4j;

import main.java.ru.job4j.logging.LogLevel;
import main.java.ru.job4j.logging.Logger;
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
        /* ������������ debug ����������� */
        assertTrue(logger.debug("This is a debug message"));
    }

    @Test
    public void testInfoLogging() {
        /* ������������ info ����������� */
        assertTrue(logger.info("This is an info message"));
    }

    @Test
    public void testWarnLogging() {
        /* ������������ warn �����������  */
        assertTrue(logger.warn("This is a warn message"));
    }

    @Test
    public void testErrorLogging() {
        /* ������������ error ����������� */
        assertTrue(logger.error("This is an error message"));
    }
}
