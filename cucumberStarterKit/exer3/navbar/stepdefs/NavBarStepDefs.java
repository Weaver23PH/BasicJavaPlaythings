package com.capgemini.mrchecker.cucumberStarterKit.exer3.navbar.stepdefs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.capgemini.mrchecker.selenium.pages.store.DemoQACategoryPage;
import com.capgemini.mrchecker.selenium.pages.store.DemoQAMainPage;

import cucumber.api.java8.En;

public class NavBarStepDefs implements En {
	private DemoQAMainPage mainPage;
	private DemoQACategoryPage categoryPage;
	private String selectedElement;
	
	public NavBarStepDefs() {
		Before(() -> {
			mainPage = new DemoQAMainPage();
			mainPage.isLoaded();
			mainPage.deleteCookies();
		});
		
		Given("^I am on main page as unlogged user$", () -> {
			assertTrue("Page not loaded", mainPage.isLoaded());
			assertTrue("User logged in", mainPage.isUserNotLoggedIn());
		});
		
		Then("^I should not see navigation bar$", () -> {
			assertFalse("Navigation bar visible", mainPage.isNavBarDropdownPresent());
		});
		Then("^I should see navigation bar with (.+)$", (String element) -> {
			assertTrue("Selected element not visible", mainPage.getDropdownTextValues().contains(element));
		});
		
		When("^I hover over Product Category$", () -> {
			mainPage.moveToCategory();
		});
		
		And("^I click on (.+)$", (String element) -> {
			categoryPage = mainPage.clickSeletedButton(element);
			selectedElement = element;
		});
		
		Then("^I expect to be navigated to correct page$", () -> {
			assertTrue("Category different than expected",
					categoryPage.getCategoryTitleValue().contains(selectedElement));
		});
		
	}
	
}
