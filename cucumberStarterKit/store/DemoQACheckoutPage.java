package com.capgemini.mrchecker.selenium.pages.store;

import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.capgemini.mrchecker.selenium.core.BasePage;
import com.capgemini.mrchecker.selenium.jsoupHelper.JsoupHelper;
import com.capgemini.mrchecker.test.core.logger.BFLogger;

public class DemoQACheckoutPage extends BasePage {
	private static final By selectorProductPicture = By.cssSelector("td.wpsc_product_image");
	private static final By selectorProductName = By.cssSelector("td.wpsc_product_name a");
	private static final By selectorProductQuantity = By.cssSelector("td.wpsc_product_quantity");
	private static final By selectorProductDisplayPrice = By.cssSelector("td:nth-child(4) span.pricedisplay");
	private static final By selectorProductTotalPrice = By.cssSelector("td.wpsc_product_price");
	private static final By selectorProductUpdateButton = By
			.cssSelector("td.wpsc_product_quantity input[value='Update']");
	private static final By selectorProductRemoveButton = By
			.cssSelector("td.wpsc_product_remove input[value='Remove']");
	private static final By selectorProductRemoveButtonOne = By
			.cssSelector("td.wpsc_product_remove_0 input[value='Remove']");
	private static final By selectorContinueButton = By.cssSelector("a.step2");
	private static final By selectorPurchaseButton = By.cssSelector("input[value='Purchase']");
	private static final By selectorProgressBar = By.cssSelector("div.progress_wrapper.top span.lines");
	private static final By selectorItemPrice = By
			.cssSelector("tr.total_item span.checkout-shipping span.pricedisplay");
	private static final By selectorShippingPrice = By
			.cssSelector("tr.total_shipping span.checkout-shipping span.pricedisplay");
	private static final By selectorTotalPrice = By.cssSelector("span#checkout_total span.pricedisplay");
	private static final By selectorCheckoutLoginForm = By.cssSelector("fieldset.wpsc_left_registration");
	private static final By selectorProductRowThree = By.cssSelector("tr.product_row_2");
	private static final By selectorItemsInCartCount = By.cssSelector("em.count");
	private static final By selectorLastNameInput = By.cssSelector("input#wpsc_checkout_form_3");
	private static final By selectorValidationErrorMessage = By.cssSelector("p.validation-error");
	
	@Override
	public boolean isLoaded() {
		BFLogger.logDebug("The page is loaded");
		return (getDriver().getTitle().equals(pageTitle()));
	}
	
	@Override
	public void load() {
		BFLogger.logDebug("This page is not loaded");
		getDriver().waitForPageLoaded();
	}
	
	@Override
	public String pageTitle() {
		BFLogger.logDebug("Page Title");
		return "Checkout | ONLINE STORE";
	}
	
	public boolean isProductPicturePresent() {
		BFLogger.logDebug("Checking if product picture is displayed");
		return getDriver().findElementDynamic(selectorProductPicture).isDisplayed();
	}
	
	public boolean isProductNamePresent() {
		BFLogger.logDebug("Checking if product name is displayed");
		return getDriver().findElementDynamic(selectorProductName).isDisplayed();
	}
	
	public boolean isProductQuantityPresent() {
		BFLogger.logDebug("Checking if product quantity is displayed");
		return getDriver().findElementDynamic(selectorProductQuantity).isDisplayed();
	}
	
	public boolean isProductTotalPricePresent() {
		BFLogger.logDebug("Checking if product total price is displayed");
		return getDriver().findElementDynamic(selectorProductTotalPrice).isDisplayed();
	}
	
	public boolean isProductDisplayPricePresent() {
		BFLogger.logDebug("Checking if product display price is displayed");
		return getDriver().findElementDynamic(selectorProductDisplayPrice).isDisplayed();
	}
	
	public boolean isProductUpdateButtonPresent() {
		BFLogger.logDebug("Checking if product update button is displayed");
		return getDriver().findElementDynamic(selectorProductUpdateButton).isDisplayed();
	}
	
	public boolean isProductRemoveButtonPresent() {
		BFLogger.logDebug("Checking if product remove button is displayed");
		return getDriver().findElementDynamic(selectorProductRemoveButton).isDisplayed();
	}
	
