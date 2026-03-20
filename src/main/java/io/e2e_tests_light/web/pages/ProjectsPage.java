package io.e2e_tests_light.web.pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage {

    private static final SelenideElement SEARCH_FIELD = $("#search");
    private static final SelenideElement SUCCESS_MESSAGE = $(".common-flash-success");
    private static final String SUCCESS_MESSAGE_TEXT = "Signed in successfully";

    private static final SelenideElement COMPANY_SELECTOR = $("#company_id");

    private static final SelenideElement ADD_PROJECT_BUTTON = $(".common-btn-lg[href=\"/projects/new\"]");


    public void isLoaded() {
        SEARCH_FIELD.shouldBe(visible);
    }

    public void openProjectsPage() {
        Selenide.open("");
    }

    public void clickCreateProjectButton() {
        ADD_PROJECT_BUTTON.click();
    }

    public void searchProject(String projectName) {
        SEARCH_FIELD.setValue(projectName);
    }

    public void selectProjectByName(String projectName) {
        $(Selectors.byText(projectName)).click();
    }

    public void signInSuccess() {
        SUCCESS_MESSAGE.shouldBe(Condition.visible);
        SUCCESS_MESSAGE.shouldHave(text(SUCCESS_MESSAGE_TEXT));
    }

    public ElementsCollection countOfProjectsShouldBeEqualTo(int expectedSize) {
        return $$("#grid ul li").filter(visible)
                .shouldHave(size(expectedSize));
    }

    public void countOfTestsShouldBeEqualTo(SelenideElement targetProject, int expectedCount) {
        targetProject.$("p").shouldHave(text(String.valueOf(expectedCount)));
    }

    public void changeCompanyTo(String companyName) {
        COMPANY_SELECTOR.shouldBe(visible).selectOption(companyName);
    }

    public void checkCompanyName(String companyName) {
        COMPANY_SELECTOR.getSelectedOption().shouldHave(text(companyName));
    }
}
