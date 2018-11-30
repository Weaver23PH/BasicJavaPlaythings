package com.capgemini.mrchecker.cucumberStarterKit.exer1.cartDropdown.runner;

import org.junit.runner.RunWith;

import com.capgemini.mrchecker.test.core.BaseTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Created by aorszuli on 18.11.2018
 */
@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
		features = "src\\test\\java\\com\\capgemini\\mrchecker\\cucumberStarterKit\\exer1\\cartDropdown\\gherkins\\cartDropdown.feature",
		glue = "com.capgemini.mrchecker.cucumberStarterKit.exer1.cartDropdown.stepdefs",
		plugin = "json:target/report/levelupCucumber/cartDropdown.json")
public class CartDropdownTest extends BaseTest {
	
	@Override
	public void setUp() {
	}
	
	@Override
	public void tearDown() {
	}
}
