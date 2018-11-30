package com.capgemini.mrchecker.cucumberStarterKit.exer1.contactus.stepdefs;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import cucumber.api.java8.En;

/**
 * Created by LKURZAJ on 16.10.2017.
 */
public class FormStepDefs implements En {
	public FormStepDefs() {
		
		Given("^I'm on contact us page as unlogged user$", () -> {
			assertTrue(true);
		});
		
		Then("^I should see (.+) with (.+) value$", (String objName, String val) -> {
			assertEquals("val", "val");
		});
		
		When("^I enter (.+) into (.+)$", (String val, String objName) -> {
			assertTrue(true);
		});
		
		When("^I click Send button$", () -> {
			assertTrue(true);
		});
		
		Then("^I should see (.+) label with green background$", (String text) -> {
			assertTrue(true);
		});
	}
}
