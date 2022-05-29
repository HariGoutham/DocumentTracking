Feature: Verify test feature of application using Cucumber

  Scenario: Test addition of 2 numbers
    Given Numbers 34 and 56
    Then calculate sum of the numbers

  Scenario: Test flipkart backend call
    Given the url for the flipkart app for a product
    And username and password
    Then Get the product details
