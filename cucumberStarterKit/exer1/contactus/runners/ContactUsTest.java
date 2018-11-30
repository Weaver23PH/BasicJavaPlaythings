package com.capgemini.mrchecker.cucumberStarterKit.exer1.contactus.runners;

import org.junit.runner.RunWith;

import com.capgemini.mrchecker.test.core.BaseTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Created by LKURZAJ on 16.10.2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
		features = "src\\test\\java\\com\\capgemini\\mrchecker\\cucumberStarterKit\\exer1\\contactus\\gherkins\\form.feature",
		glue = "com.capgemini.mrchecker.cucumberStarterKit.exer1.contactus.stepdefs",
		plugin = "json:target/report/levelupCucumber/contactus.json")
public class ContactUsTest extends BaseTest {
	@Override
	public void setUp() {
	}
	
	@Override
	public void tearDown() {
	}
}
