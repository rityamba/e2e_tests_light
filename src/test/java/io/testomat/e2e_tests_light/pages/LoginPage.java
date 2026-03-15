package io.testomat.e2e_tests_light.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static final String USER_EMAIL = "#content-desktop #user_email";
    private static final String USER_PASSWORD = "#content-desktop #user_password";
    private static final String SUBMIT_BUTTON = "#content-desktop [name=\"commit\"]";
    private static final String REMEMBER_ME = "#content-desktop #user_remember_me";

    private static final String SUCCESS_MESSAGE = ".common-flash-success";
    private static final String SUCCESS_MESSAGE_TEXT = "Signed in successfully";


    public static void loginUser(String login, String password) {
        fillLoginForm(login, password);
        submitLoginForm();
        verifyLoginSuccess();
    }

    private static void fillLoginForm(String login, String password) {
        $(USER_EMAIL).setValue(login);
        $(USER_PASSWORD).setValue(password);
        $(REMEMBER_ME).click();
    }

    private static void submitLoginForm() {
        $(SUBMIT_BUTTON).click();
    }

    private static void verifyLoginSuccess() {
        $(SUCCESS_MESSAGE).shouldBe(visible);
        $(SUCCESS_MESSAGE).shouldHave(text(SUCCESS_MESSAGE_TEXT));
    }

}