	public String getProductNameTextValue() {
		BFLogger.logDebug("Getting all product descriptions");
		return JsoupHelper.findTexts(selectorProductName).stream().map(Object::toString).collect(
				Collectors.joining(" "));
	}
	
	public boolean isLastNameInputEmpty() {
		BFLogger.logDebug("Checking if product remove button is displayed");
		return getDriver().findElementDynamic(selectorLastNameInput).getAttribute("value").isEmpty();
	}
	
	public String getProductPriceTextValue() {
		BFLogger.logDebug("Getting all product prices");
		return JsoupHelper
				.findTexts(selectorProductDisplayPrice)
					.stream()
					.map(Object::toString)
					.collect(Collectors.joining(" "))
					.replace("$", "");
	}
	
	public boolean isCheckoutLoginFormPresent() {
		BFLogger.logDebug("Checking if checkout login form is displayed");
		return getDriver().findElementQuietly(selectorCheckoutLoginForm) != null;
	}
	
	public void clickContinueButton() {
		BFLogger.logDebug("Clicking continue button");
		getDriver().findElementDynamic(selectorContinueButton).click();
		getDriver().waitForPageLoaded();
	}
	
	public void clickPurchaseButton() {
		BFLogger.logDebug("Clicking purchase button");
		getDriver().findElementDynamic(selectorPurchaseButton).click();
		getDriver().waitForPageLoaded();
	}
	
	public void clickRemoveButton() {
		BFLogger.logDebug("Clicking remove button");
		getDriver().findElementDynamic(selectorProductRemoveButtonOne).click();
		getDriver().waitForPageLoaded();
	}
	
	public double getItemPriceValue() {
		BFLogger.logDebug("Getting item price without shipping costs");
		return Double.parseDouble(
				getDriver().findElementDynamic(selectorItemPrice).getAttribute("innerText").substring(1).replace(",",
						""));
	}
	
	public double getShippingValue() {
		BFLogger.logDebug("Getting shipping costs");
		return Double.parseDouble(
				getDriver().findElementDynamic(selectorShippingPrice).getAttribute("innerText").substring(1).replace(
						",", ""));
	}
	
	public double getTotalPriceValue() {
		BFLogger.logDebug("Getting total price value");
		return Double.parseDouble(
				getDriver().findElementDynamic(selectorTotalPrice).getAttribute("innerText").substring(1).replace(",",
						""));
	}
	
	public boolean isProgressBarUpdated() {
		this.waitForProgressBarToUpdate();
		BFLogger.logDebug("Checking if progress bar has updated");
		return getDriver().findElementDynamic(selectorProgressBar).getAttribute("style").contains(
				"background-position: -119px center;");
	}
	
	public boolean isFirstProductRowNotDisplayed() {
		BFLogger.logDebug("Checking if a product row has been removed");
		return getDriver().findElementQuietly(selectorProductRowThree) == null;
	}
	
	public boolean isValidationErrorMessagePresent() {
		BFLogger.logDebug("Checking if validation error message is displayed");
		return getDriver().findElementQuietly(selectorValidationErrorMessage) != null;
	}
	
	public void removeAllItemsFromCart() {
		BFLogger.logDebug("Removing all items from cart");
		while (this.getProductInCartCountValue() != 0) {
			this.clickRemoveButton();
			this.waitForCartToUpdate();
		}
	}
	
	private int getProductInCartCountValue() {
		BFLogger.logDebug("Getting the number of products in cart");
		return Integer
				.parseInt(getDriver().findElementDynamic(selectorItemsInCartCount).getText().replaceAll("[^\\d.]", ""));
	}
	
	private void waitForCartToUpdate() {
		BFLogger.logDebug("Waiting for cart to update");
		WebDriverWait waitForCartToUpdate = new WebDriverWait(getDriver(), 10);
		waitForCartToUpdate.until(ExpectedConditions.attributeContains(selectorItemsInCartCount, "innerText",
				Integer.toString((this.getProductInCartCountValue() - 1))));
	}
	
	private void waitForProgressBarToUpdate() {
		BFLogger.logDebug("Waiting for progress bar to update");
		WebDriverWait waitForProgressBarToUpdate = new WebDriverWait(getDriver(), 10);
		waitForProgressBarToUpdate.until(ExpectedConditions.attributeContains(selectorProgressBar, "style",
				"background-position: -119px center;"));
	}
}
