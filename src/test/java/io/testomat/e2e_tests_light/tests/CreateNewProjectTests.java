package io.testomat.e2e_tests_light.tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CreateNewProjectTests extends BaseTest {

    private static final String CLASSICAL_TYPE = "classical";
    private static final String BDD_TYPE = "bdd";

    @BeforeAll
    static void openSiteAndLogin() {
        signInPage.signIn(login, password);
        projectsPage.changeCompanyTo(targetCompanyName);
    }

    @AfterEach
    void openNewProjectPage() {
        projectsPage.openProjectsPage();

    }

    @Test
    void createNewClassicalProject() {
        projectsPage.clickCreateProjectButton();
        newProjectPage.isLoaded();

        String newClassicalProjectName = "newClassicalProjectName";
        newProjectPage.createNewProject(CLASSICAL_TYPE, newClassicalProjectName);

        projectPage.verifyNewProjectOpened(newClassicalProjectName);
    }

    @Test
    void createNewBDDProject() {
        projectsPage.clickCreateProjectButton();
        newProjectPage.isLoaded();

        String newBDDProjectName = "newBDDProjectName";
        newProjectPage.createNewProject(BDD_TYPE, newBDDProjectName);

        projectPage.verifyNewProjectOpened(newBDDProjectName);
    }
}
