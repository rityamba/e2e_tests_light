package io.testomat.e2e_tests_light.tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProjectsPageTests extends BaseTest {


    @BeforeAll
    static void openSiteAndLogin() {
        signInPage.signIn(login, password);
        projectsPage.signInSuccess();

        projectsPage.changeCompanyTo(targetCompanyName);
        projectsPage.checkCompanyName(targetCompanyName);
    }

    @BeforeEach
    void openProjectsPage() {
        projectsPage.openProjectsPage();
        projectsPage.isLoaded();
    }

    @Test
    public void userCanFindProject() {
        projectsPage.searchProject(targetProjectName);
        projectsPage.selectProjectByName(targetProjectName);
        projectPage.isLoaded(targetProjectName);
    }

    @Test
    public void userCanSeeCorrectTestsCount() {
        projectsPage.searchProject(targetProjectName);
        SelenideElement targetProject = projectsPage.countOfProjectsShouldBeEqualTo(1).first();
        projectsPage.countOfTestsShouldBeEqualTo(targetProject, 0);
    }

}
