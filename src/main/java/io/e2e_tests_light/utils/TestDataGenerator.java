package io.e2e_tests_light.utils;

import com.github.javafaker.Faker;

public class TestDataGenerator {
    Faker faker = new Faker();

    public String randomEmail(){
        return faker.internet().emailAddress();
    }
    public String randomPassword(){
        return faker.internet().password();
    }
}
