package io.testomat.e2e_tests_light.tests;


import io.e2e_tests_light.web.pages.SignInPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.e2e_tests_light.web.pages.ProjectPage.createNewProject;

public class CreateNewProjectTests extends BaseTest {

    private static final String CLASSICAL_TYPE = "classical";
    private static final String BDD_TYPE = "bdd";

    @BeforeAll
    static void openSiteAndLogin() {
        SignInPage signInPage = new SignInPage();
        signInPage.open();
        signInPage.loginUser(login, password);
    }

    /* This is the part I really don't like... What should I do?
    I moved the goToRootPage() method to a separate class,
    but I want to call it after every test.
    To do that, I need to create another method, which seems kind of stupid.
    I think this is where I realized what it means when code smells
     */
    @AfterEach
    void goHomePage() {
        goToRootPage();
    }

    @Test
    void createNewClassicalProject() {
        String newClassicalProjectName = "newClassicalProjectName";
        createNewProject(CLASSICAL_TYPE, newClassicalProjectName);
    }

    @Test
    void createNewBDDProject() {
        String newBDDProjectName = "newBDDProjectName";
        createNewProject(BDD_TYPE, newBDDProjectName);
    }
}
