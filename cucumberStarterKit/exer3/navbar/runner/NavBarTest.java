package com.capgemini.mrchecker.cucumberStarterKit.exer3.navbar.runner;

import org.junit.runner.RunWith;

import com.capgemini.mrchecker.test.core.BaseTest;
import com.capgemini.mrchecker.test.core.logger.BFLogger;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
		features = "src\\test\\java\\com\\capgemini\\mrchecker\\cucumberStarterKit\\exer3\\navbar\\gherkins\\navbar.feature",
		glue = "com.capgemini.mrchecker.cucumberStarterKit.exer3.navbar.stepdefs",
		plugin = "json:target/report/exer3/navbar.json")
public class NavBarTest extends BaseTest {
	
	@Override
	public void setUp() {
		BFLogger.logInfo("I'm in setup");
	}
	
	@Override
	public void tearDown() {
		BFLogger.logInfo("I'm in tearDown");
		
	}
	
}
