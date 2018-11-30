package com.capgemini.mrchecker.cucumberStarterKit.exer3.dashboard.runner;

import org.junit.runner.RunWith;

import com.capgemini.mrchecker.test.core.BaseTest;
import com.capgemini.mrchecker.test.core.logger.BFLogger;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
		features = "src\\test\\java\\com\\capgemini\\mrchecker\\cucumberStarterKit\\exer3\\dashboard\\gherkins\\dashboard.feature",
		glue = "com.capgemini.mrchecker.cucumberStarterKit.exer3.dashboard.stepdefs",
		plugin = "json:target/report/exer3/dashboard.json")
public class DashboardTest extends BaseTest {
	
	@Override
	public void setUp() {
		BFLogger.logInfo("I'm in setup");
	}
	
	@Override
	public void tearDown() {
		BFLogger.logInfo("I'm in tearDown");
		
	}
	
}
