package com.capgemini.mrchecker.selenium.pages.store;

import org.openqa.selenium.By;

import com.capgemini.mrchecker.selenium.core.BasePage;
import com.capgemini.mrchecker.test.core.logger.BFLogger;

public class DemoQACategoryPage extends BasePage {
	private static final By selectorCategoryTitle = By.cssSelector("h1.entry-title");
	
	@Override
	public boolean isLoaded() {
		BFLogger.logDebug("The page is loaded");
		return (getDriver().getTitle().equals(pageTitle()));
	}
	
	@Override
	public void load() {
		BFLogger.logDebug("This page is not loaded");
	}
	
	@Override
	public String pageTitle() {
		BFLogger.logDebug("Page Title");
		return "Product Category | ONLINE STORE";
	}
	
	public String getCategoryTitleValue() {
		BFLogger.logDebug("getting category title");
		return getDriver().findElementDynamic(selectorCategoryTitle).getText();
	}
}
