package edu.pattern.shapes.util;

public class IdGenerator {
    private static int counter = 0;

    public static synchronized int increment() {
        return ++counter;
    }
}
