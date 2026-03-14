package io.testomat.e2e_tests_light;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.e2e_tests_light.utils.StringParsers.parseInteger;

public class ProjectPageTests extends BaseTest {

    @BeforeAll
    static void openSiteAndLogin(){
        open(baseUrl);
        loginUser(login, password);
    }

    @Test
    public void firstTest() {
        searchProject(targetProjectName);
        selectProjectByName(targetProjectName);
        waitForProjectIsLoaded(targetProjectName);
    }

    @Test
    public void anotherTest() {
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

    private static ElementsCollection countOfProjectsShouldBeEqualTo(int expectedSize) {
        return $$("#grid ul li").filter(visible)
                .shouldHave(size(expectedSize));
    }

}
