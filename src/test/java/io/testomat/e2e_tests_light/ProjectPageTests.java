//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package io.testomat.e2e_tests_light;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebElementCondition;
import com.codeborne.selenide.WebElementsCondition;
import org.junit.jupiter.api.Test;

public class ProjectPageTests extends BaseTest {
    String login;
    String password;
    String baseUrl;
    String targetProjectName;

    public ProjectPageTests() {
        this.login = dotenv.get("TEST_LOGIN");
        this.password = dotenv.get("TEST_PASSWORD");
        this.baseUrl = dotenv.get("BASE_URL");
        this.targetProjectName = "Testiks";
    }

    private static void waitForProjectIsLoaded(String projectName) {
        Selenide.$(".sticky-header h2").shouldHave(new WebElementCondition[]{Condition.text(projectName)});
    }

    private static void selectProjectByName(String projectName) {
        Selenide.$(Selectors.byText(projectName)).click();
    }

    private static void searchProject(String projectName) {
        Selenide.$("#search").setValue(projectName);
    }

    private static void loginUser(String login, String password) {
        Selenide.$("#content-desktop #user_email").setValue(login);
        Selenide.$("#content-desktop #user_password").setValue(password);
        Selenide.$("#content-desktop #user_remember_me").click();
        Selenide.$("#content-desktop [name=\"commit\"]").click();
        Selenide.$(".common-flash-success").shouldBe(new WebElementCondition[]{Condition.visible});
    }

    @Test
    public void firstTest() {
        Selenide.open(this.baseUrl);
        loginUser(this.login, this.password);
        searchProject(this.targetProjectName);
        selectProjectByName(this.targetProjectName);
        waitForProjectIsLoaded(this.targetProjectName);
    }

    @Test
    public void anotherTest() {
        Selenide.open(this.baseUrl);
        loginUser(this.login, this.password);
        searchProject(this.targetProjectName);
        ((ElementsCollection)Selenide.$$("#grid ul li").filter(Condition.visible)).shouldHave(new WebElementsCondition[]{CollectionCondition.size(1)});
        Selenide.$("[title='Testiks'] p").shouldHave(new WebElementCondition[]{Condition.exactText("0 tests")});
    }

    @Test
    public void anotherTestCheck() {
        Double digit = this.parseDouble("875767 tests");
        System.out.println(digit);
        System.out.println(digit instanceof Double);
    }
}
