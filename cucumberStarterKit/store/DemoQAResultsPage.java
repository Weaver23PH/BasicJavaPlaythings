package com.capgemini.mrchecker.selenium.pages.store;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.capgemini.mrchecker.selenium.core.BasePage;
import com.capgemini.mrchecker.test.core.logger.BFLogger;

public class DemoQAResultsPage extends BasePage {
	
	private static final By selectorBuyButtonOne = By
			.cssSelector("div.product_grid_item:nth-child(1) input.wpsc_buy_button");
	private static final By selectorBuyButtonTwo = By
			.cssSelector("div.product_grid_item:nth-child(2) input.wpsc_buy_button");
	private static final By selectorBuyButtonThree = By
			.cssSelector("div.product_grid_item:nth-child(3) input.wpsc_buy_button");
	private static final By selectorCheckoutButton = By.cssSelector("div#header_cart");
	private static final By selectorProductDescriptionOne = By.cssSelector("div.product_grid_item:nth-child(1) h2 a");
	private static final By selectorProductDescriptionTwo = By.cssSelector("div.product_grid_item:nth-child(2) h2 a");
	private static final By selectorProductDescriptionThree = By.cssSelector("div.product_grid_item:nth-child(3) h2 a");
	private static final By selectorProductPriceOne = By
			.cssSelector("div.product_grid_item:nth-child(1) span.currentprice");
	private static final By selectorProductPriceTwo = By
			.cssSelector("div.product_grid_item:nth-child(2) span.currentprice");
	private static final By selectorProductPriceThree = By
			.cssSelector("div.product_grid_item:nth-child(3) span.currentprice");
	private static final By selectorItemsInCartCount = By.cssSelector("em.count");
	
	@Override
	public boolean isLoaded() {
		BFLogger.logDebug("The page is loaded");
		return (getDriver().getTitle().contains(pageTitle()));
	}
	
	@Override
	public void load() {
		BFLogger.logDebug("This page is not loaded");
		getDriver().waitForPageLoaded();
	}
	
	@Override
	public String pageTitle() {
		BFLogger.logDebug("Page Title");
		return "Search Results";
	}
	
	public void clickFirstAddToCartButton() {
		BFLogger.logDebug("Adding first product to cart");
		getDriver().findElementDynamic(selectorBuyButtonOne).click();
	}
	
	public void clickSecondAddToCartButton() {
		BFLogger.logDebug("Adding second product to cart");
		getDriver().findElementDynamic(selectorBuyButtonTwo).click();
	}
	
	public void clickThirdAddToCartButton() {
		BFLogger.logDebug("Adding third product to cart");
		getDriver().findElementDynamic(selectorBuyButtonThree).click();
	}
	
	public DemoQACheckoutPage clickCheckoutButton() {
		BFLogger.logDebug("Clicking checkout button");
		this.waitForCartToUpdate();
		getDriver().findElementDynamic(selectorCheckoutButton).click();
		return new DemoQACheckoutPage();
	}
	
	public String getProductOneDescriptionValue() {
		BFLogger.logDebug("Getting first product's description");
		return getDriver().findElementDynamic(selectorProductDescriptionOne).getText();
	}
	
	public String getProductTwoDescriptionValue() {
		BFLogger.logDebug("Getting second product's description");
		return getDriver().findElementDynamic(selectorProductDescriptionTwo).getText();
	}
	
	public String getProductThreeDescriptionValue() {
		BFLogger.logDebug("Getting third product's description");
		return getDriver().findElementDynamic(selectorProductDescriptionThree).getText();
	}
	
	public double getProductOnePriceValue() {
		BFLogger.logDebug("Getting first product's price");
		return Double.parseDouble(
				getDriver().findElementDynamic(selectorProductPriceOne).getAttribute("innerText").substring(1).replace(
						",", ""));
	}
	
	public double getProductTwoPriceValue() {
		BFLogger.logDebug("Getting second product's price");
		return Double.parseDouble(
				getDriver().findElementDynamic(selectorProductPriceTwo).getAttribute("innerText").substring(1).replace(
						",", ""));
	}
	
	public double getProductThreePriceValue() {
		BFLogger.logDebug("Getting third product's price");
		return Double.parseDouble(getDriver()
				.findElementDynamic(selectorProductPriceThree)
					.getAttribute("innerText")
					.substring(1)
					.replace(",", ""));
	}
	
	private void waitForCartToUpdate() {
		BFLogger.logDebug("Waiting for progress bar to update");
		WebDriverWait waitForCartToUpdate = new WebDriverWait(getDriver(), 20);
		waitForCartToUpdate.until(ExpectedConditions.attributeContains(selectorItemsInCartCount, "innerText", "3"));
	}
	
}
