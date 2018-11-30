Feature:  ordering items
Background: 
Given I am on product page
And I add some products to the cart
Scenario: Price should be calculated properly
When I proceed to checkout
And I click continue
Then The total price should be correct

Scenario: Purchases can be done only by logged in customers
Given I am not a logged in user
When I proceed to checkout
And I click continue
Then I will see a log in menu


Scenario: Items can be removed from cart before order finalization
When I proceed to checkout
And I click any of the remove buttons
Then The product will be removed from the cart

Scenario: Shipping cost is being added to total cost
When I proceed to checkout
And I click continue
Then The total price should include shipping costs