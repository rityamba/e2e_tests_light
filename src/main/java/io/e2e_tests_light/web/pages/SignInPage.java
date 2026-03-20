package io.e2e_tests_light.web.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SignInPage {

    private static final String PATH = "/users/sign_in";

    private final SelenideElement GOOGLE_BUTTON = $("#content-desktop a[href='/users/auth/google_oauth2']");
    private final SelenideElement GITHUB_BUTTON = $("#content-desktop a[href='/users/auth/github']");
    private final SelenideElement SSO_BUTTON = $("#content-desktop a[href='/users/sso']");

    private final SelenideElement USER_EMAIL_FIELD = $("#content-desktop #user_email");
    private final SelenideElement USER_PASSWORD_FIELD = $("#content-desktop #user_password");
    private final SelenideElement SUBMIT_BUTTON = $("#content-desktop [name=\"commit\"]");
    private final SelenideElement REMEMBER_ME_BUTTON = $("#content-desktop #user_remember_me");
    private final SelenideElement ERROR_MESSAGE = $("#content-desktop .common-flash-info");
    private static final String ERROR_MESSAGE_TEXT = "Invalid Email or password.";


    public void signIn(String login, String password) {
        openSignInPage();
        fillLoginForm(login, password);
        submitLoginForm();
        verifySignPageClosed();

    }

    public void openSignInPage() {
        Selenide.open(PATH);
    }

    public void fillLoginForm(String login, String password) {
        USER_EMAIL_FIELD.setValue(login);
        USER_PASSWORD_FIELD.setValue(password);
        REMEMBER_ME_BUTTON.click();
    }

    public void submitLoginForm() {
        SUBMIT_BUTTON.click();
    }

    private void verifySignPageClosed() {
        USER_EMAIL_FIELD.shouldNotBe(visible);
        USER_PASSWORD_FIELD.shouldNotBe(visible);
    }

    public void socialButtonsShouldBeVisible() {
        GOOGLE_BUTTON.shouldBe(visible);
        GITHUB_BUTTON.shouldBe(visible);
        SSO_BUTTON.shouldBe(visible);
    }

    public void checkErrorMessage() {
        ERROR_MESSAGE.shouldHave(text(ERROR_MESSAGE_TEXT));
    }


}