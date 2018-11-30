package com.capgemini.mrchecker.cucumberStarterKit.exer3.dashboard.stepdefs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.capgemini.mrchecker.selenium.pages.store.DemoQALoginPage;
import com.capgemini.mrchecker.selenium.pages.store.DemoQAProfilePage;

import cucumber.api.java8.En;

public class DashboardStepDefs implements En {
	private DemoQALoginPage loginPage;
	private DemoQAProfilePage profilePage;
	
	public DashboardStepDefs() {
		Before(() -> {
			loginPage = new DemoQALoginPage();
			loginPage.isLoaded();
			loginPage.deleteCookies();
			loginPage.logIn();
		});
		Given("^I am logged in user$", () -> {
			assertTrue("Not logged in", loginPage.isLoggedIn());
		});
		
		Given("^I am on Dashboard tab$", () -> {
			profilePage = loginPage.clickDashboardButton();
			assertTrue("Not on dashboard", profilePage.isDashboardSelected());
		});
		
		When("^I select Help$", () -> {
			profilePage.clickHelpButton();
		});
		
		Then("^I expect to see (.+) tab$", (String tab) -> {
			assertTrue("The element is not visible", profilePage.getTabNameValue().contains(tab));
		});
		
		When("^I drag and drop activity widget to empty space$", () -> {
			profilePage.dragAndDropElement();
		});
		
		Then("^I expect activity widget to stay on a new place$", () -> {
			assertFalse("The element is empty", profilePage.isDraggedElementTargetEmpty());
		});
		
		When("^I click on screen options$", () -> {
			profilePage.clickOptionsButton();
		});
		
		When("^unmark all options$", () -> {
			profilePage.unsetActivityCheckbox();
			profilePage.unsetEventsCheckbox();
			profilePage.clickOptionsButton();
		});
		
		Then("^I expect to see empty dashboard$", () -> {
			assertTrue("The dashboard is not empty", profilePage.isDashboardEmpty());
			profilePage.clickOptionsButton();
			profilePage.setAllCheckboxes();
		});
		
		After(() -> {
			profilePage.returnToLoginPage();
			loginPage.clickLogOutButton();
			loginPage.deleteCookies();
		});
	}
	
}
