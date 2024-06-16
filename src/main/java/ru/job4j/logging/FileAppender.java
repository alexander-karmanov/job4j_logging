package main.java.ru.job4j.logging;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements Appender {
    private String filePath;

    public FileAppender(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void append(String message) {
        /* Реализация записи в файл */
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
