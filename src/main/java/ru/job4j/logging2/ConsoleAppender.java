package ru.job4j.logging2;

public class ConsoleAppender implements Appender {
    @Override
    public void append(String message) {
        System.out.println(message);
    }
}
