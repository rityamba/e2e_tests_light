package io.testomat.e2e_tests_light;


import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class CreateNewProjectTests extends BaseTest{

    @BeforeAll
    static void openSiteAndLogin(){
        open(baseUrl);
        loginUser(login, password);
    }

    static void createNewProject(){

    }


}
