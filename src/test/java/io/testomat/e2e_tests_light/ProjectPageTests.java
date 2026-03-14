package io.testomat.e2e_tests_light;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebElementCondition;
import com.codeborne.selenide.WebElementsCondition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class ProjectPageTests extends BaseTest {
    String login = dotenv.get("TEST_LOGIN");
    String password = dotenv.get("TEST_PASSWORD");
    String baseUrl = dotenv.get("BASE_URL");
    String targetProjectName = "Testiks";


    private static void waitForProjectIsLoaded(String projectName) {
        $(".sticky-header h2")
                .shouldHave(new WebElementCondition[]{Condition.text(projectName)});
    }

    private static void selectProjectByName(String projectName) {
        $(Selectors.byText(projectName)).click();
    }

    private static void searchProject(String projectName) {
        $("#search").setValue(projectName);
    }

    private static void loginUser(String login, String password) {
        $("#content-desktop #user_email").setValue(login);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $(".common-flash-success")
                .shouldBe(new WebElementCondition[]{Condition.visible});
    }

    @Test
    public void firstTest() {
        open(baseUrl);
        loginUser(login, password);
        searchProject(targetProjectName);
        selectProjectByName(targetProjectName);
        waitForProjectIsLoaded(targetProjectName);
    }

    @Test
    public void anotherTest() {
        open(baseUrl);
        loginUser(login, password);
        searchProject(targetProjectName);
        Selenide.$$("#grid ul li").filter(Condition.visible)
                        .shouldHave(CollectionCondition.size(1));
        $("[title='Testiks'] p").shouldHave(Condition.exactText("0 tests"));
    }

    @Test
    public void anotherTestCheck() {
        Integer digit = parseInteger("875767 tests");
        System.out.println(digit);
        System.out.println(digit instanceof Integer);
    }
}
