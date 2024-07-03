package ru.job4j.logging2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoggerFactory {
    public static Logger of(Appender... appenders) {
        Logger logger = new Logger();
        for (Appender appender : appenders) {
            logger.addAppender(appender);
        }
        return logger;
    }

    public static Properties getConfig(String configFilePath) {
        var properties = new Properties();
        try (InputStream input = Logger.class.getClassLoader()
                .getResourceAsStream(configFilePath)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;

    }

    public static Logger getLoggerFromConfig(String configFilePath) {
        Properties properties = getConfig(configFilePath);
        Logger logger = new Logger();

        String appenders = properties.getProperty("appenders");

        if (appenders != null) {
            String[] appenderArray = appenders.split(",");
            for (String appenderType : appenderArray) {
                switch (appenderType.trim()) {
                    case "ConsoleAppender":
                        logger.addAppender(new ConsoleAppender());
                        break;
                    case "FileAppender":
                        String filePath = properties.getProperty("file");
                        if (filePath != null) {
                            logger.addAppender(new FileAppender(filePath));
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + appenderType.trim());
                }
            }
        }
        return logger;
    }
}
