package com.capgemini.mrchecker.cucumberStarterKit.exer1.cartDropdown.stepdefs;

import static junit.framework.TestCase.assertTrue;

import cucumber.api.java8.En;

public class CartDropdownStepDefs implements En {
	
	public CartDropdownStepDefs() {
		Given("^I'm on base page as unlogged user$", () -> {
			assertTrue(true);
		});
		
		When("^I add (.+) to basket$", (String name) -> {
			assertTrue(true);
		});
		
		And("^I hover over Cart frame$", () -> {
			assertTrue(true);
		});
		
		And("^I delete added item in cart dropdown$", () -> {
			assertTrue(true);
		});
		
		Then("^I should see cart dropdown$", () -> {
			assertTrue(true);
		});
		
		Then("^I should see empty cart$", () -> {
			assertTrue(true);
		});
		
	}
}
