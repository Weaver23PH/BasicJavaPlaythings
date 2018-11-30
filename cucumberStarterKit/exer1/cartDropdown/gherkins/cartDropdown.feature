Feature: Cart dropdown

  Scenario Outline: add products and check if dropdown displayed
    Given I'm on base page as unlogged user
    When I add <item> to basket
    And I hover over Cart frame
    Then I should see cart dropdown
    
   Examples:
      | item          |
      | Printed Dress |
      | Blouse        |
      | Printed Dress |

  Scenario Outline: delete item on cart dropdown
    Given I'm on base page as unlogged user
    When I add <item> to basket
    And I delete added item in cart dropdown
    Then I should see empty cart
    
  Examples:
      | item          |
      | Printed Dress |
      | Blouse        |
      | Printed Dress |