package io.testomat.e2e_tests_light;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.e2e_tests_light.utils.StringParsers.parseInteger;

public class ProjectPageTests extends BaseTest {
    String login = dotenv.get("TEST_LOGIN");
    String password = dotenv.get("TEST_PASSWORD");
    String baseUrl = dotenv.get("BASE_URL");
    String targetProjectName = "Testiks";

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
        SelenideElement targetProject = countOfProjectsShouldBeEqualTo(1).first();
        countOfTestsShouldBeEqualTo(targetProject, 0);
    }

    private void countOfTestsShouldBeEqualTo(SelenideElement targetProject, int expectedCount) {
        String countOfTests = targetProject.$("p").getText();
        Integer actualCountOfTest = parseInteger(countOfTests);

        Assertions.assertEquals(expectedCount, actualCountOfTest);
    }
    private static void waitForProjectIsLoaded(String projectName) {
        $(".sticky-header h2")
                .shouldHave(text(projectName));
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
                .shouldBe(visible);
    }

    private static ElementsCollection countOfProjectsShouldBeEqualTo(int expectedSize) {
        return $$("#grid ul li").filter(visible)
                .shouldHave(size(expectedSize));
    }

}
