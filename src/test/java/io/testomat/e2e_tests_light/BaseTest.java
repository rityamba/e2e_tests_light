package io.testomat.e2e_tests_light;

import io.github.cdimascio.dotenv.Dotenv;

public class BaseTest {
    public static Dotenv dotenv = Dotenv.load();

    public BaseTest() {
    }

    public Integer parseInteger(String text) {
        String digitText = text.replaceAll("\\D+", "");
        return Integer.parseInt(digitText);
    }

    public Double parseDouble(String text) {
        String doubleText = text.replaceAll("\\d.", "");
        return Double.parseDouble(doubleText);
    }
}
