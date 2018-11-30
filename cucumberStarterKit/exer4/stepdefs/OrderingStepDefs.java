package com.capgemini.mrchecker.cucumberStarterKit.exer4.stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.capgemini.mrchecker.selenium.pages.store.DemoQACheckoutPage;
import com.capgemini.mrchecker.selenium.pages.store.DemoQAMainPage;
import com.capgemini.mrchecker.selenium.pages.store.DemoQAResultsPage;

import cucumber.api.java8.En;

public class OrderingStepDefs implements En {
	
	private DemoQAMainPage mainPage;
	private DemoQAResultsPage resultsPage;
	private DemoQACheckoutPage checkoutPage;
	private String firstProductDescription;
	private String secondProductDescription;
	private String thirdProductDescription;
	private double firstProductPrice;
	private double secondProductPrice;
	private double thirdProductPrice;
	private static final double DELTA = 1e-15;
	
	public OrderingStepDefs() {
		Before(() -> {
			mainPage = new DemoQAMainPage();
			mainPage.isLoaded();
			mainPage.deleteCookies();
		});
		
		Given("^I am on product page$", () -> {
			mainPage.enterAStringIntoTheSearchBar();
			resultsPage = mainPage.submitSearch();
			assertTrue("Not on results page", resultsPage.isLoaded());
		});
		
		And("^I add some products to the cart$", () -> {
			resultsPage.clickFirstAddToCartButton();
			resultsPage.clickSecondAddToCartButton();
			resultsPage.clickThirdAddToCartButton();
			firstProductDescription = resultsPage.getProductOneDescriptionValue();
			secondProductDescription = resultsPage.getProductTwoDescriptionValue();
			thirdProductDescription = resultsPage.getProductThreeDescriptionValue();
			firstProductPrice = resultsPage.getProductOnePriceValue();
			secondProductPrice = resultsPage.getProductTwoPriceValue();
			thirdProductPrice = resultsPage.getProductThreePriceValue();
		});
		
		When("^I proceed to checkout$", () -> {
			checkoutPage = resultsPage.clickCheckoutButton();
			
		});
		Then("^The total price should be correct$", () -> {
			double itemPrice = checkoutPage.getItemPriceValue();
			assertEquals("The total item price is different than expected", itemPrice,
					(firstProductPrice + secondProductPrice + thirdProductPrice), DELTA);
		});
		
		Given("^I am not a logged in user$", () -> {
			assertTrue("Not logged in", mainPage.isUserNotLoggedIn());
		});
		
		Then("^I will see a log in menu$", () -> {
			assertTrue("Login form not present", checkoutPage.isCheckoutLoginFormPresent());
		});
		
		When("^I click any of the remove buttons$", () -> {
			checkoutPage.clickRemoveButton();
		});
		
		Then("^The product will be removed from the cart$", () -> {
			assertTrue("The product is still displayed", checkoutPage.isFirstProductRowNotDisplayed());
		});
		
		Then("^The total price should include shipping costs$", () -> {
			double itemPrice = checkoutPage.getItemPriceValue();
			double shipping = checkoutPage.getShippingValue();
			double totalPrice = checkoutPage.getTotalPriceValue();
			assertEquals("The price plus shipping is different than expected", totalPrice, (itemPrice + shipping),
					DELTA);
			
		});
		
		Then("^I should see all the products details$", () -> {
			assertTrue("Product picture not present", checkoutPage.isProductPicturePresent());
			assertTrue("Product name not present", checkoutPage.isProductNamePresent());
			assertTrue("Product quantity not present", checkoutPage.isProductQuantityPresent());
			assertTrue("Product update button not present", checkoutPage.isProductUpdateButtonPresent());
			assertTrue("Product display price not present", checkoutPage.isProductDisplayPricePresent());
			assertTrue("Product total price not present", checkoutPage.isProductTotalPricePresent());
			assertTrue("Product remove button not present", checkoutPage.isProductRemoveButtonPresent());
			
		});
		
		Then("^I should see proper selected items and their costs$", () -> {
			assertTrue("First product description different than expected",
					checkoutPage.getProductNameTextValue().contains(firstProductDescription));
			assertTrue("Second product description different than expected",
					checkoutPage.getProductNameTextValue().contains(secondProductDescription));
			assertTrue("Third product description different than expected",
					checkoutPage.getProductNameTextValue().contains(thirdProductDescription));
			assertTrue("First product price different than expected",
					checkoutPage.getProductPriceTextValue().contains(Double.toString(firstProductPrice)));
			assertTrue("Second product price different than expected",
					checkoutPage.getProductPriceTextValue().contains(Double.toString(secondProductPrice)));
			assertTrue("Third product price different than expected",
					checkoutPage.getProductPriceTextValue().contains(Double.toString(thirdProductPrice)));
			
		});
		
		When("^I click continue$", () -> {
			checkoutPage.clickContinueButton();
		});
		
		Then("^I should see the progress bar advance$", () -> {
			assertTrue("The progress bar has not updated", checkoutPage.isProgressBarUpdated());
		});
		
		When("^I don't fill the required fields$", () -> {
			assertTrue("Input not empty", checkoutPage.isLastNameInputEmpty());
		});
		
		When("^I click purchase$", () -> {
			checkoutPage.clickPurchaseButton();
		});
		
		Then("^I should be asked to fill the required fields$", () -> {
			assertTrue("Validation message not present", checkoutPage.isValidationErrorMessagePresent());
		});
		
		After(() -> {
			// checkoutPage.removeAllItemsFromCart();
			mainPage.deleteCookies();
		});
		
	}
}
