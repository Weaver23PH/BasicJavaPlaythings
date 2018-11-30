package com.capgemini.mrchecker.selenium.pages.store;

import org.openqa.selenium.By;

import com.capgemini.mrchecker.selenium.core.BasePage;
import com.capgemini.mrchecker.test.core.logger.BFLogger;

public class DemoQALoginPage extends BasePage {
	private static final By selectorUserLoginName = By.cssSelector("input#log");
	private static final By selectorUserLoginPassword = By.cssSelector("input#pwd");
	private static final By selectorUserLoginSubmitButton = By.cssSelector("input#login");
	private static final By selectorUserLogoutButton = By.cssSelector("div#account_logout");
	private static final By selectorAdminPage = By.cssSelector("aside#meta li:first-child a");
	private static final By selectorLoginName = By.cssSelector("span.display-name");
	private static final String USER_NAME = "misza_c";
	private static final String PASSWORD = "FyHFudYA!20&(#SH";
	
	@Override
	public boolean isLoaded() {
		BFLogger.logDebug("The page is loaded");
		return (getDriver().getTitle().equals(pageTitle()));
	}
	
	@Override
	public void load() {
		BFLogger.logDebug("Loading Page");
		getDriver().get("http://store.demoqa.com/products-page/your-account/");
		getDriver().waitForPageLoaded();
	}
	
	@Override
	public String pageTitle() {
		BFLogger.logDebug("Page Title");
		return "Your Account | ONLINE STORE";
	}
	
	public void logIn() {
		BFLogger.logDebug("Logging in");
		this.enterUserName();
		this.enterPassword();
		this.clickLogInButton();
	}
	
	public boolean isLoggedIn() {
		BFLogger.logDebug("Checking if user is logged in");
		return getDriver().findElementDynamic(selectorLoginName).getText().length() != 0;
	}
	
	public DemoQAProfilePage clickDashboardButton() {
		BFLogger.logDebug("Click the dashboard button");
		getDriver().findElementDynamic(selectorAdminPage).click();
		return new DemoQAProfilePage();
	}
	
	private void enterUserName() {
		BFLogger.logDebug("Entering Username");
		getDriver().findElementDynamic(selectorUserLoginName).sendKeys(USER_NAME);
	}
	
	private void enterPassword() {
		BFLogger.logDebug("Entering User Password");
		getDriver().findElementDynamic(selectorUserLoginPassword).sendKeys(PASSWORD);
	}
	
	private void clickLogInButton() {
		BFLogger.logDebug("Clicking log in button");
		getDriver().findElementDynamic(selectorUserLoginSubmitButton).click();
	}
	
	public void clickLogOutButton() {
		BFLogger.logDebug("Clicking log out button");
		getDriver().findElementDynamic(selectorUserLogoutButton).click();
	}
	
	public void deleteCookies() {
		BFLogger.logDebug("Clearing cookies");
		getDriver().manage().deleteAllCookies();
	}
	
}
