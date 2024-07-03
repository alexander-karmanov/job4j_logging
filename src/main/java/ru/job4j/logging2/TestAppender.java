package ru.job4j.logging2;

import java.util.ArrayList;
import java.util.List;

public class TestAppender implements Appender {
    private List<String> messages = new ArrayList<>();

    @Override
    public void append(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}
