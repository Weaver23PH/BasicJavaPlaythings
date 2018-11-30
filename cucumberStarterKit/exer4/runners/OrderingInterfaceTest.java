package com.capgemini.mrchecker.cucumberStarterKit.exer4.runners;

import org.junit.runner.RunWith;

import com.capgemini.mrchecker.test.core.BaseTest;
import com.capgemini.mrchecker.test.core.logger.BFLogger;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
		features = "src\\test\\java\\com\\capgemini\\mrchecker\\cucumberStarterKit\\exer4\\gherkins\\interface.feature",
		glue = "com.capgemini.mrchecker.cucumberStarterKit.exer4.stepdefs",
		plugin = "json:target/report/exer4/interface.json")
public class OrderingInterfaceTest extends BaseTest {
	
	@Override
	public void setUp() {
		BFLogger.logInfo("I'm in setup");
	}
	
	@Override
	public void tearDown() {
		BFLogger.logInfo("I'm in tearDown");
	}
	
}
