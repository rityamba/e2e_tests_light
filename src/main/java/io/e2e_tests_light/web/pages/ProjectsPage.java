package io.e2e_tests_light.web.pages;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.e2e_tests_light.utils.StringParsers.parseInteger;

public class ProjectsPage {

    private static final SelenideElement SEARCH_FIELD = $("#search");
    private static final SelenideElement SUCCESS_MESSAGE = $(".common-flash-success");
    private static final String SUCCESS_MESSAGE_TEXT = "Signed in successfully";

    public void isLoaded(){
        SEARCH_FIELD.shouldBe(visible);
    }

    public void open(){
        Selenide.open("");
    }

    public void searchProject(String projectName) {
        SEARCH_FIELD.setValue(projectName);
    }

    public void selectProjectByName(String projectName) {
        $(Selectors.byText(projectName)).click();
    }

    public void signInSuccess(){
        SUCCESS_MESSAGE.shouldBe(Condition.visible);
        SUCCESS_MESSAGE.shouldHave(text(SUCCESS_MESSAGE_TEXT));
    }

    public ElementsCollection countOfProjectsShouldBeEqualTo(int expectedSize) {
        return $$("#grid ul li").filter(visible)
                .shouldHave(size(expectedSize));
    }

    public void countOfTestsShouldBeEqualTo(SelenideElement targetProject, int expectedCount) {
        String countOfTests = targetProject.$("p").getText();
        Integer actualCountOfTest = parseInteger(countOfTests);
        Assertions.assertEquals(expectedCount, actualCountOfTest);
    }
}
