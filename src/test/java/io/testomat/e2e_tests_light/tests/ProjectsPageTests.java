package io.testomat.e2e_tests_light.tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.e2e_tests_light.web.pages.ProjectPage;
import io.e2e_tests_light.web.pages.ProjectsPage;
import io.e2e_tests_light.web.pages.SignInPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.e2e_tests_light.utils.StringParsers.parseInteger;

public class ProjectsPageTests extends BaseTest {
    private static final ProjectsPage projectsPage= new ProjectsPage();
    private static final ProjectPage projectPage= new ProjectPage();
    private static final SignInPage signInPage= new SignInPage();
    private final String targetProjectName = "Testiks";

    @BeforeAll
    static void openSiteAndLogin() {
        signInPage.open();
        signInPage.loginUser(login, password);
        projectsPage.signInSuccess();
    }

    @BeforeEach
    void openProjectsPage(){
        projectsPage.open();
        projectsPage.isLoaded();
    }

    @Test
    public void userCanFindProject() {
        projectsPage.searchProject(targetProjectName);
        projectsPage.selectProjectByName(targetProjectName);
        projectPage.isLoaded(targetProjectName);
    }

    @Test
    public void anotherTest() {
        projectsPage.searchProject(targetProjectName);
        SelenideElement targetProject = projectsPage.countOfProjectsShouldBeEqualTo(1).first();
        projectsPage.countOfTestsShouldBeEqualTo(targetProject, 0);
    }

}
