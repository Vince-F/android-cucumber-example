package com.example.myapplication.test;

import cucumber.api.CucumberOptions;

@CucumberOptions(features={"features"},
        glue={"com.example.myapplication.cucumber.steps"})
@SuppressWarnings("unused")
class CucumberTestCase {

}