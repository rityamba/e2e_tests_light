package io.e2e_tests_light.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

public class ProjectPage {

    private static final SelenideElement EMPTY_TEST_PAGE_HEADER = $(".sticky-header h2");
    private static final String EMPTY_TEST_PAGE_TITLE_TEXT = "Let's do some testing!";

    private static final SelenideElement README_MODAL = $(".detail-view-resizable");
    private static final SelenideElement README_TITLE = $("#welcometotestomatio");
    private static final String README_TITLE_TEXT = "Welcome to Testomat.io";
    private static final String CLOSE_README_BUTTON_TEXT = "I got it, let's start!";


    public void isLoaded(String projectName) {
        EMPTY_TEST_PAGE_HEADER.shouldHave(text(projectName));
    }

    public void verifyNewProjectOpened(String newProjectName) {
        checkAndCloseReadMe();
        checkEmptyTestsPage(newProjectName);
    }

    private static void checkEmptyTestsPage(String newProjectName) {
        $(withText(EMPTY_TEST_PAGE_TITLE_TEXT)).shouldBe(visible);
        EMPTY_TEST_PAGE_HEADER.shouldBe(text(newProjectName));
    }

    private static void checkAndCloseReadMe() {
        README_MODAL.shouldBe(visible, ofSeconds(15));
        README_TITLE.shouldHave(text(README_TITLE_TEXT));
        $(withText(CLOSE_README_BUTTON_TEXT)).click();
        README_MODAL.shouldNotBe(visible);
    }
}
