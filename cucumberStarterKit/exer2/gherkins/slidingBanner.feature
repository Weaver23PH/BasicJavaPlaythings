Feature: Sliding Banner
Background:
Given I am on the main page of the store
And The sliding banner is visible

Scenario: The view changes after clicking the middle radio button
Given The first scroll radio button is selected
And The mouse is visible
When I click on the middle radio button
Then The view is changed to IPhone

Scenario: Clicking the "Buy now" button redirects to the description page
Given The first scroll radio button is selected
And The mouse is visible
When I click on the "Buy now" button
Then I am redirected to the page with the mouse's description

Scenario:  Clicking the " More Info" link redirects to the description page
Given The first scroll radio button is selected
And The mouse is visible
When I click on the " More Info" link
Then I am redirected to the page with the mouse's description

Scenario: The slider switches views after a certain amount of time
Given Any scroll radio button is selected
And One of the slider frames is visible
When I wait an adequate amount of time 
Then The slider frame changes to the next one

Scenario: Clicking the photo of the product link redirects to the description page
Given Any scroll radio button is selected
And One of the slider frames is visible
When I click on the photo of the product
Then I am redirected to the page with the product's description



