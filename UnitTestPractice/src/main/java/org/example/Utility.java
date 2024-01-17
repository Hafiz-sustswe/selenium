package org.example;

public class Utility {
    public static int add(int a, int b) {
        return a + b;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static String getGreeting(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        return "Hello, " + name + "!";
    }
}
