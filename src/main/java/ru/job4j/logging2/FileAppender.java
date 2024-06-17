package ru.job4j.logging2;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements Appender {
    private String filePath;

    public FileAppender(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void append(String message) {

        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
