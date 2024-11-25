package com.example.myapplication.cucumber.steps;

import com.example.myapplication.test.CatScreenRobot;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class CucumberStepsDefinition {

    private final CatScreenRobot testRobot = new CatScreenRobot();

    /*@Given("^I start the application$")
    public void startApplication() {
        testRobot.launchCatActivity();
    }*/

    @Given("^I start the application with APK installed$")
    public void startApplicationWithApk() {
        testRobot.setupWithInstalledApk();
    }

    @When("^I click on the button$")
    public void clickButton() {
        testRobot.clickWhoIsButton();
    }

    @Then("^I expect to see Porto is the best cat$")
    public void checkPortoIsTheBestCat() {
        testRobot.checkBestCatText();
    }

    @Then("^I expect to see Porto is the best cat not eating too much$")
    public void iExpectToSeePortoIsTheBestCatNotEatingTooMuch() {
        testRobot.checkBestCatTextFailing();
    }
}
