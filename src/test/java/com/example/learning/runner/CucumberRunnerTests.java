package com.example.learning.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(plugin = "pretty", features = {"src/test/resources/features"}, glue = {
        "com.example.demo"})
public class CucumberRunnerTests {
}
