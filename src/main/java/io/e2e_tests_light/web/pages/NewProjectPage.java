package io.e2e_tests_light.web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NewProjectPage {

    private static final String SELECTED_OPTION_ICON = ".*circle-tick\\.svg.*";

    private static final SelenideElement PROJECT_TITLE = $("#project_title");
    private static final ElementsCollection SUBMIT_BUTTON = $$("#project-form [type=\"submit\"]");

    private static final SelenideElement PAGE_HEADER = $(".common-page-header h2");
    private static final String NEW_PROJECT_HEADER = "New Project";

    public void isLoaded() {
        PAGE_HEADER.shouldBe(visible).shouldHave(text(NEW_PROJECT_HEADER));
    }

    public void createNewProject(String type, String newProjectName) {
        selectProjectType(type);
        fillProjectTitle(newProjectName);
        submitProjectForm();
    }

    private void selectProjectType(String type) {
        $(String.format("#%s", type)).click();
        $(String.format("#%s-img", type))
                .shouldHave(attributeMatching("src", SELECTED_OPTION_ICON));
    }

    private static void fillProjectTitle(String newProjectName) {
        PROJECT_TITLE.setValue(newProjectName);
    }

    private static void submitProjectForm() {
        SUBMIT_BUTTON.filter(visible).first().click();
    }


}
