package io.e2e_tests_light.web.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SignInPage {

    private static final String USER_EMAIL_FIELD = "#content-desktop #user_email";
    private static final String USER_PASSWORD_FIELD = "#content-desktop #user_password";
    private static final String SUBMIT_BUTTON = "#content-desktop [name=\"commit\"]";
    private static final String REMEMBER_ME_BUTTON = "#content-desktop #user_remember_me";




    public void loginUser(String login, String password) {
        fillLoginForm(login, password);
        submitLoginForm();
        verifySignPageClosed();

    }

    private static void verifySignPageClosed() {
        $(USER_EMAIL_FIELD).shouldNotBe(visible);
        $(USER_PASSWORD_FIELD).shouldNotBe(visible);
    }

    public void open(){
        Selenide.open("/users/sign_in");
    }

    private static void fillLoginForm(String login, String password) {
        $(USER_EMAIL_FIELD).setValue(login);
        $(USER_PASSWORD_FIELD).setValue(password);
        $(REMEMBER_ME_BUTTON).click();
    }

    private static void submitLoginForm() {
        $(SUBMIT_BUTTON).click();
    }


}