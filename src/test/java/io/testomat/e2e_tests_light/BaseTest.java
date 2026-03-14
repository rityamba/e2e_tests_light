package io.testomat.e2e_tests_light;

import io.github.cdimascio.dotenv.Dotenv;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    public static Dotenv dotenv = Dotenv.load();
    static String login = dotenv.get("TEST_LOGIN");
    static String password = dotenv.get("TEST_PASSWORD");
    static String baseUrl = dotenv.get("BASE_URL");
    String targetProjectName = "Testiks";

    public BaseTest() {
    }

    public static void loginUser(String login, String password) {
        $("#content-desktop #user_email").setValue(login);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $(".common-flash-success")
                .shouldBe(visible);
    }

}
