package com.example.learning.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TestDefinition {

    @Given("Numbers {int} and {int}")
    public void numbers_and(Integer int1, Integer int2) {

        int1 = 34;
        int2 = 56;

    }
    @Then("calculate sum of the numbers")
    public void calculate_sum_of_the_numbers() {
        System.out.println(56+34);
    }

}
