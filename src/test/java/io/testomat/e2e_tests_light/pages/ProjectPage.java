package io.testomat.e2e_tests_light.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.time.Duration.ofSeconds;

public class ProjectPage {

    private static final String ADD_PROJECT_BUTTON = ".common-btn-lg[href=\"/projects/new\"]";
    private static final String PROJECT_CREATE_PAGE_HEADER = ".common-page-header-left h2";
    private static final String PROJECT_CREATE_PAGE_HEADER_TEXT = "New Project";

    private static final String SELECTED_OPTION_ICON = ".*circle-tick\\.svg.*";

    private static final String PROJECT_TITLE = "#project_title";
    private static final String SUBMIT_BUTTON = "#project-form [type=\"submit\"]";

    private static final String EMPTY_TEST_PAGE_HEADER = ".sticky-header h2";
    private static final String EMPTY_TEST_PAGE_TITLE_TEXT = "Let's do some testing!";

    private static final String README_MODAL = ".detail-view-resizable";
    private static final String README_TITLE = "#welcometotestomatio";
    private static final String README_TITLE_TEXT = "Welcome to Testomat.io";
    private static final String CLOSE_README_BUTTON_TEXT = "I got it, let's start!";



    public static void createNewProject(String type, String newProjectName) {
        openCreateProjectPage();
        selectProjectType(type);
        fillProjectTitle(newProjectName);
        submitProjectForm();

        verifyNewProjectOpened(newProjectName);
    }

    private static void openCreateProjectPage() {
        $(ADD_PROJECT_BUTTON).click();
        $(PROJECT_CREATE_PAGE_HEADER).shouldBe(text(PROJECT_CREATE_PAGE_HEADER_TEXT));
    }

    private static void selectProjectType(String type) {
        $(String.format("#%s", type)).click();
        $(String.format("#%s-img", type))
                .shouldHave(attributeMatching("src", SELECTED_OPTION_ICON));
    }

    private static void fillProjectTitle(String newProjectName) {
        $(PROJECT_TITLE).setValue(newProjectName);
    }

    private static void submitProjectForm() {
        $$(SUBMIT_BUTTON).filter(visible).first().click();
    }

    private static void verifyNewProjectOpened(String newProjectName) {
        checkAndCloseReadMe();
        checkEmptyTestsPage(newProjectName);
    }

    private static void checkEmptyTestsPage(String newProjectName) {
        $(withText(EMPTY_TEST_PAGE_TITLE_TEXT)).shouldBe(visible);
        $(EMPTY_TEST_PAGE_HEADER).shouldBe(text(newProjectName));
    }

    private static void checkAndCloseReadMe() {
        $(README_MODAL).shouldBe(visible, ofSeconds(15));
        $(README_TITLE)
                .shouldHave(text(README_TITLE_TEXT));
        $(withText(CLOSE_README_BUTTON_TEXT)).click();
        $(README_MODAL).shouldNotBe(visible);
    }
}
