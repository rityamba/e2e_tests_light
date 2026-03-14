package com.madmuscles.e2e_tests_light;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class CalorieCalculatorTests {
    private static final Dotenv dotenv = Dotenv.load();

    @Test
    public void firstTest() {

        open("https://madmuscles.com/calorie-calculator");
        $("h1").shouldBe(Condition.text("MadMuscles Calorie & TDEE Calculator"));

        //Fill out the form
        $("[data-sentry-element=\"CalorieCalculatorSwitch\"] > div:nth-child(2)").click();
        $("[name=\"currentWeight\"]").setValue("90");
        $("[name=\"heightCm\"]").setValue("190");
        $("[name=\"age\"]").setValue("35");
        $("#selector-wrapper:has([value=\"MALE\"])").click();
        $("#selector-wrapper:has([value=\"1.15\"])").click();

        //dropdown almost killed me
        $("[data-sentry-element=\"DropdownContent\"] button span")
                .shouldBe(Condition.visible)
                .click();
        $("[data-sentry-component='DropdownOption']:has([value='WEIGHT_STAY'])")
                .shouldBe(Condition.visible)
                .click();

        // submit
        $("[data-sentry-element=\"CalorieCalculatorWrapper\"] [data-sentry-element=\"ButtonStyled\"]")
                .click();

        //check kcal value
        Selenide.$("[style='align-self: center;']")
                .shouldHave(Condition.exactText("2200 - 2300 kcal"));
    }
}
