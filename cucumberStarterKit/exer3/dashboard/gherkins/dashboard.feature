@Feature 
@Item 
Feature: item 

@Dashboard 
Scenario Outline: dashboard help 
    Given I am logged in user 
    And I am on Dashboard tab 
    When I select Help 
    Then I expect to see <tab> tab 
    Examples: 
        |tab|
        |Overview|
        |Navigation|
        |Layout|
        |Content|
        
        @DragAndDrop 
        Scenario: Changing place of widget 
            Given I am logged in user 
            And I am on Dashboard tab 
            When I drag and drop activity widget to empty space 
            Then I expect activity widget to stay on a new place 
            
        @ScreenOptions 
        Scenario: cleaning up dashboard 
            Given I am logged in user 
            And I am on Dashboard tab 
            When I click on screen options 
            And unmark all options 
            Then I expect to see empty dashboard 
            
            
 