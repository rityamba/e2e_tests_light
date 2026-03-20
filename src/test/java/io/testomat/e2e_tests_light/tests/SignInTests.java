package io.testomat.e2e_tests_light.tests;


import io.e2e_tests_light.utils.TestDataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SignInTests extends BaseTest {

    private final TestDataGenerator testData = new TestDataGenerator();

    @BeforeEach
    public void beforeEach() {
        signInPage.openSignInPage();
    }

    @Test
    public void loginOptionsAreVisible() {
        signInPage.socialButtonsShouldBeVisible();
    }

    @Test
    public void userCanSignInWithValidEmail() {
        signInPage.fillLoginForm(login, password);
    }

    @Test
    public void userCanNotSignInWithUnregisteredEmail() {
        signInPage.fillLoginForm(testData.randomEmail(), testData.randomPassword());
        signInPage.submitLoginForm();
        signInPage.checkErrorMessage();
    }

    @Test
    public void userCanNotSignInWithoutCredentials() {
        signInPage.submitLoginForm();
        signInPage.checkErrorMessage();
    }


}

