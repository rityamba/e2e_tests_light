package io.e2e_tests_light.utils;

public class StringParsers {
    public static Integer parseInteger(String text) {
        String digitText = text.replaceAll("\\D+", "");
        return Integer.parseInt(digitText);
    }

    public static Double parseDouble(String text) {
        String doubleText = text.replaceAll("[^\\d.]", "");
        return Double.parseDouble(doubleText);
    }
}
