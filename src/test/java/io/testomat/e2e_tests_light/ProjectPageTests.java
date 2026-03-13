package io.testomat.e2e_tests_light;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPageTests {
    private static final Dotenv dotenv = Dotenv.load();

    @Test
    public void firstTest() {

        //login
        open("https://app.testomat.io/users/sign_in");
        $("#content-desktop #user_email").setValue(dotenv.get("TEST_LOGIN"));
        $("#content-desktop #user_password").setValue(dotenv.get("TEST_PASSWORD"));
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        //check that login is successful
        $(".common-flash-success").shouldBe(visible);

        //search and pick the project
        $("#search").setValue(dotenv.get("TEST_PROJECT_NAME"));
        $(byText(dotenv.get("TEST_PROJECT_NAME"))).click();
        sleep(10000);
        //check that project is opened
        $(".sticky-header h2").shouldHave(text(dotenv.get("TEST_PROJECT_NAME")));
    }
}
