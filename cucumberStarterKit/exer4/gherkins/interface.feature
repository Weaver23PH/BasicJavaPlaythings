Feature:  ordering items
Background: 
Given I am on product page
And I add some products to the cart
Scenario: Shopping cart summary should display all product details
When I proceed to checkout
Then I should see all the products details

Scenario: Summary card should display proper costs and items
When I proceed to checkout
Then I should see proper selected items and their costs

Scenario: Summary card should show current processing state
And I proceed to checkout
When I click continue
Then I should see the progress bar advance 

Scenario: Billing/contact details form should have all validation rules in place
And I proceed to checkout
When I click continue
And I don't fill the required fields
When I click purchase
And I click continue
Then I should be asked to fill the required fields
