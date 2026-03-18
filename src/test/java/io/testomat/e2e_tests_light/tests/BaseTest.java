package io.testomat.e2e_tests_light.tests;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BaseTest {

    private static final String USER_MENU_BUTTON = "#user-menu-button";
    private static final String SIGN_OUT_BUTTON = ".button_to [type=\"submit\"]";
    private static final String ROOT_LINK = "a[href=\"/\"]";

    public static Dotenv dotenv = Dotenv.load();
    static String login = dotenv.get("TEST_LOGIN");
    static String password = dotenv.get("TEST_PASSWORD");

    static {
        Configuration.baseUrl = dotenv.get("BASE_URL");
    }

    public static void goToRootPage() {
        $(ROOT_LINK).click();
    }

    public static void signOut(){
        goToRootPage();
        $(USER_MENU_BUTTON).click();
        $(SIGN_OUT_BUTTON).shouldBe(visible).click();
    }

}
