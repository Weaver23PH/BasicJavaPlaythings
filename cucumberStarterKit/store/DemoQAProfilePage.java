package com.capgemini.mrchecker.selenium.pages.store;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.capgemini.mrchecker.selenium.core.BasePage;
import com.capgemini.mrchecker.selenium.jsoupHelper.JsoupHelper;
import com.capgemini.mrchecker.test.core.logger.BFLogger;

public class DemoQAProfilePage extends BasePage {
	private static final By selectorDashboardButton = By.cssSelector("li#menu-dashboard");
	private static final By selectorReturnToLoginButton = By.cssSelector("li#wp-admin-bar-site-name a");
	private static final By selectorHelpButton = By.cssSelector("button#contextual-help-link");
	private static final By selectorOptionsButton = By.cssSelector("button#show-settings-link");
	private static final By selectorTab = By.cssSelector("div.contextual-help-tabs li a");
	private static final By selectorActivityWidget = By.cssSelector("div#dashboard_activity h2.hndle");
	private static final By selectorEmptyDropBoxOne = By.cssSelector("div#postbox-container-1>div");
	private static final By selectorEmptyDropBoxTwo = By.cssSelector("div#postbox-container-2>div");
	private static final By selectorEmptyDropBoxThree = By.cssSelector("div#postbox-container-3>div");
	private static final By selectorEmptyDropBoxThreeAsTarget = By.cssSelector("div#postbox-container-3");
	private static final By selectorEmptyDropBoxFour = By.cssSelector("div#postbox-container-4>div");
	private static final By selectorActivityCheckbox = By.cssSelector("input#dashboard_activity-hide");
	private static final By selectorEventsCheckbox = By.cssSelector("input#dashboard_primary-hide");
	private static final By selectorDropBoxes = By.cssSelector("div.meta-box-sortables.ui-sortable");
	private static int selectedCount = 0;
	
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
		return "Dashboard ‹ ONLINE STORE — WordPress";
	}
	
	public boolean isDashboardSelected() {
		BFLogger.logDebug("Checking if user is on dashboard");
		return getDriver().findElementDynamic(selectorDashboardButton).getAttribute("class").contains("current");
	}
	
	public void clickHelpButton() {
		BFLogger.logDebug("Clicking help button");
		getDriver().findElementDynamic(selectorHelpButton).click();
	}
	
	public void clickOptionsButton() {
		BFLogger.logDebug("Clicking options button");
		getDriver().findElementDynamic(selectorOptionsButton).click();
	}
	
	public String getTabNameValue() {
		BFLogger.logDebug("Getting tab text values");
		return JsoupHelper.findTexts(selectorTab).stream().map(Object::toString).collect(Collectors.joining(" "));
	}
	
	public void setAllCheckboxes() {
		BFLogger.logDebug("Setting all checkboxes");
		if (!this.isSetCheckbox(selectorActivityCheckbox)) {
			getDriver().waitForElementVisible(selectorActivityCheckbox).click();
		}
		if (!this.isSetCheckbox(selectorEventsCheckbox)) {
			getDriver().waitForElementVisible(selectorEventsCheckbox).click();
		}
	}
	
	public void returnToLoginPage() {
		BFLogger.logDebug("Returning to login");
		getDriver().findElementDynamic(selectorReturnToLoginButton).click();
	}
	
	public void unsetActivityCheckbox() {
		BFLogger.logDebug("Unsetting activity checkbox");
		if (this.isSetCheckbox(selectorActivityCheckbox)) {
			getDriver().waitForElementVisible(selectorActivityCheckbox).click();
		}
	}
	
	public void unsetEventsCheckbox() {
		BFLogger.logDebug("Unsetting events checkbox");
		if (this.isSetCheckbox(selectorEventsCheckbox)) {
			getDriver().waitForElementVisible(selectorEventsCheckbox).click();
		}
	}
	
	public boolean isSetCheckbox(By selector) {
		BFLogger.logDebug("checking if the " + selector + " checkbox is checked");
		return getDriver().findElementDynamic(selector).isSelected();
	}
	
	public boolean isDropboxEmpty(By selector) {
		BFLogger.logDebug("checking if " + selector + " dropbox is empty");
		return getDriver().findElementDynamic(selector).getAttribute("class").contains("empty-container");
	}
	
	public void dragAndDropElement() {
		BFLogger.logDebug("Dragging the element");
		WebElement draggedElement = getDriver().findElementDynamic(selectorActivityWidget);
		Actions drag = new Actions(getDriver());
		if (isDropboxEmpty(selectorEmptyDropBoxOne)) {
			WebElement target = getDriver().findElementDynamic(selectorEmptyDropBoxOne);
			drag.dragAndDrop(draggedElement, target).perform();
			selectedCount = 1;
		} else if (isDropboxEmpty(selectorEmptyDropBoxTwo)) {
			WebElement target = getDriver().findElementDynamic(selectorEmptyDropBoxTwo);
			drag.dragAndDrop(draggedElement, target).perform();
			selectedCount = 2;
		} else if (isDropboxEmpty(selectorEmptyDropBoxThree)) {
			WebElement target = getDriver().findElementDynamic(selectorEmptyDropBoxThreeAsTarget);
			drag.dragAndDrop(draggedElement, target).perform();
			selectedCount = 3;
		} else if (isDropboxEmpty(selectorEmptyDropBoxFour)) {
			WebElement target = getDriver().findElementDynamic(selectorEmptyDropBoxFour);
			drag.dragAndDrop(draggedElement, target).perform();
			selectedCount = 4;
		}
		BFLogger.logInfo("selcount: " + selectedCount);
	}
	
	public boolean isDraggedElementTargetEmpty() {
		BFLogger.logDebug("Checking if the element was dragged");
		By target;
		switch (selectedCount) {
		case 1: {
			target = selectorEmptyDropBoxOne;
			break;
		}
		case 2: {
			target = selectorEmptyDropBoxTwo;
			break;
		}
		case 3: {
			target = selectorEmptyDropBoxThree;
			break;
		}
		case 4: {
			target = selectorEmptyDropBoxFour;
			break;
		}
		default:
			target = null;
			break;
		}
		if (target != null) {
			return getDriver().findElementDynamic(target, 3000).getAttribute("class").contains("empty-container");
		}
		return true;
	}
	
	public boolean isDashboardEmpty() {
		BFLogger.logDebug("Checking if the dashboard is empty");
		List<WebElement> dashboardBoxes = getDriver().findElementDynamics(selectorDropBoxes, 3000);
		int count = 0;
		for (WebElement element : dashboardBoxes) {
			if (element.getAttribute("class").contains("empty-container")) {
				count++;
			}
		}
		if (count == 4) {
			return true;
		}
		return false;
	}
}
