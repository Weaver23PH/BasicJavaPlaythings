package com.capgemini.mrchecker.selenium.pages.store;

import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.capgemini.mrchecker.selenium.core.BasePage;
import com.capgemini.mrchecker.selenium.jsoupHelper.JsoupHelper;
import com.capgemini.mrchecker.test.core.logger.BFLogger;

public class DemoQAMainPage extends BasePage {
	private static final By selectorLoginName = By.cssSelector("span.display-name");
	private static final By selectorCategoryDropdownButton = By.cssSelector("li#menu-item-33");
	private static final By selectorCategoryDropdown = By.cssSelector("li#menu-item-33 ul.sub-menu");
	private static final By selectorCategoryDropdownElements = By.cssSelector("li#menu-item-33 ul.sub-menu a");
	private static final By selectorCategoryAccessories = By.cssSelector("li#menu-item-34 a");
	private static final By selectorCategoryIMacs = By.cssSelector("li#menu-item-35 a");
	private static final By selectorCategoryIPads = By.cssSelector("li#menu-item-36 a");
	private static final By selectorCategorIPhones = By.cssSelector("li#menu-item-37 a");
	private static final By selectorCategoryIPods = By.cssSelector("li#menu-item-38 a");
	private static final By selectorCategoryMacBooks = By.cssSelector("li#menu-item-39 a");
	private static final By selectorSearchBar = By.cssSelector("input.search");
	
	@Override
	public boolean isLoaded() {
		BFLogger.logDebug("The page is loaded");
		return (getDriver().getTitle().equals(pageTitle()));
	}
	
	@Override
	public void load() {
		BFLogger.logDebug("Loading Page");
		getDriver().get("http://store.demoqa.com/");
		getDriver().waitForPageLoaded();
	}
	
	@Override
	public String pageTitle() {
		BFLogger.logDebug("Page Title");
		return "ONLINE STORE | Toolsqa Dummy Test site";
	}
	
	public boolean isUserNotLoggedIn() {
		BFLogger.logDebug("Checking if user is not logged in");
		return getDriver().findElementQuietly(selectorLoginName) == null;
	}
	
	public boolean isNavBarDropdownPresent() {
		BFLogger.logDebug("Checking if navbar is displayed");
		return getDriver().findElementDynamic(selectorCategoryDropdown).isDisplayed();
	}
	
	public void moveToCategory() {
		BFLogger.logDebug("Moving to category button");
		Actions moveTo = new Actions(getDriver());
		WebElement dropdown = getDriver().findElementDynamic(selectorCategoryDropdownButton);
		moveTo.moveToElement(dropdown).perform();
		this.waitForDropdownToDisplay();
	}
	
	public boolean isLoggedIn() {
		BFLogger.logDebug("Checking if user is logged in");
		return getDriver().findElementDynamic(selectorLoginName).getText().length() != 0;
	}
	
	public void deleteCookies() {
		BFLogger.logDebug("Clearing cookies");
		getDriver().manage().deleteAllCookies();
	}
	
	public String getDropdownTextValues() {
		BFLogger.logDebug("Getting text values");
		this.waitForDropdownToDisplay();
		return JsoupHelper.findTexts(selectorCategoryDropdownElements).stream().map(Object::toString).collect(
				Collectors.joining(" "));
	}
	
	public DemoQACategoryPage clickSeletedButton(String element) throws InvalidArgumentException {
		BFLogger.logInfo("Choosing category");
		switch (element) {
		case "Accessories": {
			return this.clickAccessoriesButton();
		}
		case "iMacs": {
			return this.clickIMacsButton();
		}
		case "iPads": {
			return this.clickIPadsButton();
		}
		case "iPhones": {
			return this.clickIPhonesButton();
		}
		case "iPods": {
			return this.clickIPodsButton();
		}
		case "MacBooks": {
			return this.clickMacBooksButton();
		}
		default: {
			throw new InvalidArgumentException("Impossible choice of category");
		}
		}
	}
	
	public void enterAStringIntoTheSearchBar() {
		BFLogger.logDebug("Entering empty string in the search bar");
		getDriver().findElementDynamic(selectorSearchBar).sendKeys(" ");
	}
	
	public DemoQAResultsPage submitSearch() {
		BFLogger.logDebug("Submitting search");
		getDriver().findElementDynamic(selectorSearchBar).submit();
		return new DemoQAResultsPage();
	}
	
	private DemoQACategoryPage clickAccessoriesButton() {
		BFLogger.logInfo("Clicking Accessories button");
		getDriver().findElementDynamic(selectorCategoryAccessories).click();
		return new DemoQACategoryPage();
	}
	
	private DemoQACategoryPage clickIMacsButton() {
		BFLogger.logInfo("Clicking iMacs button");
		getDriver().findElementDynamic(selectorCategoryIMacs).click();
		return new DemoQACategoryPage();
	}
	
	private void waitForDropdownToDisplay() {
		BFLogger.logDebug("Waiting for dropdown to display");
		WebDriverWait waitForDropDownToAppear = new WebDriverWait(getDriver(), 20);
		waitForDropDownToAppear
				.until(ExpectedConditions.attributeContains(selectorCategoryDropdown, "style", "display: block;"));
	}
	
	private DemoQACategoryPage clickIPadsButton() {
		BFLogger.logInfo("Clicking iPads button");
		getDriver().findElementDynamic(selectorCategoryIPads).click();
		return new DemoQACategoryPage();
	}
	
	private DemoQACategoryPage clickIPhonesButton() {
		BFLogger.logInfo("Clicking iPhones button");
		getDriver().findElementDynamic(selectorCategorIPhones).click();
		return new DemoQACategoryPage();
	}
	
	private DemoQACategoryPage clickIPodsButton() {
		BFLogger.logInfo("Clicking iPods button");
		getDriver().findElementDynamic(selectorCategoryIPods).click();
		return new DemoQACategoryPage();
	}
	
	private DemoQACategoryPage clickMacBooksButton() {
		BFLogger.logInfo("Clicking MacBooks button");
		getDriver().findElementDynamic(selectorCategoryMacBooks).click();
		return new DemoQACategoryPage();
	}
	
}
