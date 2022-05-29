package com.example.learning.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class FlipKartMyStepdefs {

    @Given("the url for the flipkart app for a product")
    public void the_url_for_the_flipkart_app_for_a_product() {
        System.out.println("Test");
    }
    @Given("username and password")
    public void username_and_password() {
        System.out.println("One");
    }
    @Then("Get the product details")
    public void get_the_product_details() {
        System.out.println("Two");
    }


}
