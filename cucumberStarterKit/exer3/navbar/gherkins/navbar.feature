@Feature
@NavigationBar
Feature: navigation bar

  @Visibility
  Scenario: navigation bar not displayed
    Given I am on main page as unlogged user
    Then I should not see navigation bar

  @Visibility
  Scenario Outline: navigation bar is displayed
    Given I am on main page as unlogged user
	When I hover over Product Category
    Then I should see navigation bar with <element>
	Examples:
	|element|
      | Accessories |
      | iMacs   |
      | iPads   |
      | iPhones   |
      | iPods   |
      | MacBooks   |

  @Navigation
  Scenario Outline: check navigation to subPages
    Given I am on main page as unlogged user
	When I hover over Product Category
	And I click on <element>
	Then I expect to be navigated to correct page
	Examples:
	|element|
      | Accessories |
      | iMacs   |
      | iPads   |
      | iPhones   |
      | iPods   |
      | MacBooks   |