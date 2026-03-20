package io.testomat.e2e_tests_light.tests;

import com.codeborne.selenide.Configuration;
import io.e2e_tests_light.web.pages.NewProjectPage;
import io.e2e_tests_light.web.pages.ProjectPage;
import io.e2e_tests_light.web.pages.ProjectsPage;
import io.e2e_tests_light.web.pages.SignInPage;
import io.github.cdimascio.dotenv.Dotenv;

public class BaseTest {

    public static Dotenv dotenv = Dotenv.load();
    static String login = dotenv.get("TEST_LOGIN");
    static String password = dotenv.get("TEST_PASSWORD");
    static String targetCompanyName = dotenv.get("COMPANY_NAME");
    static String targetProjectName = dotenv.get("PROJECT_NAME");

    public static final ProjectsPage projectsPage = new ProjectsPage();
    public static final NewProjectPage newProjectPage = new NewProjectPage();
    public static final ProjectPage projectPage = new ProjectPage();
    public static final SignInPage signInPage = new SignInPage();


    private static final String USER_MENU_BUTTON = "#user-menu-button";
    private static final String SIGN_OUT_BUTTON = ".button_to [type=\"submit\"]";


    static {
        Configuration.baseUrl = dotenv.get("BASE_URL");
    }

//    @AfterEach
//    public void signOut(){
//        projectsPage.openProjectsPage();
//        $(USER_MENU_BUTTON).click();
//        $(SIGN_OUT_BUTTON).shouldBe(visible).click();
//    }

}
